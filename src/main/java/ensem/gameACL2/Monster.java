package ensem.gameACL2;

import java.io.File;
import java.util.concurrent.TimeUnit;

import javafx.scene.shape.Rectangle;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;

public class Monster extends Rectangle {
	
	private static final String HERO_IMAGE_LOC =
            "http://icons.iconarchive.com/icons/raindropmemory/legendora/64/Hero-icon.png";
	
	private static final String HERO_IMAGE_LOC2 =
            "src/main/resources/Images/monster3.png";
	
	private static final String HERO_IMAGE_LOC3 =
            "src/main/resources/Images/run.gif";
	
	private int posX;
	private int posY;
	
	private double dx = 1;
	private double dy = 1;
	
	private int health = 100;
	
	private Image imageStill;
	private Image imageMoving;
	
	private AnimationTimer timer;
	
	//private AnimationTimer timer;
	
	public Monster(int x, int y) {
		imageStill = new Image(new File(HERO_IMAGE_LOC2).toURI().toString());
		setWidth(App.BOX_SIZE);
        setHeight(App.BOX_SIZE);
		
		//this.setImage(imageStill);
		setFill(new ImagePattern(imageStill));
		this.moveMonsterTo(x, y);
	}
	
	public void setHealth(int health) {
		this.health = health;
	}
	
	public int getHealth() {
		return this.health;
	}
	
	public double getPosX() {
		return posX;
	}
	
	public void killHero(Hero hero) {
		hero.die();
	}

	
	public void start(Maze maze, Hero hero) throws InterruptedException {
			int dx = (int) ( Math.round( Math.random() ) - Math.round( Math.random() ));
			int dy = (int) (Math.round( Math.random() )-Math.round( Math.random() )) ;
			
			
			if (maze.isMoveValid(this.posX+dx, this.posY+dy)) {
				this.posX = this.posX+dx;
				this.posY = this.posY+dy;
				relocate(posX * App.BOX_SIZE, posY * App.BOX_SIZE);
			}
			
			if((this.posX == hero.getPosX()) && (this.posY == hero.getPosY())) {
				hero.die();
			}
	}
	
	public void moveMonsterTo(int x, int y) {
		posX = x;
        posY = y;
        //this.setImage(imageMoving);
        //TO-DO: Animation effects
		relocate(posX * App.BOX_SIZE, posY * App.BOX_SIZE);
		
    }
	
	
}
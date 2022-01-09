package ensem.gameACL2;

import java.io.File;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Hero extends ImageView {
	
	private static final String HERO_IMAGE_LOC =
            "http://icons.iconarchive.com/icons/raindropmemory/legendora/64/Hero-icon.png";
	
	private static final String HERO_IMAGE_LOC2 =
           "src/main/resources/Images/idle.gif";
	
	private static final String HERO_IMAGE_LOC3 =
            "src/main/resources/Images/run.gif";
	
	private int posX;
	private int posY;
	
	private int dx = 1;
	private int dy = 1;
	
	private int health = 100;
	
	private Image imageStill;
	private Image imageMoving;
	
	private AnimationTimer timer;
	
	//private AnimationTimer timer;
	
	public Hero(int x, int y) {
		//imageStill = new Image(new File(HERO_IMAGE_LOC2).toURI().toString());
		//imageMoving = new Image(new File(HERO_IMAGE_LOC3).toURI().toString());

		//imageStill = new Image(HERO_IMAGE_LOC, App.BOX_SIZE, App.BOX_SIZE, false, false);
		//imageMoving = new Image(HERO_IMAGE_LOC, App.BOX_SIZE, App.BOX_SIZE, false, false);
		
		
		
		this.setImage(imageStill);
		this.moveHeroTo(x, y);

	}
	
	public void setHealth(int health) {
		this.health = health;
	}
	
	public int getHealth() {
		return this.health;
	}
	
	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}
	
	public Move getNextMove(MoveDirection direction) {
		Move move;
		switch (direction) {
		case UP:{
			move = new Move(posX, posY-dy);
			break;
		}
		case DOWN: {
			move = new Move(posX, posY+dy);
			break;
		}
		case RIGHT:{
			move = new Move(posX+dx, posY); 
			break;
		}
		case LEFT: {
			move = new Move(posX-dx, posY); 
			break;
		}
		default:
			move = new Move(posX, posY);
			break;
		}
		return move;
	}

	public void moveInDirection(MoveDirection direction) {
				
				switch(direction) {
					case UP: {
						setImage(imageMoving);
						moveHeroTo(posX, posY-dy); 
						break;
					}
					case DOWN:{
						setImage(imageMoving);
						moveHeroTo(posX, posY+dy); 
						break;
					}
					case RIGHT: {
						setImage(imageMoving);
						moveHeroTo(posX+dx, posY);
						break;
					}
					case LEFT: moveHeroTo(posX-dx, posY); break;
				}
				System.out.println("x= "+posX);
				System.out.println("y= "+posY);
		
	}
	
	public void idle() {
		setImage(imageStill);
	}
	
	public void moveHeroTo(int x, int y) {
		posX = x;
        posY = y;
        //this.setImage(imageMoving);
        //TO-DO: Animation effects
		relocate(posX * App.BOX_SIZE, posY * App.BOX_SIZE);
		
    }
	
}

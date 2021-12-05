package ensem.gameACL2;

import java.io.File;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Hero extends ImageView {
	
	private static final String HERO_IMAGE_LOC =
            "http://icons.iconarchive.com/icons/raindropmemory/legendora/64/Hero-icon.png";
	
	private static final String HERO_IMAGE_LOC2 =
            "src/main/resources/Images/adventurer-run-02.png";
	
	private double posX;
	private double posY;
	
	private double dx = 1;
	private double dy = 1;
	
	private Image imageStill;
	private Image imageMoving;
	
	//private AnimationTimer timer;
	
	public Hero(double x, double y) {
		imageStill = new Image(new File(HERO_IMAGE_LOC2).toURI().toString(), App.BOX_SIZE, App.BOX_SIZE, false, false);
		imageMoving = new Image(new File(HERO_IMAGE_LOC2).toURI().toString());

		//imageStill = new Image(HERO_IMAGE_LOC, App.BOX_SIZE, App.BOX_SIZE, false, false);
		//imageMoving = new Image(HERO_IMAGE_LOC, App.BOX_SIZE, App.BOX_SIZE, false, false);

		
		this.setImage(imageStill);
		this.moveHeroTo(x, y);

	}
	
	public double getPosX() {
		return posX;
	}

	public void setPosX(double posX) {
		this.posX = posX;
	}

	public double getPosY() {
		return posY;
	}

	public void setPosY(double posY) {
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
			case UP: moveHeroTo(posX, posY-dy); break;
			case DOWN: moveHeroTo(posX, posY+dy); break;
			case RIGHT: moveHeroTo(posX+dx, posY); break;
			case LEFT: moveHeroTo(posX-dx, posY); break;
		}
		
	}
	
	public void moveHeroTo(double x, double y) {
		posX = x;
        posY = y;
        //this.setImage(imageMoving);
        //TO-DO: Animation effects
		relocate(posX * App.BOX_SIZE, posY * App.BOX_SIZE);
		
    }
	
}

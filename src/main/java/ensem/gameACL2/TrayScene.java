package ensem.gameACL2;

import javafx.scene.Scene;

public class TrayScene extends Scene {
	
	private Tray tray;
    private Hero hero;

	
	public TrayScene() {
		hero = new Hero(0, 0);
    	
    	tray = new Tray();
    	tray.createContent();
    	
    	this.super(tray);
    	
    	tray.getChildren().add(hero);
    	
    	//scene = new Scene(tray);
    	
    	hero.moveHeroTo(5, 10);
    	
    	
    	scene.setOnKeyPressed(e-> {
            switch (e.getCode()) {
                case UP:    hero.moveInDirection(MoveDirection.UP); break;
                case DOWN:  hero.moveInDirection(MoveDirection.DOWN); break;
                case LEFT:  hero.moveInDirection(MoveDirection.LEFT); break;
                case RIGHT: hero.moveInDirection(MoveDirection.RIGHT); break;
            }
        });
    	
    	
	}

}

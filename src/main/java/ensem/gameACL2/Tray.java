package ensem.gameACL2;

import javafx.scene.image.Image;

import java.io.File;

import javafx.scene.Group;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;

public class Tray extends Pane {
	
	private static final String PASSAGE_BOX_IMAGE =
            "src/main/resources/Images/passage.png";
	
	private static final String TREASURE_BOX_IMAGE =
            "src/main/resources/Images/treasure.jpg";
	
	private static final String TRAP_BOX_IMAGE =
            "src/main/resources/Images/campfire.gif";
	
	private static final String MAGIC_BOX_IMAGE =
            "src/main/resources/Images/campfire.gif";
	
	private static final String WALL_BOX_IMAGE =
            "src/main/resources/Images/wall.jpg";
	
	
	private Box[][] board;

    private Group boxGroup;	
	
	public Tray() {
		board = new Box[App.WIDTH][App.HEIGHT];
		boxGroup = new Group();
		
		this.setPrefSize(App.WIDTH * App.BOX_SIZE, App.HEIGHT * App.BOX_SIZE);
        this.getChildren().addAll(boxGroup);
	}
	
	public void createContent(Maze maze) {
		Image imgPassage = new Image(new File(PASSAGE_BOX_IMAGE).toURI().toString(), App.BOX_SIZE, App.BOX_SIZE, false, false);
		Image imgTreasure = new Image(new File(TREASURE_BOX_IMAGE).toURI().toString(), App.BOX_SIZE, App.BOX_SIZE, false, false);
		Image imgWall = new Image(new File(WALL_BOX_IMAGE).toURI().toString(), App.BOX_SIZE, App.BOX_SIZE, false, false);
		Image imgTrap = new Image(new File(TRAP_BOX_IMAGE).toURI().toString(), App.BOX_SIZE, App.BOX_SIZE, false, false);
		for (int y = 0; y < App.HEIGHT; y++) {
            for (int x = 0; x < App.WIDTH; x++) {
            	Box box;
            	switch (maze.getBoxType(x, y)) {
					case PASSAGE: box = new Box(imgPassage, x, y);break;
					case TREASURE: box = new Box(imgTreasure, x, y);break;
					case TRAP: box = new Box(imgTrap, x, y);break;
					case MAGIC: box = new Box(imgTrap, x, y);break;
					case WALL: box = new Box(imgWall, x, y);break;
					default:
						box = new Box(imgPassage, x, y);
						break;
				}
                board[x][y] = box;
                boxGroup.getChildren().add(box);
            }
		}
	}
	

}

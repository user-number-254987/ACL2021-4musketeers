package ensem.gameACL2;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * JavaFX App
 */
public class App extends Application {
	
	
	public static int BOX_SIZE =30;
	public static int HEIGHT = 12;
	public static int WIDTH = 24;
	
	public static double INCREMENT = 1;

    private static Scene scene;
    
    private Hero hero;
    
    
    
    Maze maze;
    public boolean GameOver(Hero hero,ArrayList<Monster> monsters) {
        boolean gameOver = false;

    		for(int i = 0; i<monsters.size();i++) {
    			if(monsters.get(i).getPosX()==hero.getPosX() && monsters.get(i).getPosY()==hero.getPosY()) {
    				gameOver=true;
    				break;
    				}
    			}
    		return gameOver;
        }

    @Override
    public void start(Stage stage) throws IOException, InterruptedException {
    	
    	hero = new Hero(0, 0);
    	
    	Tray tray = new Tray();
    	
    	
    	Maze maze = new Maze("src/main/resources/MazBoxeTypes/text");
    	
    	
    	
    	tray.createContent(maze);
    	
    	tray.getChildren().add(hero);
    	Monster monster1 = new Monster(2, 4);
    	Monster monster2 = new Monster(5, 7);
    	Monster monster3 = new Monster(12, 3);
    	Monster monster4 = new Monster(6, 4);
    	ArrayList<Monster> monsters = new ArrayList<Monster>();
    	monsters.add(monster1);
    	monsters.add(monster2);
    	monsters.add(monster3);
    	monsters.add(monster4);
    	
		monster1.start(maze, hero);
		monster2.start(maze, hero);
		monster3.start(maze, hero);
		monster4.start(maze, hero);
    	
    	tray.getChildren().add(monster1);
    	tray.getChildren().add(monster2);
    	tray.getChildren().add(monster3);
    	tray.getChildren().add(monster4);
    	
    	
    	
    	scene = new Scene(tray);
    	
    	hero.moveHeroTo(1, 1);
    	
    	
		
		
		
		
		Timer tm = new java.util.Timer();
		tm.schedule(new TimerTask(){
			//override run method
			@Override
			public void run() {
				if (GameOver(hero,monsters)==false){
					
				}
				try {
					monster1.start(maze, hero);
					monster2.start(maze, hero);
					monster3.start(maze, hero);
					monster4.start(maze, hero);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					}
				
				}
			
			}, 1500, 1400);
		
		
		AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
            	scene.setOnKeyPressed(e-> {
            		if( !(hero.isDead())){
                    switch (e.getCode()) {
                        case UP:    {
                        	Move move = hero.getNextMove(MoveDirection.UP);
                        	if (maze.isMoveValid((int) move.getX(), (int) move.getY())) {
                        		hero.moveInDirection(MoveDirection.UP);
                        		switch(maze.getBoxType((int) move.getX(), (int) move.getY())) {
                        			case TRAP: {
                        				hero.die();
                        				break;
                        			}
                        			case TREASURE:{
                        				//hero.win();
                        				hero.moveHeroTo(1, 1);
                        				break;
                        			}
                        			default: break;
                        		
                        		}
                        	}
                        	break;
                        }
                        case DOWN:  {
                        	Move move = hero.getNextMove(MoveDirection.DOWN);
                        	if (maze.isMoveValid((int) move.getX(), (int) move.getY())) {
                        		hero.moveInDirection(MoveDirection.DOWN);
                        		switch(maze.getBoxType((int) move.getX(), (int) move.getY())) {
                    			case TRAP: {
                    				hero.die();
                    				break;
                    			}
                    			case TREASURE:{
                    				//hero.win();
                    				hero.moveHeroTo(1, 1);
                    				break;
                    			}
                    			default: break;
                    		
                    		}
                        	}
                        	break;
                        
                        }
                        case LEFT: {
                        	Move move = hero.getNextMove(MoveDirection.LEFT);
                        	if (maze.isMoveValid((int) move.getX(), (int) move.getY())) {
                        		hero.moveInDirection(MoveDirection.LEFT);
                        		switch(maze.getBoxType((int) move.getX(), (int) move.getY())) {
                    			case TRAP: {
                    				hero.die();
                    				break;
                    			}
                    			case TREASURE:{
                    				//hero.win();
                    				hero.moveHeroTo(1, 1);
                    				break;
                    			}
                    			default: break;
                    		
                    		}
                        	}
                        	break;                }
                        case RIGHT: {
                        	Move move = hero.getNextMove(MoveDirection.RIGHT);
                        	if (maze.isMoveValid((int) move.getX(), (int) move.getY())) {
                        		hero.moveInDirection(MoveDirection.RIGHT);
                        		switch(maze.getBoxType((int) move.getX(), (int) move.getY())) {
                    			case TRAP: {
                    				hero.die();
                    				break;
                    			}
                    			case TREASURE:{
                    				hero.moveHeroTo(1, 1);
                    				//hero.win();
                    				break;
                    			}
                    			default: break;
                    		
                    		}
                        	}
                        	break;
                        }
                        default: break;
                    }}
                });
            	
            	scene.setOnKeyReleased(e->{
            		if (hero.isDead()) {
            			hero.die();
            		} else {
            			hero.idle();
            		}
                });
            }
        };
        
        timer.start();
        
        
    	
     
    	
    	stage.setScene(scene);
    	stage.show();
        
    };
   

	/*
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
	*/
    public static void main(String[] args) {
        launch();
        
    	
    }

}
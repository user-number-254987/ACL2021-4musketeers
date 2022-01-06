package ensem.gameACL2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Maze {
	private BoxType[][] board;
	private int height;
	private int width;

	public Maze(String filePath) throws FileNotFoundException {
		super();
		
		int index = 0;

	    File file = new File(filePath);
	    Scanner input = new Scanner(file);
	    
	    String[][] cases = new String[App.HEIGHT][App.WIDTH];
	    while (input.hasNextLine() && index < cases.length) {
	    	cases[index] = input.nextLine().split(" "); 
	        index++;
	    }
	    
	    input.close();
	    
	    board = new BoxType[App.WIDTH][App.HEIGHT];
	    for (int j=0; j < App.HEIGHT; j++) {
	    	for (int i=0; i < App.WIDTH; i++) {
	    		switch (cases[j][i]) {
					case "PASSAGE": board[i][j] = BoxType.PASSAGE; break;
					case "TREASURE": board[i][j] = BoxType.TREASURE; break;
					case "TRAP": board[i][j] = BoxType.TRAP; break;
					case "MAGIC": board[i][j] = BoxType.MAGIC; break;
					case "WALL": board[i][j] = BoxType.WALL; break;
					default:
						board[i][j] = BoxType.WALL;
						break;
				}	    		 
	    	}
	    }
	}
	
	/*
	public static void main(String[] args) throws FileNotFoundException {
		Maze maze = new Maze("src/main/resources/MazBoxeTypes/text");
		for (int i=0; i < App.WIDTH; i++) {
			for (int j=0; j < App.HEIGHT; j++) {
				System.out.print(maze.getBoxType(i, j).toString() + " ");
			}
			System.out.print("\n");
		}
		
	}
	*/
	public BoxType getBoxType(int i, int j) {
		return board[i][j];
	}
	
	public boolean isMoveValid(int x, int y) {
		switch (board[x][y]) {
		case PASSAGE: return true;
		case TREASURE: return true;
		case TRAP: return true;
		case MAGIC: return true;
		case WALL: return false;
		default:
			return true;
		}
	}
	
	
	
	
	
}

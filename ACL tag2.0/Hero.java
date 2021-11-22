package game;
import java.io.Console;



public class Hero extends Entity {
	public Hero(int[] posInit) {
		super(posInit);
	}
	
	public int[] moveInDirection() {
		int move[] = {0, 0};
		Console console = System.console();
		int posI = Integer.parseInt(console.readLine("La position i: "));
		int posJ = Integer.parseInt(console.readLine("La position j: "));
		
		move[0] = posI;
		move[1] = posJ;
		return move;
	}
	
}

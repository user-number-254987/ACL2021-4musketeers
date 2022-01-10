package ensem.gameACL2;

public class Move {
	private int X;
	private int Y;
	
	public Move() {
		super();
		X = 0;
		Y = 0;
	}

	public Move(int x, int y) {
		super();
		X = x;
		Y = y;
	}

	public int getX() {
		return X;
	}

	public void setX(int x) {
		X = x;
	}

	public int getY() {
		return Y;
	}

	public void setY(int y) {
		Y = y;
	}
	
	
}

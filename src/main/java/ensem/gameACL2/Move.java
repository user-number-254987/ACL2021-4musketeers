package ensem.gameACL2;

public class Move {
	private double X;
	private double Y;
	
	public Move() {
		super();
		X = 0;
		Y = 0;
	}

	public Move(double x, double y) {
		super();
		X = x;
		Y = y;
	}

	public double getX() {
		return X;
	}

	public void setX(double x) {
		X = x;
	}

	public double getY() {
		return Y;
	}

	public void setY(double y) {
		Y = y;
	}
	
	
}

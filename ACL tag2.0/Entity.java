package game;


public class Entity {
	private int[] currentPosition;
	private int hitPoints;
	
	
	public Entity(int[] currentPosition){
		setHitPoints(100);
		this.setCurrentPosition(currentPosition);

	}
	
	public void updatePosition(int [] move) {
		this.setCurrentPosition(move);
	}
	
	public void increaseHitPoints() {
		this.setHitPoints(this.getHitPoints() + 5);
	}
	
	public void decreaseHitPoints() {
		this.setHitPoints(this.getHitPoints() - 5);
	}
	
	public void die() {
		this.setHitPoints(0);
	}

	public int[] getCurrentPosition() {
		return currentPosition;
	}

	public void setCurrentPosition(int[] currentPosition) {
		this.currentPosition = currentPosition;
	}

	public int getHitPoints() {
		return hitPoints;
	}

	public void setHitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
	}
}

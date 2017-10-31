package model;

public class Checker {

	int type;
	int currentXPosition;
	int currentYPosition;
	public Checker(int type, int currentXPosition, int currentYPosision) {
		super();
		this.type = type;
		this.currentXPosition = currentXPosition;
		this.currentYPosition = currentYPosition;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getCurrentXPosition() {
		return currentXPosition;
	}
	public void setCurrentXPosition(int currentXPosition) {
		this.currentXPosition = currentXPosition;
	}
	public int getCurrentYPosition() {
		return currentYPosition;
	}
	public void setCurrentYPosision(int currentYPosition) {
		this.currentYPosition = currentYPosition;
	}
	
	
	
	
	
}

package model;

public class Checker extends Board {

	int type;
	int currentXPosition;
	int currentYPosition;
	
	
	public Checker(int type, int currentXPosition, int currentYPosition) {
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


	public void setCurrentYPosition(int currentYPosition) {
		this.currentYPosition = currentYPosition;
	}


	@Override
	public String toString() {
		return "Checker [type=" + type + ", currentXPosition=" + currentXPosition + ", currentYPosition="
				+ currentYPosition + "]";
	}
	
	
	

	
}

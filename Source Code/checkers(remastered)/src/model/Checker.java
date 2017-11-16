package model;
/*
 * This class is used to create the Pieces for the game
 */
public class Checker {
/*
 * type: 
 * 1: BLACK 
 * 2: WHITE
 * 3: BLACK KING
 * 4: WHITE KING
 */
	int type;
	int currentXPosition;
	int currentYPosition;
	
	
	//Constructor for the class
	public Checker(int type, int currentXPosition, int currentYPosition) {
		super();
		this.type = type;
		this.currentXPosition = currentXPosition;
		this.currentYPosition = currentYPosition;
	}
	//Getters and Setters
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
	//ToString
	@Override
	public String toString() {
		
		String s = "Type" + "\t" + "CurrentXPosition" + "\t" + "CurrentYPosition";
		s += type + "\t" + currentXPosition + "\t" + currentYPosition;
		
		return s;
	}
	
	
	
	
	
}

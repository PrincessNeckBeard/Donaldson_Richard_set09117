package model;

import java.util.ArrayList;



public class Checker extends Board {

	int type;
	int currentXPosition;
	int currentYPosition;
	public ArrayList<Checker> blackPieces = new ArrayList<Checker>();
	public ArrayList<Checker> whitePieces = new ArrayList<Checker>();

	public Checker(int type, int currentXPosition, int currentYPosition) {
		super();
		this.type = type;
		this.currentXPosition = currentXPosition;
		this.currentYPosition = currentYPosition;
	}

	
	public Checker() {
		// TODO Auto-generated constructor stub
	}


	public void populate() {

	Checker blackChecker1 = new Checker(1,1,0);
	Checker blackChecker2 = new Checker(1,3,0);
	Checker blackChecker3 = new Checker(1,5,0);
	Checker blackChecker4 = new Checker(1,7,0);
	Checker blackChecker5 = new Checker(1,0,1);
	Checker blackChecker6 = new Checker(1,2,1);
	Checker blackChecker7 = new Checker(1,4,1);
	Checker blackChecker8 = new Checker(1,6,1);
	Checker blackChecker9 = new Checker(1,1,2);
	Checker blackChecker10 = new Checker(1,3,2);
	Checker blackChecker11 = new Checker(1,5,2);
	Checker blackChecker12 = new Checker(1,6,2);

	blackPieces.add(blackChecker1);
	blackPieces.add(blackChecker2);
	blackPieces.add(blackChecker3);
	blackPieces.add(blackChecker4);
	blackPieces.add(blackChecker5);
	blackPieces.add(blackChecker6);
	blackPieces.add(blackChecker7);
	blackPieces.add(blackChecker8);
	blackPieces.add(blackChecker9);
	blackPieces.add(blackChecker10);
	blackPieces.add(blackChecker11);
	blackPieces.add(blackChecker12);

	Checker whiteChecker1 = new Checker(2,0,5);
	Checker whiteChecker2 = new Checker(2,2,5);
	Checker whiteChecker3 = new Checker(2,4,5);
	Checker whiteChecker4 = new Checker(2,6,5);
	Checker whiteChecker5 = new Checker(2,1,6);
	Checker whiteChecker6 = new Checker(2,3,6);
	Checker whiteChecker7 = new Checker(2,5,6);
	Checker whiteChecker8 = new Checker(2,7,6);
	Checker whiteChecker9 = new Checker(2,0,7);
	Checker whiteChecker10 = new Checker(2,2,7);
	Checker whiteChecker11 = new Checker(2,4,7);
	Checker whiteChecker12 = new Checker(2,6,7);

	whitePieces.add(whiteChecker1);
	whitePieces.add(whiteChecker2);
	whitePieces.add(whiteChecker3);
	whitePieces.add(whiteChecker4);
	whitePieces.add(whiteChecker5);
	whitePieces.add(whiteChecker6);
	whitePieces.add(whiteChecker7);
	whitePieces.add(whiteChecker8);
	whitePieces.add(whiteChecker9);
	whitePieces.add(whiteChecker10);
	whitePieces.add(whiteChecker11);
	whitePieces.add(whiteChecker12);
	}

	
	
	
	public Checker findChecker(int xValue, int yValue) {
		for(Checker checker : blackPieces) {
			if((checker.getCurrentXPosition() == xValue) && (checker.getCurrentYPosition() == yValue)) {
				return checker;
			}
		}
		return null;
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


	public ArrayList<Checker> getBlackPieces() {
		return blackPieces;
	}


	public void setBlackPieces(ArrayList<Checker> blackPieces) {
		this.blackPieces = blackPieces;
	}


	public ArrayList<Checker> getWhitePieces() {
		return whitePieces;
	}


	public void setWhitePieces(ArrayList<Checker> whitePieces) {
		this.whitePieces = whitePieces;
	}


	@Override
	public String toString() {
		return "Checker [type=" + type + ", currentXPosition="
				+ currentXPosition + ", currentYPosition=" + currentYPosition
				+ ", blackPieces=" + blackPieces + ", whitePieces="
				+ whitePieces + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
}

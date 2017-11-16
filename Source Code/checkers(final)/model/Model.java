package model;

import java.util.ArrayList;
import java.util.LinkedList;


/*
 * Stores all the data used for the game
 * 
 */

public class Model {
	//ArrayList to store all the Black Pieces
	public ArrayList<Checker> blackPieces = new ArrayList<Checker>();
	//ArrayList to store all the White Pieces
	public ArrayList<Checker> whitePieces = new ArrayList<Checker>();
	//LinkedList to store the moves played  
	public LinkedList<Move> moves = new LinkedList<Move>();
	 public LinkedList<Move> copy = new LinkedList<Move>();
	
	 //creates and populates the game with the game pieces
	public void populate() {
		//creates a checker object and adds it to the ArrayList for Black Pieces
		blackPieces.add(new Checker(1,1,0));
		blackPieces.add(new Checker(1,3,0));
		blackPieces.add(new Checker(1,5,0));
		blackPieces.add(new Checker(1,7,0));
		blackPieces.add(new Checker(1,0,1));
		blackPieces.add(new Checker(1,2,1));
		blackPieces.add(new Checker(1,4,1));
		blackPieces.add(new Checker(1,6,1));
		blackPieces.add(new Checker(1,1,2));
		blackPieces.add(new Checker(1,3,2));
		blackPieces.add(new Checker(1,5,2));
		blackPieces.add(new Checker(1,7,2));
		
		//creates a checker object and adds it to the ArrayList for White Pieces
		whitePieces.add(new Checker(2,0,5));
		whitePieces.add(new Checker(2,2,5));
		whitePieces.add(new Checker(2,4,5));
		whitePieces.add(new Checker(2,6,5));
		whitePieces.add(new Checker(2,1,6));
		whitePieces.add(new Checker(2,3,6));
		whitePieces.add(new Checker(2,5,6));
		whitePieces.add(new Checker(2,7,6));
		whitePieces.add(new Checker(2,0,7));
		whitePieces.add(new Checker(2,2,7));
		whitePieces.add(new Checker(2,4,7));
		whitePieces.add(new Checker(2,6,7));
		
		//used for testing Kings
		
		/*
		blackPieces.add(new Checker(3,3,3));
		whitePieces.add(new Checker(4,1,3));
		*/
		
		
		
	}

//Finds the checker based on the Origin inputs
	public Checker findChecker(int xValue, int yValue) {
		//checks all the Black Pieces currently in play
		for(Checker checker : blackPieces) {
			if((xValue == checker.getCurrentXPosition()) && (yValue == checker.getCurrentYPosition())) {
				return checker;
			}
		}
		//checks all the White Pieces currently in play
		for(Checker checker : whitePieces) {
			if((xValue == checker.getCurrentXPosition()) && (yValue == checker.getCurrentYPosition())) {
				return checker;
			}
		}
		//returns null if nothing is found
		return null;
		
	}
	//Adds Move to LinkedList to be used for Undo/Redo
	public Move addMove(int xOrigin, int yOrigin, int xMove, int yMove) {
		Move move = new Move(xOrigin, yOrigin, xMove, yMove);
		moves.add(move);
		System.out.println("Move added");
		
		return move;
	}
	//Updates the position of the checker after it has been moved
	public void updateChecker(Move move, Checker checker, int turn) {
		int i = 0;
		
		
		//if it's Blacks Turn
		if(turn == 1) {
			for(Checker c: blackPieces) {
				if((checker.getCurrentXPosition() == c.getCurrentXPosition()) && (checker.getCurrentYPosition() == c.getCurrentYPosition())) {
					checker.setCurrentXPosition(move.getxMove());
					checker.setCurrentYPosision(move.getyMove());
				blackPieces.set(i, checker);
				}
						i++;
			}
			
			//If it's Whites turn
		} else if (turn == 2) {
			for(Checker c: whitePieces) {
			//	System.out.println("CheckerXPos " + c.getCurrentXPosition());
				if((checker.getCurrentXPosition() == c.getCurrentXPosition()) && (checker.getCurrentYPosition() == c.getCurrentYPosition())) {
					checker.setCurrentXPosition(move.getxMove());
					checker.setCurrentYPosision(move.getyMove());
				whitePieces.set(i, checker);
				}
						i++;
			} 
				
			} else {
				System.out.println("Checker not found");
		}
		
		
	}
	
	public void undoChecker(Move move, Checker checker) {
		int i = 0;
		//if it's Blacks Turn
				if((checker.getType() == 1) || (checker.getType() == 3)) {
					for(Checker c: blackPieces) {
						if((checker.getCurrentXPosition() == c.getCurrentXPosition()) && (checker.getCurrentYPosition() == c.getCurrentYPosition())) {
							checker.setCurrentXPosition(move.getxOrigin());
							checker.setCurrentYPosision(move.getyOrigin());
						blackPieces.set(i, checker);
						}
								i++;
					}
					
					//If it's Whites turn
				} else if ((checker.getType() == 2) || (checker.getType() == 4)) {
					for(Checker c: whitePieces) {
					//	System.out.println("CheckerXPos " + c.getCurrentXPosition());
						if((checker.getCurrentXPosition() == c.getCurrentXPosition()) && (checker.getCurrentYPosition() == c.getCurrentYPosition())) {
							checker.setCurrentXPosition(move.getxOrigin());
							checker.setCurrentYPosision(move.getyOrigin());
						whitePieces.set(i, checker);
						}
								i++;
					} 
						
					} else {
						System.out.println("Checker not found");
				}
				
				
	}
	
	public void redoChecker(Move move, Checker checker) {
		int i = 0;
		
		
		//if it's Blacks Turn
		if((checker.getType() == 1) || (checker.getType() == 3)) {
			for(Checker c: blackPieces) {
				if((checker.getCurrentXPosition() == c.getCurrentXPosition()) && (checker.getCurrentYPosition() == c.getCurrentYPosition())) {
					checker.setCurrentXPosition(move.getxMove());
					checker.setCurrentYPosision(move.getyMove());
				blackPieces.set(i, checker);
				}
						i++;
			}
			
			//If it's Whites turn
		} else if ((checker.getType() == 2 ) || (checker.getType() == 4) ) {
			for(Checker c: whitePieces) {
			//	System.out.println("CheckerXPos " + c.getCurrentXPosition());
				if((checker.getCurrentXPosition() == c.getCurrentXPosition()) && (checker.getCurrentYPosition() == c.getCurrentYPosition())) {
					checker.setCurrentXPosition(move.getxMove());
					checker.setCurrentYPosision(move.getyMove());
				whitePieces.set(i, checker);
				}
						i++;
			} 
				
			} else {
				System.out.println("Checker not found");
		}
		
		
	}
	
	
	
	//outputs the list of checkers still in play for testing purposes
	public void outputCheckers() {
		System.out.println("Black Pieces");
		for(Checker checkers: blackPieces) {
			System.out.println(checkers.toString());
		}
		
		System.out.println("White Pieces");
		for(Checker checkers: whitePieces) {
			System.out.println(checkers.toString());
		}
		
		
	}
	
	//Used to output the list of moves that have been played to the console for testing
	public void printList() {
		System.out.println("Main Moves");
		for(Move m: moves) {
			
			System.out.println(m.toString());
		}
		System.out.println("Copy Moves");
		for(Move m: copy) {
			System.out.println(m.toString());
		}
		
	}
	





}

package model;

import java.util.ArrayList;
import java.util.LinkedList;

public class Model {
	public ArrayList<Checker> blackPieces = new ArrayList<Checker>();
	public ArrayList<Checker> whitePieces = new ArrayList<Checker>();
	 public LinkedList<Move> moves = new LinkedList<Move>();
	 public LinkedList<Move> copy = new LinkedList<Move>();
	
	public void populate() {
		
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
		blackPieces.add(new Checker(1,6,2));
		
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
		
		
		
		
		
	}


	public Checker findChecker(int xValue, int yValue) {
		
		for(Checker checker : blackPieces) {
			if((xValue == checker.getCurrentXPosition()) && (yValue == checker.getCurrentYPosition())) {
				return checker;
			}
		}
		return null;
	}
	
	public Move addMove(int xOrigin, int yOrigin, int xMove, int yMove) {
		Move move = new Move(xOrigin, yOrigin, xMove, yMove);
		moves.add(move);
		System.out.println("Move added");
		
		return move;
	}
	
	public void updateChecker(Move move, Checker checker) {
		int i = 0;
		
		if(checker.getType() % 2 != 0) {
			for(Checker checkers: blackPieces) {
				if((checker.getCurrentXPosition() == checkers.getCurrentXPosition()) && (checker.getCurrentYPosition() == checkers.getCurrentYPosition())) {
					checker.setCurrentXPosition(move.getxMove());
					checker.setCurrentYPosision(move.getyMove());
				blackPieces.set(i, checker);
				}
						i++;
			}
		} else if (checker.getType() % 2 == 0) {
			for(Checker checkers: whitePieces) {
				System.out.println("CheckerXPos " + checkers.getCurrentXPosition());
				if((move.getxMove() == checkers.getCurrentXPosition()) && (move.getyMove() == checkers.getCurrentYPosition())) {
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
	





}

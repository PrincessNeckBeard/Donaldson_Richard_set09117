package model;

import java.util.ArrayList;
import java.util.LinkedList;
import model.*;
public class Model {
	public ArrayList<Checker> blackPieces = new ArrayList<Checker>();
	public ArrayList<Checker> whitePieces = new ArrayList<Checker>();
	 public LinkedList<Move> moves = new LinkedList<Move>();
	 public LinkedList<Move> copy = new LinkedList<Move>();
	
	public void populate() {
		/*
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
		*/
		
		blackPieces.add(new Checker(1,3,3));
		whitePieces.add(new Checker(2,1,3));
		
		
		
		
	}


	public Checker findChecker(int xValue, int yValue) {
		
		for(Checker checker : blackPieces) {
			if((xValue == checker.getCurrentXPosition()) && (yValue == checker.getCurrentYPosition())) {
				return checker;
			}
		}
		
		for(Checker checker : whitePieces) {
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
	
	public void updateChecker(Move move, Checker checker, int turn) {
		int i = 0;
		
		
		
		if(turn == 1) {
			for(Checker c: blackPieces) {
				if((checker.getCurrentXPosition() == c.getCurrentXPosition()) && (checker.getCurrentYPosition() == c.getCurrentYPosition())) {
					checker.setCurrentXPosition(move.getxMove());
					checker.setCurrentYPosision(move.getyMove());
				blackPieces.set(i, checker);
				}
						i++;
			}
		} else if (turn == 2) {
			for(Checker c: whitePieces) {
				System.out.println("CheckerXPos " + c.getCurrentXPosition());
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
	





}

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
		System.out.println("xValue in findChecker" + xValue);
		System.out.println("yValue in findChecker" + yValue);
		
		for(Checker checker : blackPieces) {
		//	checker.toString();
			System.out.println("getCurrentXPos" + checker.getCurrentXPosition());
			System.out.println("getCurrentYPos" + checker.getCurrentYPosition());
			
			
			
			
			if((checker.getCurrentXPosition() == xValue) && (checker.getCurrentYPosition() == yValue)) {
				System.out.println("Returning checker");
				return checker;
			}
		}
		System.out.println("returning null");
		return null;
	}
	
	
	





}

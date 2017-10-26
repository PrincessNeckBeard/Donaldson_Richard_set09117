package controller;

import java.util.Scanner;

import model.Checker;
import model.Model;
import model.Move;


public class Game {

	static Scanner keyboard = new Scanner(System.in);

	
	
	public static void printBoard(int[][] board) {
	
		String xAxis[] = {"A", "B", "C", "D", "E", "F", "G", "H"};
		
		for(int i = 0; i<8;i++) {
			System.out.print((i + 1) + "\t");
			for(int j = 0; j<8;j++) {
				System.out.print(board[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();
		for(int k = 0; k <8; k++) {
			System.out.print("\t" + xAxis[k]);
		}
		System.out.println();
	}
	
	public static int convertXPosition(String xPosition) {
		System.out.println("ConvertingXPosition");
		xPosition = xPosition.toUpperCase();
		System.out.println("xPosition is: " + xPosition);
		int xValue;
		switch (xPosition) {
		case "A":
			xValue = 0;
			break;
		case "B":
			xValue = 1;
			break;
		case "C":
			xValue = 2;
			break;
		case "D":
			xValue = 3;
			break;
		case "E":
			xValue = 4;
			break;
		case "F":
			xValue = 5;
			break;
		case "G":
			xValue = 6;
			break;
		case "H":
			xValue = 7;
			break;
			default:
				xValue = 8;
				break;
		}
		System.out.println("xValue is: " + xValue);
		return xValue;
		
	}
	
	public static Boolean validateInput(String input) {
		String xInput = input.substring(0,1);
		System.out.println("xInput in Validate method is: " + xInput);
		int yInput = Integer.parseInt(input.substring(1,2));
		System.out.println("yInput in Validate method is: " + yInput);
		
		boolean xIsLetter = Character.isLetter(xInput.charAt(0));
		
		System.out.println("xIsLetter in validate method is: " + xIsLetter);
		
		if((!input.isEmpty()) || (!xIsLetter)) {
			System.out.println("returning false in validate");
			return false;
		} else {
			System.out.println("returning true in validate");
			return true;
		}
		
		
		
		
		
	}
	
	
	//TODO
	//Add in checker class to validation, so that it gets the piece in question
	//Validates that it still exists and then further validates if it can move
	//to where the input is
	
	//TODO
	
	// Will have to add in updating the position of the checker objects before 
	//being able to work on validation
	//as the way I plan on coding uses the classes as part of it
	
	
	
	//Game Logic
	//Checks to see if the move is legal or not
	private Checker validatePiece(int[][] board, int xValue, int yValue) {
		System.out.println("xValue: " + xValue);
		System.out.println("yValue: " + yValue);
		System.out.println("piece value: " + board[yValue][xValue]);
	
			//Checks to see if the piece is a Black piece (either 1 or 3)
			if(board[yValue][xValue] == 0) {
				System.out.println("Space selected is empty - please try again");
			} else if (board[yValue][xValue] % 2 != 0) {
				System.out.println("Piece is black");
				Checker selectedPiece = Model.blackPieces.get();
			} else {
				System.out.println("Piece is white");
			}
	
			
			
			
	}
	
public static void validateMove(int[][] board, int xInput, int yInput, boolean isBlackTurn) {
	
	
	
	
	
}
	
	
	
	
	public static void printList() {
		System.out.println("Printing  moves list");
		for(Move m: GameHistory.moves) {
			System.out.println(m.toString());
		}
		System.out.println("Printing copy list");
		for(Move m: GameHistory.copy) {
			System.out.println(m.toString());
		}
		
		
	}
	
	
	public static void moveThroughList(int[][] board) {
		int choice = 0;
		int i = 0;
		int j = 0;
		//Mov test = GameHistory.moves.get(i);
		System.out.println("using moveThroughList");
		System.out.println("1. " + "\t" + "undo ( Move backwards through list)");
		System.out.println("2. " + "\t" + "redo ( Move forwards through list");
		System.out.println("3. " + "\t" + "Exit Method");
		
		Scanner input = new Scanner(System.in);
		Move test;
		
		
		
	do {
		printList();
		choice = input.nextInt();
		if (choice == 1) {
			
			i = (GameHistory.moves.size() - 1); 
			System.out.println("i is: " + i);
			if(i == 0) {
				System.out.println("There are no more moves to undo");
			
			}
			
			test = GameHistory.moves.get(i);
			
			
			board[test.getyMove()][test.getxMove()] = 0;
			board[test.getyOrigin()][test.getxOrigin()] = 1;
			 GameHistory.copy.add(test);
			 GameHistory.moves.remove(test);
			 System.out.println("Move Undided");
			
			//}
		} else if (choice == 2) {
			
				
			
			j = (GameHistory.copy.size() - 1);
			System.out.println("J is: " + j );
			if(j == -1) {
				System.out.println("There are no moves to copy");
				
			} else {
			
			Move copy = GameHistory.copy.get(j);
			GameHistory.moves.add(copy);
			GameHistory.copy.remove(copy);
			i = (GameHistory.moves.size() - 1);
			System.out.println("i is: " + i);
			test = GameHistory.moves.get(i);
			
			board[test.getyMove()][test.getxMove()] = 0;
			board[test.getyOrigin()][test.getxOrigin()] = 1;
			System.out.println("move redided");
			}
		} else {
		System.out.println("choice is 3, exiting method");	
		}
		
		
	} while(choice != 3);
		
	
	
		input.close();
	}

	public static void movePiece(int[][] board) {
		boolean error = false;
		String origin;
		String move;
		
		do {
			System.out.println("Which Piece would you like to move?");
			origin = keyboard.next();
			System.out.println("origin at input is: " + origin);
		
			if(validateInput(origin)) {
				System.out.println("Error in Input, please try again");
				error = true;
			} else {
				System.out.println("No errors found with input origin");
				error = false;
			}
		}while(error);
		
		do {
			System.out.println("Where would you like to move");
			 move = keyboard.next();
			 System.out.println("move at input is: " + move);
			if(validateInput(move)) {
				System.out.println("Error in Input, please try again");
				error = true;
			} else {
				error = false;
				System.out.println("No errors found with input move");
			}
		} while(error);
		
		
		String xOrigin = origin.substring(0, 1);
		System.out.println("XOrigin is: " + xOrigin);
		int yOrigin = Integer.parseInt(origin.substring(1,2));
		System.out.println("yOrigin is: " + yOrigin);
		String xMove = move.substring(0, 1);
		System.out.println("xMove is: " + xMove);
		int yMove = Integer.parseInt(move.substring(1,2));
		System.out.println("yMove is: " + yMove);
		
		
		int convertedXOrigin = convertXPosition(xOrigin);
		
		System.out.println("convertedXOrigin is: " + convertedXOrigin);
		
		int convertedXMove = convertXPosition(xMove);
		
		System.out.println("convertedXMove is: " + convertedXMove);
		
		yOrigin -= 1;
		yMove -= 1;
		
		
		System.out.println("Origin: " + yOrigin + ", " + convertedXOrigin);
		System.out.println("Move: " + yMove + ", " + convertedXMove);
		board[yOrigin][convertedXOrigin] = 0;
		board[yMove][convertedXMove] = 1;
		
		//board[convertedXOrigin][yOrigin] = 0;
		//board[convertedXMove][yMove] = 1;
		System.out.println("DANIEL1 - " + GameHistory.moves.toString());
		Move asda1 = new Move(convertedXOrigin, yOrigin, convertedXMove, yMove);
		System.out.println("DANIEL2 - " + GameHistory.moves.toString());
		GameHistory.moves.add(asda1);
	//	System.out.println("DANIEL - " + GameHistory.moves.toString());
		
		
		//yMove + ", " + convertedXMove
		
		printBoard(board);
	
	}
	
	
	
	
	public static void main(String args[]) {
		int[][] board;
		//1 is black
		//2 is white
		//3 is black king
		//4 is white king
		//0 is empty space
		board = new int[][]{
			{0, 1, 0, 1, 0, 1, 0, 1 },
			{1, 0, 1, 0, 1, 0, 1, 0 },
			{0, 1, 0, 1, 0, 1, 0, 1 },
			{0, 0, 0, 0, 0, 0, 0, 0 },
			{0, 0, 0, 0, 0, 0, 0, 0 },
			{2, 0, 2, 0, 2, 0, 2, 0 },
			{0, 2, 0, 2, 0, 2, 0, 2 },
			{2, 0, 2, 0, 2, 0, 2, 0 }
		};
		
		/*
		printBoard(board);
		movePiece(board);
		movePiece(board);
		movePiece(board);
		moveThroughList(board);
		*/
		
		validatePiece(board, 2, 7);
		


	}
	
	
	
	
	
}

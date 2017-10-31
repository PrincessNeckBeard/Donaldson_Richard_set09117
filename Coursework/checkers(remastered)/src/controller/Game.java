package controller;

import java.util.Scanner;

import model.Board;
import model.Checker;
import model.Model;
import model.Move;

public class Game {

	
	Model model = new Model();
	Board board = new Board();
	
	 static Scanner keyboard = new Scanner(System.in);
	private void populateModel() {
		model.populate();
		
	}
	
	
	
	public void printBoard() {
String xAxis[] = {"A", "B", "C", "D", "E", "F", "G", "H"};
		
		for(int i = 0; i<8;i++) {
			System.out.print((i + 1) + "\t");
			for(int j = 0; j<8;j++) {
				System.out.print(board.getBoard()[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();
		for(int k = 0; k <8; k++) {
			System.out.print("\t" + xAxis[k]);
		}
		System.out.println();
	}
	
	
	public void printList() {
		System.out.println("Printing  moves list");
		for(Move m: model.moves) {
			System.out.println(m.toString());
		}
		System.out.println("Printing copy list");
		for(Move m: model.copy) {
			System.out.println(m.toString());
		}
		
		
	}
	
	public void moveThroughList() {
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
		choice = input.nextInt();
		if (choice == 1) {
			
			i = (model.moves.size() - 1); 
			System.out.println("i is: " + i);
			if(i == 0) {
				System.out.println("There are no more moves to undo");
			
			}
			
			test = model.moves.get(i);
			
			updateBoard(test);
			
			
		//	board.getBoard()[test.getyMove()][test.getxMove()] = 0;
		//	board.getBoard()[test.getyOrigin()][test.getxOrigin()] = 1;
			model.copy.add(test);
			model.moves.remove(test);
			 System.out.println("Move Undided");
			
			//}
		} else if (choice == 2) {
			
				
			
			j = (model.copy.size() - 1);
			System.out.println("J is: " + j );
			if(j == -1) {
				System.out.println("There are no moves to copy");
				
			} else {
			
			Move copy = model.copy.get(j);
			model.moves.add(copy);
			model.copy.remove(copy);
			i = (model.moves.size() - 1);
			System.out.println("i is: " + i);
			test = model.moves.get(i);
			updateBoard(test); 
			//board.getBoard()[test.getyMove()][test.getxMove()] = 0;
			//board.getBoard()[test.getyOrigin()][test.getxOrigin()] = 1;
			System.out.println("move redided");
			}
		} else {
		System.out.println("choice is 3, exiting method");	
		}
		
		
	} while(choice != 3);
		
	
	
		input.close();
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
		
	public static Move movePiece() {
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
		
		
		//board[convertedXOrigin][yOrigin] = 0;
		//board[convertedXMove][yMove] = 1;
		//System.out.println("DANIEL1 - " + GameHistory.moves.toString());
		Move asda1 = new Move(convertedXOrigin, yOrigin, convertedXMove, yMove);
	//	System.out.println("DANIEL2 - " + GameHistory.moves.toString());
		
	//	System.out.println("DANIEL - " + GameHistory.moves.toString());
		
		
		//yMove + ", " + convertedXMove
		
		return asda1;
	
	}
	
	
	public void updateBoard(Move move) {
		
		board.getBoard()[move.getyOrigin()][move.getxOrigin()] = 0;
		board.getBoard()[move.getyMove()][move.getxMove()] = 1;
	}
	
	public void updateList(Move move) {
		model.moves.add(move);
	}
		
	
	
	
public void validatePiece(int xValue, int yValue) {
	
	 Checker checker = model.findChecker(xValue, yValue);
	 System.out.println("xValue get: " + checker.getCurrentXPosition());
	 System.out.println("yValue get: " + checker.getCurrentYPosition());
	 System.out.println("xValue input: " + xValue);
	 System.out.println("yValue input: " + yValue);
	 System.out.println("piece value: " + board.getBoard()[yValue][xValue]);
	 
	 if(board.getBoard()[yValue][xValue] == 0) {
			System.out.println("Space selected is empty - please try again");
		} else if (board.getBoard()[yValue][xValue] % 2 != 0) {
			System.out.println("Piece is black");
			 
		} else {
			System.out.println("Piece is white");
		}
	 
	 
}
	
	
	
//	private static void validatePiece(int[][] board, int xValue, int yValue) {
//		Checker selectedPiece = new Checker();
//		
//		selectedPiece = selectedPiece.findChecker(xValue, yValue);
//
//		System.out.println("xValue get: " + selectedPiece.getCurrentXPosition());
//		System.out.println("yValue get: " + selectedPiece.getCurrentYPosition());
//		System.out.println("xValue input: " + xValue);
//		System.out.println("yValue input: " + yValue);
//		System.out.println("piece value: " + board[yValue][xValue]);
//	
			//Checks to see if the piece is a Black piece (either 1 or 3)
			
//	
//			
//			
//			
//	}
//	
//public static void validateMove(int[][] board, int xInput, int yInput, boolean isBlackTurn) {
//	
//	
//	
//	
//	
//}
	
	
	
	
	
public static void main(String args[]) {
	Game controller = new Game();
	controller.populateModel();
//	controller.printBoard();
//	Move move = controller.movePiece();
//	
//	controller.updateBoard(move);
//	controller.updateList(move);
//	controller.printBoard();
//	move = controller.movePiece();
//	controller.updateBoard(move);
//	controller.updateList(move);
//	controller.printBoard();
//	move = controller.movePiece();
//	controller.updateBoard(move);
//	controller.updateList(move);
//	controller.printBoard();
//	move = controller.movePiece();
//	controller.updateBoard(move);
//	controller.updateList(move);
//	controller.printBoard();
//	controller.printList();
//	controller.moveThroughList();
	controller.validatePiece(1,0);
	
	
	
}
	
	
	

	
	
	
}

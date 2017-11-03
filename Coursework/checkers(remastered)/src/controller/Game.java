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
	
	
	
	
	
	
	public int convertXPosition(String xPosition) {
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
		
	

	
	
	
	public boolean isSpaceTaken(int xValue, int yValue) {
		System.out.println("xValue in isSpaceTaken: " + xValue);
		System.out.println("yValue in isSpaceTaken: " + yValue);
		System.out.println("Piece that is being checked: " + board.getBoard()[yValue][xValue]);
		if((board.getBoard()[yValue][xValue] == 1) || (board.getBoard()[yValue][xValue] == 3)) {
			System.out.println("Piece is black");
			return true;
		} else if ((board.getBoard()[yValue][xValue] == 2) || (board.getBoard()[yValue][xValue] == 4)) {
			System.out.println("Piece is white");
			return true;
		} else {
			return false;
		}
		
		
	}
	
	
	
	
	
	

	

	
	
	
	
	
	
	
	
	public  Move movePiece() {
		
		boolean error = false;
		String moveInput;
		String origin;
		
		do {
			System.out.println("Which piece would you like to move?");
			origin = keyboard.next();
			System.out.println("origin at input is " + origin);
			if(validateInput(origin)) {
				System.out.println("Error in input, please try again");
				error = true; 
			} else {
				System.out.println("No errors found with input origin");
				error = false;
			}
			
			
		}while(error);
		
		String xOrigin = origin.substring(0, 1);
		System.out.println("XOrigin is: " + xOrigin);
		int yOrigin = Integer.parseInt(origin.substring(1,2));
		System.out.println("yOrigin is: " + yOrigin);
		
		int convertedXOrigin = convertXPosition(xOrigin);
		
		System.out.println("convertedXOrigin is: " + convertedXOrigin);
		yOrigin -= 1;
		Checker checker = validatePiece(convertedXOrigin, yOrigin);
		
		
		
		
		do {
			System.out.println("Where would you like to move");
			 moveInput = keyboard.next();
			 System.out.println("move at input is: " + moveInput);
			if(validateInput(moveInput)) {
				System.out.println("Error in Input, please try again");
				error = true;
			} else {
				error = false;
				System.out.println("No errors found with input move");
			}
		} while(error);
		
		
		
		String xMove = moveInput.substring(0, 1);
		System.out.println("xMove is: " + xMove);
		int yMove = Integer.parseInt(moveInput.substring(1,2));
		System.out.println("yMove is: " + yMove);

		int convertedXMove = convertXPosition(xMove);
		
		System.out.println("convertedXMove is: " + convertedXMove);
		
		
		
		
	//	
		yMove -= 1;
		
		
		
		System.out.println("Move: " + yMove + ", " + convertedXMove);
		
		if(validateMove(convertedXMove, yMove) ) {
			Move move = new Move(convertedXOrigin, yOrigin, convertedXMove, yMove);
			model.moves.add(move);
			
			updateBoard(move);
			model.updateChecker(move, checker);
			printBoard();
			return move;	
		}
		printBoard();
		return null;
	}
	
	
	public void updateBoard(Move move) {
		
		board.getBoard()[move.getyOrigin()][move.getxOrigin()] = 0;
		board.getBoard()[move.getyMove()][move.getxMove()] = 1;
	}
	
	//checks to see if the piece exists
public Checker validatePiece(int xValue, int yValue) {
	
	 Checker checker = model.findChecker(xValue, yValue);
	 System.out.println("xValue get: " + checker.getCurrentXPosition());
	 System.out.println("yValue get: " + checker.getCurrentYPosition());
	 System.out.println("xValue input: " + xValue);
	 System.out.println("yValue input: " + yValue);
	 System.out.println("piece value: " + board.getBoard()[yValue][xValue]);
	 
	
	 
	 return checker;
}
	//returns true if move is valid
public boolean validateMove(int xValue, int yValue) {
	if(!isSpaceTaken(xValue, yValue)) {
	 	System.out.println("Space is not Taken");
	 	return true;
	} else {
		System.out.println("Space is taken");
		return false;
	}
	
}
	
public static void main(String args[]) {
	Game controller = new Game();
	
	controller.printBoard();
	controller.populateModel();
	controller.movePiece();
	
	
	controller.movePiece();
	controller.movePiece();
	controller.movePiece();
	controller.printList();
	controller.moveThroughList();
	
}
	
	
	

	
	
	
}

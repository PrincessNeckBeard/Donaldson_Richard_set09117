package controller;

import java.awt.List;
import java.util.ArrayList;
import java.util.Scanner;

import model.Board;
import view.View;

public class Game {

	static Scanner keyboard = new Scanner(System.in);
	static ArrayList<String> moves = new ArrayList<String>();
	
	
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
	
	public static Boolean validate(String input) {
		String xInput = input.substring(0,1);
		System.out.println("xInput in Validate method is: " + xInput);
		int yInput = Integer.parseInt(input.substring(1,2));
		System.out.println("yInput in Validate method is: " + yInput);
		boolean xIsLetter = xInput.chars().allMatch(Character::isLetter);
		System.out.println("xIsLetter in validate method is: " + xIsLetter);
		
		if((!input.isEmpty()) || (!xIsLetter)) {
			System.out.println("returning false in validate");
			return false;
		} else {
			System.out.println("returning true in validate");
			return true;
		}
		
		
		
		
		
	}
	
	public static void printList() {
		System.out.println("Printing list");
		for(String m: moves) {
			System.out.println(m);
		}
	}
	
	
	//What I'm thinking is having two Lists, one that has all the moves, 
	//and then one that copies the move that has been undid into the new list
	//so that if redo is added then they can just work between both lists
	
	public static void undo(int[][] board) {
		
		//this works, but if I'm going to be using two lists, this will have to
		//be re done, but at least it works! 
		
		int i = (moves.size() - 1);
		
			System.out.println("The last move played was " + moves.get(i));
			System.out.println("Undo");
			System.out.println("Undid move: " + moves.get(i));
			i--;
			System.out.println("confirm? dummy answer no - undo again" );
			System.out.println("Undid move 2: " + moves.get(i));
			i--;
		
		
		
		
	}
	
	public static void redo(int[][] board) {
		
	}
	
	
	
	
	
	//once this is working, see about creating a seperate class to do this
	//so that the conversion for the origin value and move value can be returned
	//at the same time
	public static void movePiece(int[][] board) {
		boolean error = false;
		String origin;
		String move;
		
		do {
			System.out.println("Which Piece would you like to move?");
			origin = keyboard.next();
			System.out.println("origin at input is: " + origin);
		
			if(validate(origin)) {
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
			if(validate(move)) {
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
		moves.add(yMove + ", " + convertedXMove);
		
		
		
	
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
		
		//printBoard(board);
		//movePiece(board);
		//printList();
		//printBoard(board);
		//movePiece(board);
		//printList();
		//keyboard.close();
		moves.add("1, 2");
		moves.add("3, 4");
		moves.add("5, 6");
		moves.add("7, 8");
		printList();
		undo(board);
	}
	
	
	
	
	
}

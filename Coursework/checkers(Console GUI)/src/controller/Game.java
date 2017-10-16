package controller;

import model.Board;
import view.View;

public class Game {

	
	
	
	Game() {
	 
	
	
	
		
		
		
	}
	
	public static void printBoard(int[][] board) {
			
		for(int i = 0; i<8;i++) {
			for(int j = 0; j<8;j++) {
				System.out.print(board[i][j] + "\t");
			}
			System.out.println();
		}
		
		
	}
	
	public static int convertXPosition(String xPosition) {
		xPosition = xPosition.toUpperCase();
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
				xValue = 9;
				break;
		}
		
		return xValue;
		
	}
	
	
	
	
	
	//once this is working, see about creating a seperate class to do this
	//so that the conversion for the origin value and move value can be returned
	//at the same time
	public static void movePiece(int[][] board) {
		String origin = "B2";
		String move = "C3";
		System.out.println("moving Piece [2][1] to place [3][2]");
		
		String xOrigin = origin.substring(0, 1);
		int yOrigin = Integer.parseInt(origin.substring(1,2));
		String xMove = move.substring(0, 1);
		int yMove = Integer.parseInt(move.substring(1,2));
		
		System.out.println("xMove" + xMove);
		System.out.println("yMove" + yMove);
		System.out.println("xOrigin" + xOrigin);
		System.out.println("yOrigin" + yOrigin);
		
		
		int convertedXOrigin = convertXPosition(xOrigin);
		System.out.println("convertedXOrigin" + convertedXOrigin);
		int convertedXMove = convertXPosition(xMove);
		System.out.println("convertedXMove" + convertedXMove);
		
		
		
		
		board[yOrigin][convertedXOrigin] = 0;
		board[yMove][convertedXMove] = 1;
		//board[convertedXOrigin][yOrigin] = 0;
		//board[convertedXMove][yMove] = 1;
		
		
		
	}
	
	
	
	
	public static void main(String args[]) {
		int[][] board;
		
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
		
		printBoard(board);
		movePiece(board);
		printBoard(board);
	}
	
	
	
	
	
}

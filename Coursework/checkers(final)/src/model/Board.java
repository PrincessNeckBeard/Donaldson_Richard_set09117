package model;

import java.util.Arrays;
/*
 * This Class stores information about the board
 */
public class Board {

	//used for testing Kings
	/*
	int[][] board = new int[][]{
		{0, 0, 0, 0, 0, 0, 0, 0 },
		{0, 0, 0, 0, 0, 0, 0, 0 },
		{0, 0, 0, 0, 0, 0, 0, 0 },
		{0, 4, 0, 3, 0, 0, 0, 0 },
		{0, 0, 0, 0, 0, 0, 0, 0 },
		{0, 0, 0, 0, 0, 0, 0, 0 },
		{0, 0, 0, 0, 0, 0, 0, 0 },
		{0, 0, 0, 0, 0, 0, 0, 0 }
	};
*/
	//the initial state of the board
	int[][] board = new int[][]{
		{0, 1, 0, 1, 0, 1, 0, 1 },
		{1, 0, 1, 0, 1, 0, 1, 0 },
		{0, 1, 0, 1, 0, 1, 0, 1 },
		{0, 0, 0, 0, 0, 0, 0, 0 },
		{0, 0, 0, 0, 0, 0, 0, 0 },
		{2, 0, 2, 0, 2, 0, 2, 0 },
		{0, 2, 0, 2, 0, 2, 0, 2 },
		{2, 0, 2, 0, 2, 0, 2, 0 }
	};
	
	//constructor for the board
	public Board() {
		super();

	}
	
//getters and setters
	public int[][] getBoard() {
		return board;
	}
	public void setBoard(int[][] board) {
		this.board = board;
	}

//toString
	@Override
	public String toString() {
		return "Board [board=" + Arrays.toString(board) + "]";
	}

	
	
	
	
	
	
	
	
}

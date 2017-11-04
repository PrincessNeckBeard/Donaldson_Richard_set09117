package model;

import java.util.Arrays;

public class Board {



	int[][] board = new int[][]{
		{0, 1, 0, 1, 0, 1, 0, 1 },
		{1, 0, 1, 0, 1, 0, 1, 0 },
		{0, 1, 0, 1, 0, 1, 0, 1 },
		{0, 0, 0, 0, 2, 0, 0, 0 },
		{0, 0, 0, 0, 0, 0, 0, 0 },
		{2, 0, 2, 0, 2, 0, 2, 0 },
		{0, 2, 0, 2, 0, 2, 0, 2 },
		{2, 0, 2, 0, 2, 0, 2, 0 }
	};
	
	public Board() {
		super();

		this.board = board;
	}
	

	public int[][] getBoard() {
		return board;
	}
	public void setBoard(int[][] board) {
		this.board = board;
	}


	@Override
	public String toString() {
		return "Board [board=" + Arrays.toString(board) + "]";
	}

	
	
	
	
	
	
	
	
}

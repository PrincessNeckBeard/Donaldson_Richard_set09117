package model;

public class Move {

	static int xOrigin;
	static int yOrigin;
	
	static int xMove;
	static int yMove;
	
//	Checker checker;

	
	
	
	
	
	
	public Move(int xOrigin, int yOrigin, int xMove, int yMove) {
		super();
		Move.xOrigin = xOrigin;
		Move.yOrigin = yOrigin;
		Move.xMove = xMove;
		Move.yMove = yMove;
	//	this.checker = checker;
	}

	public static int getxOrigin() {
		return xOrigin;
	}

	public void setxOrigin(int xOrigin) {
		Move.xOrigin = xOrigin;
	}

	public static int getyOrigin() {
		return yOrigin;
	}

	public void setyOrigin(int yOrigin) {
		Move.yOrigin = yOrigin;
	}

	public static int getxMove() {
		return xMove;
	}

	public void setxMove(int xMove) {
		Move.xMove = xMove;
	}

	public static int getyMove() {
		return yMove;
	}

	public void setyMove(int yMove) {
		Move.yMove = yMove;
	}

	@Override
	public String toString() {
		return "Move [xOrigin=" + xOrigin + ", yOrigin=" + yOrigin + ", xMove="
				+ xMove + ", yMove=" + yMove + "]";
	}

//	public Checker getChecker() {
//		return checker;
//	}
//
//	public void setChecker(Checker checker) {
//		this.checker = checker;
//	}
	
	
	
	
	
	
	
}

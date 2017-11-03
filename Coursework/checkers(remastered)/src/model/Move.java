package model;

public class Move {

	int xOrigin;
	int yOrigin;
	
	int xMove;
	int yMove;
	
	Checker checker;
	public Move(int xOrigin, int yOrigin, int xMove, int yMove) {
		super();
		this.xOrigin = xOrigin;
		this.yOrigin = yOrigin;
		this.xMove = xMove;
		this.yMove = yMove;
	}
	public int getxOrigin() {
		return xOrigin;
	}
	public void setxOrigin(int xOrigin) {
		this.xOrigin = xOrigin;
	}
	public int getyOrigin() {
		return yOrigin;
	}
	public void setyOrigin(int yOrigin) {
		this.yOrigin = yOrigin;
	}
	public int getxMove() {
		return xMove;
	}
	public void setxMove(int xMove) {
		this.xMove = xMove;
	}
	public int getyMove() {
		return yMove;
	}
	public void setyMove(int yMove) {
		this.yMove = yMove;
	}
	@Override
	public String toString() {
		return "Move [xOrigin=" + xOrigin + ", yOrigin=" + yOrigin + ", xMove=" + xMove + ", yMove=" + yMove + "]";
	}
	
	
	
	
	
	
}

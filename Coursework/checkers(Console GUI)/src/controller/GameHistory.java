package controller;

import java.util.LinkedList;

import model.Move;

public class GameHistory {
//look into using linked list instead of ArrayList
	//or just look at other Data Structures in general
static LinkedList<Move> moves = new LinkedList<Move>();
static Object copy = new LinkedList<Move>();



public LinkedList<Move> getMoves() {
	return moves;
}
public void setMoves(LinkedList<Move> moves) {
	GameHistory.moves = moves;
}
public static Object getCopy() {
	return copy;
}
public void setCopy(LinkedList<Move> copy) {
	GameHistory.copy = copy;
}







}

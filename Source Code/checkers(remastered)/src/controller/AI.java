package controller;

import java.util.LinkedList;

import model.Board;
import model.Move;
import model.*;
public class AI extends Game {


Board board = new Board();
Model model = new Model();



public void minimax() {
	
}




public LinkedList<Move> getPossibleMoves() {

int xOrigin = 0, yOrigin = 0, xMove1 = 0, xMove2 = 0, yMove1 = 0, yMove2 = 0;
boolean isMovingRight;
Move move = null;	
	
	for(Checker checker: model.whitePieces) {
		
		xOrigin = checker.getCurrentXPosition();
		yOrigin = checker.getCurrentYPosition();
		xMove1 = (checker.getCurrentXPosition() - 1);
		xMove2 = (checker.getCurrentXPosition() + 1);
		yMove1 = (checker.getCurrentXPosition() - 1);
		
		System.out.println(checker.toString());
		switch(checker.getType()) {
		case 2:
			System.out.println(checker.toString());

			
			
			
			if(isMoveValid(xOrigin,yOrigin, xMove1, yMove1, false, false )) {
				if(isSpaceTaken(xMove1,yMove1)) {
					System.out.println("Space is Taken");
					if(isPieceEnemy(xMove1,yMove1,checker,2)) {
						if(isJumpValid(xOrigin, yOrigin, xMove1, yMove1, false, false)) {
							move = new Move(xOrigin, yOrigin, xMove1, yMove1);
							AIPossibleMoves.add(move);	
						}
					}
				}
			}
			
			if(isMoveValid(xOrigin,yOrigin, xMove2, yMove1, true, false )) {
				if(isSpaceTaken(xMove2,yMove1)) {
					System.out.println("Space is Taken");
					if(isPieceEnemy(xMove2,yMove1,checker,2)) {
						if(isJumpValid(xOrigin, yOrigin, xMove2, yMove1, true, false)) {
							move = new Move(xOrigin, yOrigin, xMove2, yMove1);
							AIPossibleMoves.add(move);	
						}
					}
				}
			}
			break;
		case 4:
			//Moving up and left    isMovingRight,IsMovingDown
			if(isMoveValid(xOrigin,yOrigin, xMove1, yMove1, false, false )) {
				if(isSpaceTaken(xMove1,yMove1)) {
					System.out.println("Space is Taken");
					if(isPieceEnemy(xMove1,yMove1,checker,2)) {
						if(isJumpValid(xOrigin, yOrigin, xMove1, yMove1, false, false)) {
							move = new Move(xOrigin, yOrigin, xMove1, yMove1);
							AIPossibleMoves.add(move);	
						}
					}
				}
			}
			//moving up and right
			if(isMoveValid(xOrigin,yOrigin, xMove2, yMove1, true, false )) {
				if(isSpaceTaken(xMove2,yMove1)) {
					System.out.println("Space is Taken");
					if(isPieceEnemy(xMove2,yMove1,checker,2)) {
						if(isJumpValid(xOrigin, yOrigin, xMove2, yMove1, true, false)) {
							move = new Move(xOrigin, yOrigin, xMove2, yMove1);
							AIPossibleMoves.add(move);	
						}
					}
				}
			}
			//moving down and left isMovingRight,IsMovingDown
			if(isMoveValid(xOrigin,yOrigin, xMove1, yMove2, false, true )) {
				if(isSpaceTaken(xMove1,yMove2)) {
					System.out.println("Space is Taken");
					if(isPieceEnemy(xMove1,yMove2,checker,2)) {
						if(isJumpValid(xOrigin, yOrigin, xMove1, yMove2, false, true)) {
							move = new Move(xOrigin, yOrigin, xMove1, yMove2);
							AIPossibleMoves.add(move);	
						}
					}
				}
			}
			//moving down and right isMovingRight,IsMovingDown
			if(isMoveValid(xOrigin,yOrigin, xMove2, yMove2, true, true )) {
				if(isSpaceTaken(xMove2,yMove2)) {
					System.out.println("Space is Taken");
					if(isPieceEnemy(xMove2,yMove2,checker,2)) {
						if(isJumpValid(xOrigin, yOrigin, xMove2, yMove2, true, true)) {
							move = new Move(xOrigin, yOrigin, xMove2, yMove2);
							AIPossibleMoves.add(move);	
						}
					}
				}
			}
			break;
			default:
				System.out.println("Error somewhere in AI Switch");
				break;
		}
		
		
		
		
//		if(isMoveValid(convertedXOrigin, yOrigin, convertedXMove, yMove, isMovingRight, isMovingDown)) {
//			if(isSpaceTaken(convertedXMove, yMove)) {
//				System.out.println("Space is taken");
//				if(isPieceEnemy(convertedXMove, yMove, checker, turn)) {
//					if(isJumpValid(convertedXOrigin, yOrigin, convertedXMove, yMove, isMovingRight, isMovingDown)) {
//						if(isMovingRight) {
//							//checks to see if the piece is moving up or down
//							if(isMovingDown) {
//								//means the piece is moving right and down
//								 move = new Move(convertedXOrigin, yOrigin, convertedXMove + 1, yMove + 1);
//								model.moves.add(move);	
//								removeTakenPiece(convertedXMove, yMove);
//							} else {
//								//means the piece is moving right, but up
//								 move = new Move(convertedXOrigin, yOrigin, convertedXMove + 1, yMove - 1);
//								model.moves.add(move);
//								removeTakenPiece(convertedXMove, yMove);
//							}
//							
//						} else {
//							if(isMovingDown) {
//								//means its moving left and down
//								move = new Move(convertedXOrigin, yOrigin, convertedXMove - 1, yMove + 1);
//								model.moves.add(move);
//								removeTakenPiece(convertedXMove, yMove);
//							} else {
//								//means it's moving left and up
//								move = new Move(convertedXOrigin, yOrigin, convertedXMove - 1, yMove - 1);
//								model.moves.add(move);	
//								removeTakenPiece(convertedXMove, yMove);
//							}
//							
//						}
//					}
//				
//				}
//			} else {
//				System.out.println("Space isn't taken");
//				move = new Move(convertedXOrigin, yOrigin, convertedXMove, yMove);
//				model.moves.add(move);
//				if(canBeKing(checker, move)) {
//					checker = convertToKing(checker, move);
//					model.updateChecker(move, checker, turn);
//					
//					
//					printBoard();
//					return move;
//				}
//				
//				model.updateChecker(move, checker, turn);
//				updateBoard(move);
//				
//				printBoard();
//				return move;
//			}
//		} else {
//			System.out.println("Error in move");
//			//System.out.println("It's not your turn");
//			isCorrectTurn = false;
//		}
//			} catch (NullPointerException e) {
//				System.out.println("NullPointerException - Error");
//				return null;
//			}
		
	
	
	
	
	
}
	
	
	
	return AIPossibleMoves;
	
}


public static void main(String args[]) {
	AI AIController = new AI();
	System.out.println("Running AI Main");
	AIController.populateModel();
	
	//System.out.println(AIController.getPossibleMoves());
	
}




}

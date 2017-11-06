package controller;

import java.util.Scanner;

import model.Board;
import model.Checker;
import model.Model;
import model.Move;

public class Game {
//TODO Actuallly check the functionality of what White can do at this stage
	//Because thinking about the code, only black pieces can actually move
	//and be updated on the board, white will just crash the program
	
	//XXX Start removing some of the System.out in the methods that
	//actually work properly
	//the screen is actually starting to get cluttered and you've got a mix
	//of some just outputting random values so what you come back to it
	//it makes no bloody sense! 
	
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
		for(Move m: model.moves) {
			System.out.println(m.toString());
		}
		for(Move m: model.copy) {
			System.out.println(m.toString());
		}
		
		
	}
	
	public void moveThroughList() {
		int choice = 0;
		int i = 0;
		int j = 0;
		//Mov test = GameHistory.moves.get(i);
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
			
			undoRedoBoard(test);
			
			
		//	board.getBoard()[test.getyMove()][test.getxMove()] = 0;
		//	board.getBoard()[test.getyOrigin()][test.getxOrigin()] = 1;
			model.copy.add(test);
			model.moves.remove(test);
			 System.out.println("Undo'd move ");
			printList();
			
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
			System.out.println("move redided");
			printList();
			}
		} 
		
		
	} while(choice != 3);
		
	
	
		input.close();
	}
	
	
	
	
	
	
	public int convertXPosition(String xPosition) {
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
				xValue = 8;
				break;
		}
		return xValue;
		
	}
	
	public static Boolean validateInput(String input) {
		String xInput = input.substring(0,1);

		int yInput = Integer.parseInt(input.substring(1,2));

		
		boolean xIsLetter = Character.isLetter(xInput.charAt(0));
		

		
		if((!input.isEmpty()) || (!xIsLetter)) {
	
			return false;
		} else {

			return true; 
			}
		}
		
	public Checker validatePiece(int xValue, int yValue) {
		

		Checker checker = model.findChecker(xValue, yValue);
		 return checker;
	}
		//returns true if move is valid
	public boolean validateMove(int xOrigin, int yOrigin, int xMove, int yMove) {
		boolean isMovingRight = false;
		boolean isSpaceTaken = false;
		boolean isMoveValid = false;
		boolean isJumpValid = false;
		boolean isMovingDown = false;
		
		isSpaceTaken = isSpaceTaken(xMove,yMove);
		isMovingRight = isMovingRight(xOrigin, yOrigin, xMove, yMove);
		isMovingDown = isMovingDown(xOrigin, yOrigin, xMove, yMove);
		isMoveValid = isMoveValid(xOrigin, yOrigin, xMove, yMove, isMovingRight, isMovingDown);
		isJumpValid = isJumpValid(xOrigin, yOrigin, xMove, yMove, isMovingRight, isMovingDown);
		
		
		
		if(isMoveValid) {
			if(isSpaceTaken) {
				if(isJumpValid) {
					System.out.println("Jump is valid");
					return true;
				} else {
					System.out.println("Jump is invalid - Move is invalid");
					return false;
				}
				
			} else {
				System.out.println("Space is empty");
				return true;
				//INSERT MOVE CODE HERE
			}
		} else {
			System.out.println("Move isn't Valid");
			return false;
		}
		
		
		
		
		
//		if(!isSpaceTaken) {
//			System.out.println("Space is not taken");
//			if(isMoveValid) {
//				return true;
//			}
//		} else {
//			System.out.println("Space is taken");
//			if(isMoveValid) {
//				if(isJumpValid) {
//					return true;
//				}
//				return false;
//		}
//		}
//			return false;
		
		
		
		
//		
//		if(!isSpaceTaken(xMove, yMove)) {
//		 	System.out.println("Space is not Taken");
//		 	isMovingRight = isMovingRight(xOrigin, yOrigin, xMove, yMove);
//		 	if(isMoveValid(xOrigin, yOrigin, xMove, yMove, isMovingRight)) {
//		 		return true;	
//		 	}
//		 	
//		} else {
//			System.out.println("Space is taken");
//			
//		}  
//		
	
		
	}

	public boolean isMovingRight(int xOrigin, int yOrigin, int xMove, int yMove) {
		if(xMove == (xOrigin + 1)) {
			System.out.println("IsMovingRight is true");
			return true;
		} else {
			System.out.println("isMovingRight is false");
			return false;
		}
		
	}
	
	public boolean isMovingDown(int xOrigin, int yOrigin, int xMove, int yMove) {
		if(yMove == (yOrigin + 1)) {
			System.out.println("IsMovingDown is true");
			return true;
		} else {
			System.out.println("IsMovingDown is false");
			return false;
		}
	}
	
	
	
	
	public boolean isJumpValid(int xOrigin, int yOrigin, int xMove, int yMove, boolean isMovingRight, boolean isMovingDown) {

		
	if(isMovingDown) {
		if(isMovingRight) {
			//checks if moving down and right
			if(board.getBoard()[yMove + 1][xMove + 1] == 0 ) {
				System.out.println("Moving down and right. Space is empty");
				return true;
			}
		} else {
			if(board.getBoard()[yMove + 1][xMove - 1] == 0 ) {
				System.out.println("Moving down and left. Space is empty");
				return true;
			}
			
		}
		
		
	} else {
		if(isMovingRight) {
			//checks moving up and right
			if(board.getBoard()[yMove - 1][xMove + 1] == 0) {
				System.out.println("Moving up and right. Space is empty");
				return true;
			}
		} else {
			if(board.getBoard()[yMove - 1][xMove - 1] == 0) {
				System.out.println("Moving up and left. Space is empty");
				return true;
			}
		}
			return false;
	}
		
		
		
		
		
		
		
if(isMovingRight) {
//checks to see if space behind the piece is empty	
	if(board.getBoard()[yMove + 1][xMove + 1] == 0) {
		System.out.println("Jump is valid - space empty");
		return true;
	} else {
		System.out.println("Space is not empty");
		return false;
	}
} else {
	if(board.getBoard()[yMove + 1][xMove - 1] == 0) {
		System.out.println("Jump is valid");
		return true;
	} else {
		System.out.println("Jump is invalid");
	}
}
		return false;

	}	

	
	
	
	public boolean isSpaceTaken(int xValue, int yValue) {


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
	
	public boolean isPieceEnemy(int xValue, int yValue, Checker checker, int turn) {
		
		
		int piece = checker.getType();
		
		if((piece == 1) || (piece == 3)) {
			if(turn == 1) {
				System.out.println("Piece is not the enemy");
				return false;
			} else {
				System.out.println("Piece is the enemy");
			
			}
		}

		return true;
	}
	
	
	
	
	//TODO create switch statement later for all possible pieces
	//for now, just working on checking if a black piece makes a valid move
	
	
	
	
	
//checks to see if the move itself is moving to a valid space
	public boolean isMoveValid(int xOrigin, int yOrigin, int xMove, int yMove, boolean isMovingRight, boolean isMovingDown) {
		
		
		if(isMovingDown) {
			if(xMove == (xOrigin + 1)) {
				System.out.println("xMove is valid");
				isMovingRight = true;
				if(yMove == (yOrigin + 1)) {
					System.out.println("yMove is valid");
					return true;
				} else {
					System.out.println("yMove is invalid");
					return false;
				}
			} else if(xMove == (xOrigin - 1)) {
					System.out.println("xMove is Valid");
					isMovingRight = false;
					if(yMove == (yOrigin + 1)) {
						System.out.println("yMove is valid");
					}
					else {
						System.out.println("yMove is invalid");
						return false;
					}
				} else {
					System.out.println("xMove is Invalid");
			}
		} else {
			if(xMove == (xOrigin + 1)) {
				System.out.println("xMove is valid");
				isMovingRight = true;
				if(yMove == (yOrigin - 1)) {
					System.out.println("yMove is valid");
					return true;
				} else {
					System.out.println("yMove is invalid");
					return false;
				}
			} else if (xMove == (xOrigin - 1)) {
				System.out.println("xMove is valid");
				isMovingRight = false;
				if(yMove == (yOrigin - 1)) {
					System.out.println("yMove is valid");
					return true;
				} else {
					System.out.println("yMove is invalid");
					return false;
				}
			} else {
				System.out.println("xMove is invalid");
			}
		}
		
		return false;
		
		
		
	}
	
	
	public  Move movePiece(int turn) {
		
		boolean error = false;
		String moveInput;
		String origin;
		boolean isCorrectTurn = false;
		
		
		do {
			do {
				System.out.println("Which piece would you like to move?");
				origin = keyboard.next();

				if(validateInput(origin)) {
					System.out.println("Error in input, please try again");
					error = true; 
				} else {
				
					error = false;
				}
				
				
			}while(error);
			
			String xOrigin = origin.substring(0, 1);
			int yOrigin = Integer.parseInt(origin.substring(1,2));
			int convertedXOrigin = convertXPosition(xOrigin);
			yOrigin -= 1;
			
		if(board.getBoard()[yOrigin][convertedXOrigin] == turn) {
			isCorrectTurn = true;
			Checker checker = validatePiece(convertedXOrigin, yOrigin);	
			do {
				System.out.println("Where would you like to move");
				 moveInput = keyboard.next();
				if(validateInput(moveInput)) {
					System.out.println("Error in Input, please try again");
					error = true;
				} else {
					error = false;
					System.out.println("No errors found with input move");
				}
			} while(error);
			
		
			
			String xMove = moveInput.substring(0, 1);
			int yMove = Integer.parseInt(moveInput.substring(1,2));
			int convertedXMove = convertXPosition(xMove);
			yMove -= 1;
			boolean isMovingRight = isMovingRight(convertedXOrigin, yOrigin, convertedXMove, yMove);
			boolean isMovingDown = isMovingDown(convertedXOrigin, yOrigin, convertedXMove, yMove);
			Move move = null;
			
			//checks to see if the move itself is valid
			
		if(isMoveValid(convertedXOrigin, yOrigin, convertedXMove, yMove, isMovingRight, isMovingDown)) {
			if(isSpaceTaken(convertedXMove, yMove)) {
				System.out.println("Space is taken");
				if(isPieceEnemy(convertedXMove, yMove, checker, turn)) {
					if(isJumpValid(convertedXOrigin, yOrigin, convertedXMove, yMove, isMovingRight, isMovingDown)) {
						if(isMovingRight) {
							//checks to see if the piece is moving up or down
							if(isMovingDown) {
								//means the piece is moving right and down
								 move = new Move(convertedXOrigin, yOrigin, convertedXMove + 1, yMove + 1);
								model.moves.add(move);	
							} else {
								//means the piece is moving right, but up
								 move = new Move(convertedXOrigin, yOrigin, convertedXMove + 1, yMove - 1);
								model.moves.add(move);
							}
							
						} else {
							if(isMovingDown) {
								//means its moving left and down
								move = new Move(convertedXOrigin, yOrigin, convertedXMove - 1, yMove + 1);
								model.moves.add(move);
							} else {
								//means it's moving left and up
								move = new Move(convertedXOrigin, yOrigin, convertedXMove - 1, yMove - 1);
								model.moves.add(move);	
							}
							
						}
					}
				}
			} else {
				System.out.println("Space isn't taken");
				move = new Move(convertedXOrigin, yOrigin, convertedXMove, yMove);
				model.moves.add(move);
				updateBoard(move);
				model.updateChecker(move, checker, turn);
				printBoard();
				return move;
			}
		} else {
			System.out.println("Move is invalid");
			isCorrectTurn = false;
		}
		updateBoard(move);
		model.updateChecker(move, checker, turn);
		printBoard();
		return move;
		}
		
		}while(!isCorrectTurn);

		printBoard();
		return null;
		
	}
//			if(validateMove(convertedXOrigin, yOrigin, convertedXMove, yMove) ) {
//			//checks to see if there is a piece to take
//					if(isJumpValid(convertedXOrigin, yOrigin, convertedXMove, yMove, isMovingRight, isMovingDown)) {
//						//checks to see if the piece is moving left or right
//						if(isMovingRight) {
//							//checks to see if the piece is moving up or down
//							if(isMovingDown) {
//								//means the piece is moving right and down
//								 move = new Move(convertedXOrigin, yOrigin, convertedXMove + 1, yMove + 1);
//								model.moves.add(move);	
//							} else {
//								//means the piece is moving right, but up
//								 move = new Move(convertedXOrigin, yOrigin, convertedXMove + 1, yMove - 1);
//								model.moves.add(move);
//							}
//							
//						} else {
//							if(isMovingDown) {
//								//means its moving left and down
//								move = new Move(convertedXOrigin, yOrigin, convertedXMove - 1, yMove + 1);
//								model.moves.add(move);
//							} else {
//								//means it's moving left and up
//								move = new Move(convertedXOrigin, yOrigin, convertedXMove - 1, yMove - 1);
//								model.moves.add(move);	
//							}
//							
//						}
					


//		} else {
//			System.out.println("It is not your turn");
//			isCorrectTurn = false;
//		}
		
		
		
		
		
	
	

	
	public void undoRedoBoard(Move move) {
		
		int type = board.getBoard()[move.getyMove()][move.getxMove()];
		
		board.getBoard()[move.getyOrigin()][move.getxOrigin()] = type;
		board.getBoard()[move.getyMove()][move.getxMove()] = 0;
		
		
	}
	
	
	
	
	
	//TODO Update this so that White can be updated and move as well
	public void updateBoard(Move move) {
		
		int type = board.getBoard()[move.getyOrigin()][move.getxOrigin()];
		
			board.getBoard()[move.getyOrigin()][move.getxOrigin()] = 0;
			board.getBoard()[move.getyMove()][move.getxMove()] = type;
	
	}
	
	//checks to see if the piece exists

	public void removeTakenPiece(int xPiece, int yPiece) {
		
		board.getBoard()[yPiece][xPiece] = 0;
		
	}


	
public static void main(String args[]) {
	Game controller = new Game();
	int turn = 1;
	
	controller.printBoard();
	controller.populateModel();
	controller.movePiece(turn);

	turn = 2;
	controller.movePiece(turn);
	turn = 1;
	controller.movePiece(turn);

	controller.movePiece(turn);

	controller.printList();
	controller.moveThroughList();
	
}
	
	
	

	
	
	
}

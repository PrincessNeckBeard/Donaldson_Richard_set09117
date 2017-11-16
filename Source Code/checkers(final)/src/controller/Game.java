package controller;

import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

import model.Board;
import model.Checker;
import model.Model;
import model.Move;
/*
 * This Class is used to communicate between the Model and View Classes.
 * 
 */
public class Game {
	//Creates a model object for the controller to use
	Model model = new Model();
	//Creates a board object for the controller to use
	Board board = new Board();
	int blackPieces = 12;
	int whitePieces = 12;
	//LinkedList used to store the possible moves that the AI can make during their turn
	LinkedList<Move> AIPossibleMoves = new LinkedList<Move>();
	
	 public void populateModel() {
		model.populate();
		
	}
	
//Used to output the board to the console
	public void printBoard() {
String xAxis[] = {"A", "B", "C", "D", "E", "F", "G", "H"};
		for(int k = 0; k <8; k++) {
			System.out.print("\t" + xAxis[k]);
		}
		System.out.println("\n");
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
	

	//used to move through the list of moves that have been played
	//This is the Undo/Redo feature of the game
	public void moveThroughList() {
		int choice = 0;
		int i = 0;
		int j = 0;

		System.out.println("1. " + "\t" + "undo ( Move backwards through list)");
		System.out.println("2. " + "\t" + "redo ( Move forwards through list");
		System.out.println("3. " + "\t" + "Exit Method");
		
		Scanner input = new Scanner(System.in);
		Move test;
		
		
		
	do {
		choice = input.nextInt();
		//Undo Move
		if (choice == 1) {
			
			i = (model.moves.size() - 1); 
			System.out.println("i is: " + i);
			if(i == 0) {
				System.out.println("There are no more moves to undo");
			}
			
			test = model.moves.get(i);
			undoRedoBoard(test);
			model.copy.add(test);
			model.moves.remove(test);
			 System.out.println("Undo'd move ");
			model.printList();
			
			//Redo Move
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
			model.printList();
			}
		} 
		
		//Exit method
	} while(choice != 3);
		input.close();
	}
	//Converts the Co-ordinate input into a value the board array can use
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
	//validates the users input
	public static Boolean validateInput(String input) {
		String xInput = input.substring(0,1);

	

		
		boolean xIsLetter = Character.isLetter(xInput.charAt(0));

		if((!input.isEmpty()) || (!xIsLetter)) {
	
			return false;
		} else {

			return true; 
			}
		}
		//checks to see if the piece exists
	public Checker validatePiece(int xValue, int yValue) {
		

		Checker checker = model.findChecker(xValue, yValue);
		 return checker;
	}
	
	


//Used to check if the Piece is trying to move Right
	public boolean isMovingRight(int xOrigin, int yOrigin, int xMove, int yMove) {
		if(xMove == (xOrigin + 1)) {
			//System.out.println("IsMovingRight is true");
			return true;
		} else {
			//System.out.println("isMovingRight is false");
			return false;
		}
		
	}
	//Used to check if the Piece is trying to move Down
	public boolean isMovingDown(int xOrigin, int yOrigin, int xMove, int yMove) {
		if(yMove == (yOrigin + 1)) {
		//	System.out.println("IsMovingDown is true");
			return true;
		} else {
		//	System.out.println("IsMovingDown is false");
			return false;
		}
	}
	
//Checks to see if the Jump is valid
	public boolean isJumpValid(int xOrigin, int yOrigin, int xMove, int yMove, boolean isMovingRight, boolean isMovingDown) {

		try {
		
	if(isMovingDown) {
		if(isMovingRight) {
			//checks if moving down and right
			if(board.getBoard()[yMove + 1][xMove + 1] == 0 ) {
			//	System.out.println("Moving down and right. Space is empty");
				return true;
			}
		} else {
			if(board.getBoard()[yMove + 1][xMove - 1] == 0 ) {
			//	System.out.println("Moving down and left. Space is empty");
				return true;
			}
			
		}
		
	} else {
		if(isMovingRight) {
			//checks moving up and right
			if(board.getBoard()[yMove - 1][xMove + 1] == 0) {
				//System.out.println("Moving up and right. Space is empty");
				return true;
			}
		} else {
			if(board.getBoard()[yMove - 1][xMove - 1] == 0) {
				//System.out.println("Moving up and left. Space is empty");
				return true;
			}
		}
			return false;
	}
			
if(isMovingRight) {
//checks to see if space behind the piece is empty	
	if(board.getBoard()[yMove + 1][xMove + 1] == 0) {
	//	System.out.println("Jump is valid - space empty");
		return true;
	} else {
	//	System.out.println("Space is not empty");
		return false;
	}
} else {
	if(board.getBoard()[yMove + 1][xMove - 1] == 0) {
		//System.out.println("Jump is valid");
		return true;
	} else {
		//System.out.println("Jump is invalid");
	}
}
		return false;
		} catch (IndexOutOfBoundsException e) {
			//System.out.println("Index Out of Bounds - Move invalid");
			return false;
		}
	}	
	
//Checks to see if the space the piece is trying to move to is taken
	public boolean isSpaceTaken(int xValue, int yValue) {


		if((board.getBoard()[yValue][xValue] == 1) || (board.getBoard()[yValue][xValue] == 3)) {
			//System.out.println("Piece is black");
			return true;
		} else if ((board.getBoard()[yValue][xValue] == 2) || (board.getBoard()[yValue][xValue] == 4)) {
			//System.out.println("Piece is white");
			return true;
		} else {
			return false;
		}
		
		
	}
	//checks to see if a Piece in the move space is an enemy
	public boolean isPieceEnemy(int xValue, int yValue, Checker checker, int turn) {
		
		int attackingPiece = checker.getType();
		int piece = board.getBoard()[yValue][xValue];
		
		if((attackingPiece == 1) || (attackingPiece == 3)) {
			if((piece == 2) || (piece == 4)) {
			//	System.out.println("Piece is the enemy");
				return true;
			} else {
			//	System.out.println("Piece is not the enemy");
				
			}
				
		} else {
			if((piece == 1) || (piece == 3)) {
			//	System.out.println("Piece is the enemy");
				return true;
			} else {
			//	System.out.println("Piece is not the enemy");
			}
		}
		return false;
	}
	
//checks to see if the move itself is moving to a valid space
	public boolean isMoveValid(int xOrigin, int yOrigin, int xMove, int yMove, boolean isMovingRight, boolean isMovingDown) {

		int type = board.getBoard()[yOrigin][xOrigin];
		
		switch(type) {
		case 1:
			if(isMovingDown) {
				if(xMove == (xOrigin + 1)) {
				//	System.out.println("xMove is valid");
					isMovingRight = true;
					if(yMove == (yOrigin + 1)) {
				//		System.out.println("yMove is valid");
						return true;
						
					} else {
				//		System.out.println("yMove is invalid");
						return false;
					}
				} else if(xMove == (xOrigin - 1)) {
				//		System.out.println("xMove is Valid");
						isMovingRight = false;
						if(yMove == (yOrigin + 1)) {
				//			System.out.println("yMove is valid");
							return true;
						}
						else {
				//			System.out.println("yMove is invalid");
							return false;
						}
					} else {
				//		System.out.println("xMove is Invalid");
				}
				
			} else {
				System.out.println("You're moving in the wrong direction, idiot!");
				return false;
			}
		case 2:
			if(!isMovingDown) {
			if(xMove == (xOrigin + 1)) {
			//	System.out.println("xMove is valid");
				isMovingRight = true;
				if(yMove == (yOrigin - 1)) {
			//		System.out.println("yMove is valid");
					return true;
				} else {
		//			System.out.println("yMove is invalid");
					return false;
				}
			} else if (xMove == (xOrigin - 1)) {
			//	System.out.println("xMove is valid");
				isMovingRight = false;
				if(yMove == (yOrigin - 1)) {
			//		System.out.println("yMove is valid");
					return true;
				} else {
			//		System.out.println("yMove is invalid");
					return false;
				}
			} else {
		//		System.out.println("xMove is invalid");
			}

		
		} else {
			System.out.println("You're moving in the wrong direction, idiot!");
			return false;
		}
		case 3:
		case 4:
			if(isMovingDown) {
				if(xMove == (xOrigin + 1)) {
		//			System.out.println("xMove is valid");
					isMovingRight = true;
					if(yMove == (yOrigin + 1)) {
		//				System.out.println("yMove is valid");
						return true;
						
					} else {
			//			System.out.println("yMove is invalid");
						return false;
					}
				} else if(xMove == (xOrigin - 1)) {
			//			System.out.println("xMove is Valid");
						isMovingRight = false;
						if(yMove == (yOrigin + 1)) {
			//				System.out.println("yMove is valid");
							return true;
						}
						else {
			//				System.out.println("yMove is invalid");
							return false;
						}
					} else {
			//			System.out.println("xMove is Invalid");
				}
				
			}
			
			if(!isMovingDown) {
				if(xMove == (xOrigin + 1)) {
			//		System.out.println("xMove is valid");
					isMovingRight = true;
					if(yMove == (yOrigin - 1)) {
			//			System.out.println("yMove is valid");
						return true;
					} else {
			//			System.out.println("yMove is invalid");
						return false;
					}
				} else if (xMove == (xOrigin - 1)) {
			//		System.out.println("xMove is valid");
					isMovingRight = false;
					if(yMove == (yOrigin - 1)) {
			//			System.out.println("yMove is valid");
						return true;
					} else {
			//			System.out.println("yMove is invalid");
						return false;
					}
				} else {
			//		System.out.println("xMove is invalid");
				}

			
			} 	
		
		
		
		
		}		

		return false;
	}

	//Used to move the Users Pieces
	public  Move movePiece(int turn) {
		boolean error = false;
		String moveInput;
		String origin;
		boolean isCorrectTurn = false;
		Scanner keyboard = new Scanner(System.in);

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
			
		if((board.getBoard()[yOrigin][convertedXOrigin] == turn) || (board.getBoard()[yOrigin][convertedXOrigin] == (turn + 2))) {
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
				//	System.out.println("No errors found with input move");
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
			try {
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
								removeTakenPiece(convertedXMove, yMove);
							} else {
								//means the piece is moving right, but up
								 move = new Move(convertedXOrigin, yOrigin, convertedXMove + 1, yMove - 1);
								model.moves.add(move);
								removeTakenPiece(convertedXMove, yMove);
							}
							
						} else {
							if(isMovingDown) {
								//means its moving left and down
								move = new Move(convertedXOrigin, yOrigin, convertedXMove - 1, yMove + 1);
								model.moves.add(move);
								removeTakenPiece(convertedXMove, yMove);
							} else {
								//means it's moving left and up
								move = new Move(convertedXOrigin, yOrigin, convertedXMove - 1, yMove - 1);
								model.moves.add(move);	
								removeTakenPiece(convertedXMove, yMove);
							}
							
						}
					}
				
				}
			} else {
				System.out.println("Space isn't taken");
				move = new Move(convertedXOrigin, yOrigin, convertedXMove, yMove);
				model.moves.add(move);
				if(canBeKing(checker, move)) {
					checker = convertToKing(checker, move);
					model.updateChecker(move, checker, turn);
					
					
					printBoard();
					return move;
				}
				
				model.updateChecker(move, checker, turn);
				updateBoard(move);
				
				printBoard();
				return move;
			}
		} else {
			System.out.println("Error in move");
			//System.out.println("It's not your turn");
			isCorrectTurn = false;
		}
			} catch (NullPointerException e) {
				System.out.println("NullPointerException - Error");
				return null;
			}
		
		if(canBeKing(checker, move)) {
			checker = convertToKing(checker, move);
			model.updateChecker(move, checker, turn);
			
			printBoard();
			return move;
		}
		
		
		
		
		model.updateChecker(move, checker, turn);
		updateBoard(move);
		
		printBoard();
		return move;
		}
		
		}while(!isCorrectTurn);

		printBoard();
		return null;
		
	}
	//Used to update the board during Undo/Redo
	public void undoRedoBoard(Move move) {
		
		int type = board.getBoard()[move.getyMove()][move.getxMove()];
		
		board.getBoard()[move.getyOrigin()][move.getxOrigin()] = type;
		board.getBoard()[move.getyMove()][move.getxMove()] = 0;
	
	}

//used to update the board during Movement
	public void updateBoard(Move move) {
		try {
		int type = board.getBoard()[move.getyOrigin()][move.getxOrigin()];
		
			board.getBoard()[move.getyOrigin()][move.getxOrigin()] = 0;
			board.getBoard()[move.getyMove()][move.getxMove()] = type;
		} catch (NullPointerException e) {
			System.out.println("Move invalid");
		}
	}
	

//Removes a piece from the game if it has been taken
	public void removeTakenPiece(int xPiece, int yPiece) {
		System.out.println("Removing Piece");
		Checker checker = model.findChecker(xPiece,  yPiece);
		if((checker.getType() == 1) || (checker.getType() == 3)) {
			model.blackPieces.remove(checker);
			blackPieces -= 1;
		} else {
			model.whitePieces.remove(checker);
			whitePieces -= 1;
		}
		board.getBoard()[yPiece][xPiece] = 0;
		
	}

	//outputs the Checkers still in play for testing
	public void outputPieces() {
		model.outputCheckers();
	}
	
	//used to change the next turn for two players
	public int nextTurn(int turn) {
		if(turn == 1) {
			turn = 2;
			System.out.println("It's White's turn");
		} else  if(turn == 2){
			turn = 1;
			System.out.println("It's Black's turn");
		}
		
		return turn;
	}

//checks to see if the Piece can become King
	 public boolean canBeKing(Checker checker, Move move) {
		 
		 if(checker.getType() == 1) {
			 if(move.getyMove() == 7) {
				System.out.println("Checker is becoming a king");
				 return true;
			 } else {
				 //Do nothing
				
			 }
		 }
		 
			 if(checker.getType() == 2) {
				 if(move.getyMove() == 0) {
					 System.out.println("Checker is becoming a king");
					 return true;
					 
				 } else {
					 
				 }
			 }
			
		return false;
			 
		 }
		 
	 //converts the piece to king
	 public Checker convertToKing(Checker checker, Move move) {
		 int type = 0;
		 if(checker.getType() == 1) {
			 checker.setType(3);
			 type = 3;
		 } else if (checker.getType() == 2) {
			 checker.setType(4);
			 type = 4;
		 }
		 
		 board.getBoard()[move.getyOrigin()][move.getxOrigin()] = 0;
		board.getBoard()[move.getyMove()][move.getxMove()] = type;
		 
		return checker;
		 
		 
	 }
		 
//used to check the end game winner		 
	public int hasBlackWon() {
		if(blackPieces == 0) {
			return 1;
		} else if(whitePieces == 0) {
			return 2;
		}
		
		return 0;
	}
	 //used to check all the possible moves for the AI
	public LinkedList<Move> getPossibleMoves() {
		AIPossibleMoves.clear();
		int xOrigin = 0, yOrigin = 0, xMove1 = 0, xMove2 = 0, yMove1 = 0, yMove2 = 0;
		boolean isMovingRight;
		Move move = null;	
			int type = 0;
			for(Checker checker: model.whitePieces) {
				
				xOrigin = checker.getCurrentXPosition();
				yOrigin = checker.getCurrentYPosition();
				xMove1 = (checker.getCurrentXPosition() - 1);
				xMove2 = (checker.getCurrentXPosition() + 1);
				yMove1 = (checker.getCurrentYPosition() - 1);
				yMove2 = (checker.getCurrentYPosition() + 1);
				type = checker.getType();
				switch(type) {
				case 2:

					if((xMove1 < 0) || (yMove1 <0)) {
					//	continue;
					} else {
					if(isMoveValid(xOrigin,yOrigin, xMove1, yMove1, false, false )) {
						if(!isSpaceTaken(xMove1,yMove1)) {
							//System.out.println("Space is not Taken");
							move = new Move(xOrigin, yOrigin, xMove1, yMove1);
							AIPossibleMoves.add(move);
						} else {
							if(isPieceEnemy(xMove1,yMove1,checker,2)) {
								if(isJumpValid(xOrigin, yOrigin, xMove1, yMove1, false, false)) {
									move = new Move(xOrigin, yOrigin, xMove1, yMove1);
									AIPossibleMoves.add(move);	
								}
							}
						}
						}
					}
                            
					if((xMove2 > 7) || (yMove1 < 0)) {
					//	continue;
					} else {
				
					if(isMoveValid(xOrigin,yOrigin, xMove2, yMove1, true, false )) {
						if(!isSpaceTaken(xMove2,yMove1)) {
							// System.out.println("Space is not Taken");
							move = new Move(xOrigin, yOrigin, xMove2, yMove1);
							AIPossibleMoves.add(move);	
						} else {
							if(isPieceEnemy(xMove2,yMove1,checker,2)) {
								if(isJumpValid(xOrigin, yOrigin, xMove2, yMove1, true, false)) {
									move = new Move(xOrigin, yOrigin, xMove2, yMove1);
									AIPossibleMoves.add(move);	
								
								}
							}
						}
					}	
				}
				break;
					
				case 4:
					//Moving up and left    isMovingRight,IsMovingDown
					if((xMove1 <0) || (yMove1 < 0)) {
						//continue;
					} else {
					if(isMoveValid(xOrigin,yOrigin, xMove1, yMove1, false, false )) {
						if(!isSpaceTaken(xMove1,yMove1)) {
						//	System.out.println("Space is not Taken");
							move = new Move(xOrigin, yOrigin, xMove1, yMove1);
							AIPossibleMoves.add(move);	
						} else {
							if(isPieceEnemy(xMove1,yMove1,checker,2)) {
								if(isJumpValid(xOrigin, yOrigin, xMove1, yMove1, false, false)) {
									move = new Move(xOrigin, yOrigin, xMove1, yMove1);
									AIPossibleMoves.add(move);	
								}
							}
						}
					}
					}
				
				if((xMove2 > 7) || (yMove1 < 0)) {
					//continue;
				} else {
					//moving up and right
					if(isMoveValid(xOrigin,yOrigin, xMove2, yMove1, true, false )) {
						if(!isSpaceTaken(xMove2,yMove1)) {
						//	System.out.println("Space is not Taken");
							move = new Move(xOrigin, yOrigin, xMove2, yMove1);
							AIPossibleMoves.add(move);	
						} else {
							if(isPieceEnemy(xMove2,yMove1,checker,2)) {
								if(isJumpValid(xOrigin, yOrigin, xMove2, yMove1, true, false)) {
									move = new Move(xOrigin, yOrigin, xMove2, yMove1);
									AIPossibleMoves.add(move);	
								}
							}
						}
					}
				}
				
				if((xMove1 < 0) || (yMove2 > 7)) {
				//	continue;
				} else {
					//moving down and left isMovingRight,IsMovingDown
					if(isMoveValid(xOrigin,yOrigin, xMove1, yMove2, false, true )) {
						if(!isSpaceTaken(xMove1,yMove2)) {
						//	System.out.println("Space is not Taken");
							move = new Move(xOrigin, yOrigin, xMove1, yMove2);
							AIPossibleMoves.add(move);	
						} else {
							if(isPieceEnemy(xMove1,yMove2,checker,2)) {
								if(isJumpValid(xOrigin, yOrigin, xMove1, yMove2, false, true)) {
									move = new Move(xOrigin, yOrigin, xMove1, yMove2);
									AIPossibleMoves.add(move);	
								}
							}
						}
					}
				}
				
				if((xMove2 > 7) || (yMove2 > 7)) {
					//continue;
				} else {
				
					//moving down and right isMovingRight,IsMovingDown
					if(isMoveValid(xOrigin,yOrigin, xMove2, yMove2, true, true )) {
						if(!isSpaceTaken(xMove2,yMove2)) {
						//	System.out.println("Space is not Taken");
							move = new Move(xOrigin, yOrigin, xMove2, yMove2);
							AIPossibleMoves.add(move);	
						} else {
							if(isPieceEnemy(xMove2,yMove2,checker,2)) {
								if(isJumpValid(xOrigin, yOrigin, xMove2, yMove2, true, true)) {
									move = new Move(xOrigin, yOrigin, xMove2, yMove2);
									AIPossibleMoves.add(move);	
								}
							}
						}
					}
				}
					
					
				break;	
				}	
			
			}

			return AIPossibleMoves;
			
		}
	//used to output AI Possible Moves for testing
	public void outputPossibleMoves() {
		System.out.println("###########POSSIBLE MOVES ####################");
		for(Move move: AIPossibleMoves) {
			System.out.println(move.toString());
		}
		System.out.println("#############################################");
	}
	
	
	//used to allow the AI to make its move
	public void AIMakeMove() {
		
		Random randomizer = new Random();
		int index = randomizer.nextInt(AIPossibleMoves.size());
		Move move = AIPossibleMoves.get(index);
		Checker checker = model.findChecker(move.getxOrigin(), move.getyOrigin());
		int xChange = (move.getxOrigin() - move.getxMove());
		int yChange = (move.getyOrigin() - move.getyMove());
		
		int xMoveNew = 0;
		int yMoveNew = 0;
		
		
		
		
		
		if(board.getBoard()[move.getyMove()][move.getxMove()] == 0) {
			//do nothing
		} else {
			//moving down
			if(yChange < 0) {
				//moving right
				if(xChange < 0) {
					removeTakenPiece(move.getxMove(), move.getyMove());
					xMoveNew = move.getxMove() + 1;
					yMoveNew = move.getyMove() + 1;
					move.setxMove(xMoveNew);
					move.setyMove(yMoveNew);
					
					
				} else {
					
					//moving left
					
					removeTakenPiece(move.getxMove(), move.getyMove());
					xMoveNew = move.getxMove() - 1;
					yMoveNew = move.getyMove() + 1;
					move.setxMove(xMoveNew);
					move.setyMove(yMoveNew);
				}
			} else {
				//moving up
				if(xChange < 0) {
					//moving right
					removeTakenPiece(move.getxMove(), move.getyMove());
					xMoveNew = move.getxMove() + 1;
					yMoveNew = move.getyMove() - 1;
					move.setxMove(xMoveNew);
					move.setyMove(yMoveNew);
				} else {
					//moving left 
					removeTakenPiece(move.getxMove(), move.getyMove());
					xMoveNew = move.getxMove() - 1;
					yMoveNew = move.getyMove() - 1;
					move.setxMove(xMoveNew);
					move.setyMove(yMoveNew);
				}
				
			}
		}
		
		System.out.println("New Move is: " + xMoveNew + "," + yMoveNew);
		if(canBeKing(checker, move)) {
			checker = convertToKing(checker, move);
			model.updateChecker(move, checker, 2);
			
			printBoard();
			model.moves.add(move);
			return;
		}
		model.updateChecker(move, checker, 2);
		System.out.println("AI - DEBUGGING");
		System.out.println("Origin Piece: " + move.getxOrigin() + "," + move.getyOrigin());
		System.out.println("Move Position: " + move.getxMove() + "," + move.getyMove());
		updateBoard(move);
		model.moves.add(move);
		printBoard();
		
	}

//method that clears the console
	public static void clearScreen() {  
	    System.out.print("\033[H\033[2J");  
	    System.out.flush();  
	   } 
	
	
	
	//main method that runs the game
public static void startGame(int key) {
	Game controller = new Game();
int endGameCheck = 0;
	int turn = 1;
	boolean endgame = false;
	
	controller.populateModel();
	if(key == 1) {
	do {
		try {
			controller.getPossibleMoves();
			controller.outputPossibleMoves();
			controller.AIMakeMove();
			
			controller.movePiece(turn);
			
		
			
		} catch(NullPointerException e) {
			System.out.println("Null Pointer Exception - Try Catch Main");
		}
		
		endGameCheck = controller.hasBlackWon();
		
		if(endGameCheck != 0) {
			endgame = true;
		}
	} while(!endgame);
	} else if(key == 2) {
		do {
			
			try {
				
			controller.movePiece(turn);
			//controller.outputPieces();
			//controller.printList();
	//		controller.moveThroughList();
			turn =	controller.nextTurn(turn);
			
			} catch(NullPointerException e) {
				System.out.println("Try catch in Main caught this");
				
			}
			
		endGameCheck = controller.hasBlackWon();
		
		if(endGameCheck != 0) {
			endgame = true;
			
		} 
	}while(!endgame);
	} else {
		System.out.println("Error in input");
	}
	


}

	
}

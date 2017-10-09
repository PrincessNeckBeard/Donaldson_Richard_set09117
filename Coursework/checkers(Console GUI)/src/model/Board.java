package model;


import controller.Enumerations.CellEntry;

import java.util.*;

public class Board {

	int blackPieces;
	int whitePieces;
	
	static final int rows = 8;
	static final int columns = 8;
	CellEntry cell[][];
	
	Board() {
		this.blackPieces = 12;
		this.whitePieces = 12;
		
		this.cell = new CellEntry[][] {
			 {CellEntry.white, CellEntry.inValid, CellEntry.white, CellEntry.inValid, CellEntry.white, CellEntry.inValid, CellEntry.white, CellEntry.inValid},
	            {CellEntry.inValid, CellEntry.white, CellEntry.inValid, CellEntry.white, CellEntry.inValid, CellEntry.white, CellEntry.inValid, CellEntry.white},
	            {CellEntry.white, CellEntry.inValid, CellEntry.white, CellEntry.inValid, CellEntry.white, CellEntry.inValid, CellEntry.white, CellEntry.inValid},
	            {CellEntry.inValid, CellEntry.empty, CellEntry.inValid, CellEntry.empty, CellEntry.inValid, CellEntry.empty, CellEntry.inValid, CellEntry.empty},
	            {CellEntry.empty, CellEntry.inValid, CellEntry.empty, CellEntry.inValid, CellEntry.empty, CellEntry.inValid, CellEntry.empty, CellEntry.inValid},            
	            {CellEntry.inValid, CellEntry.black, CellEntry.inValid, CellEntry.black, CellEntry.inValid, CellEntry.black, CellEntry.inValid, CellEntry.black},
	            {CellEntry.black,CellEntry.inValid, CellEntry.black, CellEntry.inValid, CellEntry.black, CellEntry.inValid, CellEntry.black, CellEntry.inValid},
	            {CellEntry.inValid, CellEntry.black, CellEntry.inValid, CellEntry.black, CellEntry.inValid, CellEntry.black, CellEntry.inValid, CellEntry.black}
		};
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
}

package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;

import model.*;
import view.*;

public class Checkers extends JFrame
{
   public Checkers(String title)
   {
      super(title);
      setDefaultCloseOperation(EXIT_ON_CLOSE);

      Board board = new Board();
      addRed(board);
      addBlack(board);
     // board.add(new Checker(CheckerType.RED_REGULAR), 4, 1);
    //  board.add(new Checker(CheckerType.BLACK_REGULAR), 6, 3);
    //  board.add(new Checker(CheckerType.RED_KING), 5, 6);
      setContentPane(board);
      
      
      
      

      pack();
      setVisible(true);
   }
   
   
   public void addRed(Board board) {
	   int j;
	      for(int i = 6; i <= 8; i++){
	    	  if(i % 2 == 0) {
				 j = 1;
				  
			  } else {
				  j = 2;
			  }
	    	  
	    	  for(int k = j; k<=8; k+=2) {
	    		  
	    		  
	    		  board.add(new Checker(CheckerType.RED_REGULAR), i, k);
	    		 
	    		  System.out.println("i: " + i + " k: " + k);
	    	  }
	    	  
	    	  
	      }
   }
   
   
   public void addBlack(Board board) {
	   int j;
	      for(int i = 1; i <= 3; i++){
	    	  if(i % 2 == 0) {
				 j = 1;
				  
			  } else {
				  j = 2;
			  }
	    	  
	    	  for(int k = j; k<=8; k+=2) {
	    		  
	    		  
	    		  board.add(new Checker(CheckerType.BLACK_REGULAR), i, k);
	    		 
	    		  System.out.println("i: " + i + " k: " + k);
	    	  }
	    	  
	    	  
	      }
   }
   
   

   public static void main(String[] args)
   {
      Runnable r = new Runnable()
                   {
                      @Override
                      public void run()
                      {
                         new Checkers("Checkers");
                      }
                   };
      EventQueue.invokeLater(r);
   }
}
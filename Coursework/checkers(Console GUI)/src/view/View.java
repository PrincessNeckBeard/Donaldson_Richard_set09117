package view;

import java.util.Scanner;

public class View {

	
	public static String startMenu() {
		String key;
		
		System.out.println("#########################################################");
		System.out.println("#########################################################");
		System.out.println("###                     CHECKERS                      ###");
		System.out.println("###                    Version 0.1                    ###");
		System.out.println("###             Made by Richard Donaldson             ###");
		System.out.println("###                     40329070                      ###");
		System.out.println("#########################################################");
		System.out.println("#########################################################");
		System.out.println("");
		System.out.println("###              PRESS ANY KEY TO CONTINUE            ###");
		
		
		Scanner keyboard = new Scanner(System.in);
		key = keyboard.next();
		keyboard.close();
		return key;
	}
	
	
	public static int userChoice() {
		
		System.out.println("Please choose an option.");
		System.out.println("1. \tPlayer Vs AI");
		System.out.println("2. \tPlayer Vs Player");
		System.out.println("3. \tAI Vs AI");
		System.out.println("4. \tView Played Game");
		System.out.println("5. \tExit");
		
		
		Scanner keyboard = new Scanner(System.in);
		int key = keyboard.nextInt();
		keyboard.close();
		
		return key;
	}
	
	
	
	
	
	
	
	
}

package view;

import java.util.Scanner;

import controller.Game;

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
		
		
		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
		key = keyboard.next();
		return key;
	}
	
	
	
	
	public static void main(String args[]) {
		startMenu();
		System.out.println("Please choose an option.");
		System.out.println("1. \tPlayer Vs AI");
		System.out.println("2. \tPlayer Vs Player");

		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
		int key = keyboard.nextInt();
		Game.startGame(key);
	}
	
}

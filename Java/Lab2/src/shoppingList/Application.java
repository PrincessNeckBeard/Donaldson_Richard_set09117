package shoppingList;

import java.util.Scanner;

public class Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ShoppingList myList = new ShoppingList();
		int userOpt = 0;
		while (userOpt != 3) {
			System.out.println("");
			System.out.println("----- Shopping List -----");
			System.out.println("(1) Add an item to the list. ");
			System.out.println("(2) Display List and total numberof items ");
			System.out.println("(3) Exit");
			
			userOpt = input.nextInt();
		}

	}

}

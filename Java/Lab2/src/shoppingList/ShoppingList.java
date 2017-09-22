package shoppingList;

import java.util.Scanner;
import java.util.ArrayList;

public class ShoppingList {
	
	ArrayList<ShoppingItem> list = new ArrayList<ShoppingItem>();
	
	public void addItem() {
		System.out.println("Welcome to Shop");
		System.out.println("Please enter in the name of your item");
		java.util.Scanner scan = new Scanner(System.in);
		String itemName = scan.nextLine();
		
		System.out.println("Please enter in the price of your item");
		String itemPrice = scan.nextLine();
		
		System.out.println("Please enter in the amount of your item ");
		String itemQty = scan.nextLine();
		
		ShoppingItem item = new ShoppingItem(itemName, Double.parseDouble(itemPrice), Integer.parseInt(itemQty));
		list.add(item);
		System.out.println("Item Added");
		
		
	}
	
	public void displayItem() {
		System.out.println(list.size() + " items. ");
		for(ShoppingItem x : list) {
			System.out.println(x.toString());
		}
	}
	
	

}

package shoppingList;

public class ShoppingItem {
	private String itemName;
	private double itemPrice;
	private int itemQty;
	
	
	
	
	
	
	public ShoppingItem(String itemName, double itemPrice, int itemQty) {
		super();
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemQty = itemQty;
	}




	public String getItemName() {
		return itemName;
	}




	public void setItemName(String itemName) {
		this.itemName = itemName;
	}






	public double getItemPrice() {
		return itemPrice;
	}






	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}






	public int getItemQty() {
		return itemQty;
	}






	public void setItemQty(int itemQty) {
		this.itemQty = itemQty;
	}


	@Override
public String toString() {
		String state = itemName + " - £" + itemPrice + " x " + itemQty;
		return state;
	}




	
	
	
	
	
	
	
	

}

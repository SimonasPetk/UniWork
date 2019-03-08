/** ShoppingBasket.java
 *
 * Model of a shopping basket containing items of shopping
* 
* @version 1.2 08/03/2019
* @author COM1003 Lecturer
* @author Simonas Petkevicius
*/

package uk.ac.sheffield.com1003.problemsheet2;

public class ShoppingBasket {
	
	// Instance Variables
	private Item[] items;
		
	/**
	* Constructor
	* @param it array of Item
	*/
	public ShoppingBasket(Item[] it) {
		
		items = it;
	}
	
	// Methods
	/**
	* Gets the total price of the ShoppingBasket
	* @return double total price of the basket
	*/
	public double getTotalPrice() {
		
		double tot = 0.0;

		for(int i = 0; i < items.length; i++) {
			tot += items[i].getPrice();
		}
		return tot;
 	}
	
	/**
	* Displays the total price of the ShoppingBasket
	* @return nothing
	*/
 	public void generateBill() {
 		

 		System.out.println(this.toString());
 	}
 	
 	/**
	* Returns the ShoppingBasket object converted to the string
	* @return String
	*/
 	public String toString() {
 		
		String text = "";
		
		for(int i = 0; i < items.length; i++) {
			text += items[i].toString() + "\n";
		}
		
		text += "Total price: " + getTotalPrice();
		return text;
 	}
 	
 	/**
	* Displays the object in the i-th index in the array
	* @param i index of the item in an array
	* @return String displays the object in the i-th index in the array
	*/
	public String displayIndividualItems(int i) {
		
		if(i < items.length) {
			return items[i].toString();
		}
		
		return "Such object doesn't exist";
 	}
	
	/**
	* Identifies equal objects and displays them on the console
	* @return nothing
	*/
	public void identifyEqual() {
		
		int repetitions = 0;
		boolean[] isChecked = new boolean[items.length];
		
		for(int i = 0; i < items.length; i++) {
			isChecked[i] = false;
		}
		
		for(int j = 0; j < items.length; j++) {
			for(int k = j + 1 ; k < items.length; k++) {
				if(items[j].equals(items[k]) && !isChecked[k]) {
					System.out.println("\nObject on index " + j +
									   " in the basket is equal to object on index " + k +
									   " in the basket. \nThis is the object: " + 
									   items[j].toString());
					repetitions++;
					isChecked[k] = true;
				}
			}
		}
		
		if(repetitions != 0) {
			System.out.println("\nThere are this many repetitive objects (not including the original object): " + repetitions);	
		}
		else {
			System.out.println("There are no equal objects");
		}
	}
	
	/**
	* Identifies equal objects and displays them on the console
	* @param first object of an item class
	* @param second other object of an item class
	* @return boolean returns true if two objects are equal, return false otherwise
	*/
	public boolean identifyEqual(Item first, Item second) {
		
		if(first.equals(second)) {
			return true;
		}
		return false;
	}
	
	 /**
	 * This is the main method which tries to fulfill all of.
	 * @param args Unused.
	 * @return Nothing.
	 */
 	public static void main( String[] args){
 		Item[] shopping = {
 				new ReducedItem("TV 30 in", 2999, 1000, "TV"),
 				new Item("Lord of the Rings", 14, "Book"),
 				new MultiSave("Ball pint pen", 1 , 50, 0.6, "Stationery"),
 				new ReducedItem("TV 30 in", 2999, 1000, "TV"),
 				new ReducedItem("TV 30 in", 2999, 1000, "TV"),
 				new ReducedItem("TV 30 in", 2999, 1000, "TV"),
 				new MultiSave("Ball pint pen", 1 , 50, 0.5, "Stationery"),
 				new ReducedItem("TV 30 in", 2999, 1000, "TV"),
 				new ReducedItem("TV 30 in", 2999, 1000, "TV"),
 				new ReducedItem("TV 30 in", 2999, 1000, "TV"),
 				new ReducedItem("TV 30 in", 2999, 1000, "TV"),
 				new MultiSave("Ball pint pen", 1 , 50, 0.5, "Stationery"),
 				new MultiSave("Ball pint pen", 1 , 50, 0.5, "Stationery"),
 				new MultiSave("Ball pint pen", 1 , 50, 0.5, "Stationery"),
 				new ReducedItem("TV 30 in", 2999, 1000, "TV")	
 		};
 		
		ShoppingBasket basket = new ShoppingBasket(shopping);
		
		// Prints the generated bill
		basket.generateBill();
		// Displays individual object which is on specified index
		basket.displayIndividualItems(0);
		// Identifies every equal object
		basket.identifyEqual();
		// Identifies if specified objects are equal
		System.out.println("\n" + basket.identifyEqual(shopping[0], shopping[1]));		
	}
}

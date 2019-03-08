/** 
* Item.java
* 
* Subclass of Item, where price is discounter for limited period
* 
* @version 1.1 08/03/2019
* @author Simonas Petkevicius
*/

package uk.ac.sheffield.com1003.problemsheet2;

public class ReducedItem extends Item
{
	// instance variables
	double reducedPrice;

	/**
	* Constructor
	* @param name name of the product
	* @param originalprice Price without discount of the product
	* @param reducedPrice price after discount was applied to the product
	* @param category what category the item is
	*/
	public ReducedItem(String name, double originalPrice, double reducedPrice, String category) {
		
		super(name, originalPrice, category);
		this.reducedPrice = reducedPrice;
	}
	
	//Methods
	/**
	* Passes the price of the ReducedItem
	* @return double price of the Reduceditem
	*/
	public double getPrice() {
		
		return reducedPrice;
	}
	
	/**
	* Returns the object in a string
	* @return string
	*/
	// using ukp to denote pounds sterling 
	public String toString() {
		
		return getName() + " = ukp " + getPrice() + " (multisave saving of ukp "
				+ (super.getPrice() - getPrice())+ ")" + " [category: " + getCategory() + "]"; 
	}

	/**
	* Returns true if objects are equal, returns false if they are not
	* @param obj object you want to compare with
	* @return boolean depending if objects are equal
	*/
	@Override
	public boolean equals(Object obj) {
		
		if(!super.equals(obj)) {
			return false;
		}

		ReducedItem that = (ReducedItem) obj;
		return ((this.reducedPrice == that.reducedPrice));
	}
}

/** 
* MultiSave.java
* 
* Subclass of Item, where price is discounted based on number of units being purchased 
* 
* @version 1.2 08/03/2019
* @author COM1003 Lecturer
* @author Simonas Petkevicius
*/


package uk.ac.sheffield.com1003.problemsheet2;

public class MultiSave extends Item
{
	
	// Instance Variables
	int numberUnits;
	double discount;
	
	/**
	* Constructor
	* @param productName name of the product
	* @param price Price of the product
	* @param numberUnits the number of units bought
	* @param discount the discount provided
	* @param category what category the item is
	*/
	public MultiSave(String productName, double price, int numberUnits, double discount, String category) {
		
		super(productName, price, category);
		this.numberUnits = numberUnits;
		this.discount = discount;
	}

	// Methods
	/**
	* Gets the price with discount
	* @return double price of the MultiSave
	*/
	public double getPrice() {
		
		return numberUnits * discount;
	}
	
	/**
	* Returns the object in a string
	* @return string
	*/
	// using ukp to denote pounds sterling 
	public String toString() {
		
		return getName() + " = ukp " + getPrice() + " (multisave saving of ukp "
				+ (super.getPrice() - discount) * numberUnits + ")" + " [category: " + getCategory() + "]"; 
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
		// casting object as a Multisave object
		MultiSave that = (MultiSave) obj;
		// comparing if instance variables are equal
		return ((this.numberUnits == that.numberUnits) &&
				(this.discount == that.discount));
	}
}

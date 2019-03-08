/** 
* Item.java
* 
* Model of an item of shopping
* 
* @version 1.2 08/03/2019
* @author COM1003 Lecturer
* @author Simonas Petkevicius
*/

package uk.ac.sheffield.com1003.problemsheet2;

public class Item {
	
	// Instance Variables
	private double price;
	private String name;
	private String category;

	/**
	* Constructor
	* @param name the name of the Item
	* @param price the price of the Item
	* @param category the category of the item
	*/
	public Item(String name, double price, String category) {
		
		this.name = name;   
		this.price = price;
		this.category = category;
	}

	// Methods
	/**
	* Passes the name of the Item
	* @return String name of the item
	*/
	public String getName() { 
		
		return name; 
	}
	
	/**
	* Passes the price of the Item
	* @return double price of the item
	*/
	public double getPrice() { 
		
		return price; 
	}
	
	/**
	* Passes the category of the Item
	* @return String category of the item
	*/
	public String getCategory() { 
		
		return category; 
	}
	
	/**
	* returns the object in a string
	* @return string
	*/
	// using ukp to denote pounds sterling 
	public String toString() { 
		
		return (name + " = ukp " + price + " [category: " + category + "]"); 
	}

	/**
	* returns true if objects are equal, returns false if they are not
	* @param obj object you want to compare with
	* @return boolean depending if objects are equal
	*/
	@Override
	//equals method to be added here
	public boolean equals(Object obj) {
		
		if(obj == null) {
			return false;
		}
		else if(this == obj) {
			return true;
		}
		else if(this.getClass() != obj.getClass()) {
			return false;
		}
		
		Item that = (Item) obj;
		return ((this.price == that.price)  &&
				(this.name.equals(that.name)) &&
				(this.category.equals(that.category)));
	}

	/**
	 * This is the main method which tries to fulfill all of the requirements.
	 * @param args Unused.
	 * @return Nothing.
	 */
	public static void main( String[] args){
		
		final String TESTNAME = "testObject";
		final double TESTPRICE = 10.0;
		final String TESTCATEGORY = "testCategory";
		Item testObject = new Item(TESTNAME,TESTPRICE,TESTCATEGORY);
		System.out.println("Name:");
		System.out.println("Actual field " + testObject.getName());
		System.out.println("Expected " + TESTNAME);
		System.out.println("Price:");
		System.out.println("Actual field " + testObject.getPrice());
		System.out.println("Expected " + TESTPRICE);
		System.out.println("Category:");
		System.out.println("Actual field " + testObject.getCategory());
		System.out.println("Expected " + TESTCATEGORY);
	}	
}
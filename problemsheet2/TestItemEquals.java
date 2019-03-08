/** 
* TestItemEquals.java
* 
* Test if item equals methods are working properly
* 
* @version 1.1 08/03/2019
* 
* @author Simonas Petkevicius
*/

package uk.ac.sheffield.com1003.problemsheet2;
import org.junit.*;
import static org.junit.Assert.*;

public class TestItemEquals
{
	
	// Instance Variables
	Item[] shoppingList = new Item[6];
	
	@Before
	public void setup(){
		shoppingList[0] = new Item("Lord of the Rings", 14, "Book");
		shoppingList[1] = new Item("Hobbit", 6, "Book");
		shoppingList[2] = new MultiSave("Balls", 3 , 40, 0.5, "Sports");
		shoppingList[3] = new MultiSave("Ball pint pen", 1 , 50, 0.6, "Stationery");
		shoppingList[4] = new ReducedItem("TV 30 in", 2999, 1000, "TV");
		shoppingList[5] = new ReducedItem("TV 40 in", 2999, 1010, "TV");
	}
	
	// Tests
	@Test
	public void testItemEqualsItem() {
		boolean result = shoppingList[0].equals(shoppingList[0]);
		
		assertEquals(true, result);
	}
	
	@Test
	public void testItemNotEqualsItem() {
		boolean result = shoppingList[0].equals(shoppingList[1]);
		
		assertEquals(false, result);
	}
	
	@Test
	public void testItemNotEqualsMultiSave() {
		boolean result = shoppingList[0].equals(shoppingList[2]);
		
		assertEquals(false, result);
	}
	
	@Test
	public void testItemEqualsReducedItem() {
		boolean result = shoppingList[0].equals(shoppingList[3]);
		
		assertEquals(false, result);
	}
	
	@Test
	public void testMultiSaveEqualsMultiSave() {
		boolean result = shoppingList[2].equals(shoppingList[2]);
		
		assertEquals(true, result);
	}
	
	@Test
	public void testMultiSaveNotEqualsMultiSave() {
		boolean result = shoppingList[2].equals(shoppingList[3]);
		
		assertEquals(false, result);
	}
	
	@Test
	public void testMultiSaveNotEqualsItem() {
		boolean result = shoppingList[2].equals(shoppingList[0]);
		
		assertEquals(false, result);
	}
	
	@Test
	public void testMultiSaveNotEqualsReducedItem(){
		boolean result = shoppingList[2].equals(shoppingList[4]);
		
		assertEquals(false, result);
	}
	
	@Test
	public void testReducedItemEqualsReducedItem() {
		boolean result = shoppingList[4].equals(shoppingList[4]);
		
		assertEquals(true, result);
	}
	
	@Test
	public void testReducedItemNotEqualsReducedItem() {
		boolean result = shoppingList[4].equals(shoppingList[5]);
		
		assertEquals(false, result);
	}
	
	@Test
	public void testReducedItemNotEqualsMultiSave() {
		boolean result = shoppingList[4].equals(shoppingList[2]);
		
		assertEquals(false, result);
	}
	
	@Test
	public void testReducedItemEqualsItem() {
		boolean result = shoppingList[4].equals(shoppingList[0]);
		
		assertEquals(false, result);
	}
	
	@After
	public void tearDown() {
	}
}

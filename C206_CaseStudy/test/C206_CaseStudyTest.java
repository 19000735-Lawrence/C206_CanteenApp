import static org.junit.Assert.*;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;



public class C206_CaseStudyTest {
	
	private static ArrayList<Order> orderListTest;
	private static ArrayList<MenuItem> menuListTest;
	private static ArrayList<Promotion> promoListTest;
	
	private static MenuItem menuItem1;
	private static MenuItem menuItem2;
	
	private static Order orderItem1;
	private static Order orderItem2;
	
	private static Promotion promoItem1;
	private static Promotion promoItem2;

	@Before
	public void setUp() throws Exception {
		orderListTest = new ArrayList<Order>();
		menuListTest = new ArrayList<MenuItem>();
		promoListTest = new ArrayList<Promotion>();
		
		menuItem1 = new MenuItem("Cheese Burger", "Fast Food", 3.99);
		menuItem2 = new MenuItem("Crab", "Sea Food", 5.99);
		
//		orderItem1 = new Order("Bob", "Testing", false, menuListTest);  //for ref
//		orderItem2 = new Order("Rob", "Testing", true, menuListTest);
		
		promoItem1 = new Promotion("Chicken Burger", "Fast Food", 2.00);
		
	
	}

	@After
	public void tearDown() throws Exception {
	}
	
	// Test Codes here \/ \/ \/
	
	@Test
	public void addOrderTest() { // Lawrence
		
		assertNotNull("Test if there is valid arraylist to add to", orderListTest);
		
		menuListTest.add(menuItem1);
		orderItem1 = new Order("Bob", "Testing", false, menuListTest);
		
		C206_CaseStudy.orderItem = orderItem1;
		C206_CaseStudy.addOrder(orderListTest);
		assertEquals("Test that arraylist size is 1", 1, orderListTest.size());
		assertSame("Test that Order is added", orderItem1, orderListTest.get(0));
		
		menuListTest.clear();
		menuListTest.add(menuItem2);
		orderItem2 = new Order("Rob", "Testing", true, menuListTest);
		
		C206_CaseStudy.orderItem = orderItem2;
		C206_CaseStudy.addOrder(orderListTest);
		assertEquals("Test that arraylist size is 2", 2, orderListTest.size());
		assertSame("Test that Order is added", orderItem2, orderListTest.get(1));
		
	}

	@Test
	public void deleteOrderTest() { // Lawrence
		//("Not yet implemented"); 
		menuListTest.add(menuItem1);
		orderItem1 = new Order("Bob", "Testing", false, menuListTest);
		
		C206_CaseStudy.orderItem = orderItem1;
		C206_CaseStudy.addOrder(orderListTest);
		assertEquals("Test that arraylist size is 1", 1, orderListTest.size());
		
		C206_CaseStudy.userName = "Bob";
		C206_CaseStudy.deleteOrder(orderListTest);
		assertEquals("Test that arraylist size is 0", 0, orderListTest.size());
	}
	
	@Test
	public void viewOrderTest() { // Lawrence
		
		menuListTest.add(menuItem1);
		orderItem1 = new Order("Bob", "Testing", false, menuListTest);
		
		C206_CaseStudy.orderItem = orderItem1;
		C206_CaseStudy.addOrder(orderListTest);

		assertNotNull("Test that there are things to output to method", orderListTest.get(0).toString());
		
	}
	
	@Test
	public void viewMenuTest() { // Keagan
		
		assertNotNull("Test if there is valid arraylist to retreive item from", menuListTest);
		
		String allMenu = C206_CaseStudy.retrieveMenuItems(menuListTest);
		String output = "";
		assertEquals("Test that the retrieved menuListTest is empty?", output, allMenu);
		
//		menuListTest.add(menuItem1);
//		menuListTest.add(menuItem2);
		C206_CaseStudy.addMenuItem(menuListTest, menuItem1);
		C206_CaseStudy.addMenuItem(menuListTest, menuItem2);
//		assertNotNull("Test that there are items to output from", menuListTest.get(0).toString());
		assertEquals("Test that the menuItemTest arraylist is 2", 2, menuListTest.size());
	}
	
	@Test
	public void addMenuTest() { // Keagan
		
		assertNotNull("Test if there is valid arraylist to add to", menuListTest);
		
//		menuListTest.add(menuItem1);
//		menuListTest.add(menuItem2);
		C206_CaseStudy.addMenuItem(menuListTest, menuItem1);
		assertEquals("Test that arraylist is 1", 1, menuListTest.size());
		assertSame("Check that menuItem1 is added", menuItem1, menuListTest.get(0));
		
		C206_CaseStudy.addMenuItem(menuListTest, menuItem2);
		assertEquals("Test that arraylist is 2", 2, menuListTest.size());
		assertSame("Check that menuItem1 is added", menuItem2, menuListTest.get(1));
		
		
	}
	
	
	
}

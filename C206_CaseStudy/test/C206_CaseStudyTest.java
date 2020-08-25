import static org.junit.Assert.*;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;



public class C206_CaseStudyTest {
	
	private static ArrayList<Order> orderListTest;
	private static ArrayList<MenuItem> menuListTest;
	private static ArrayList<PurchaseOrder> purchaseListTest;
	
	private static MenuItem menuItem1;
	private static MenuItem menuItem2;
	private static MenuItem menuItem3;
	private static MenuItem menuItem4;
	
	private static Order orderItem1;
	private static Order orderItem2;
	
	private static PurchaseOrder purchaseOrders;



	@Before
	public void setUp() throws Exception {
		orderListTest = new ArrayList<Order>();
		menuListTest = new ArrayList<MenuItem>();
		purchaseListTest = new ArrayList<PurchaseOrder>();
		
		menuItem1 = new MenuItem("Chicken Burger", "Fast Food", 2.99);
		menuItem2 = new MenuItem("Cheese Burger", "Fast Food", 3.99);
		menuItem3 = new MenuItem("Crab", "Sea Food", 5.99);
		menuItem4 = new MenuItem("Salmon", "Seafood", 6.99);
		purchaseOrders = new PurchaseOrder("");
		
//		orderItem1 = new Order("Bob", "Testing", false, menuListTest);  //for ref
//		orderItem2 = new Order("Rob", "Testing", true, menuListTest);
		

	}

	
	// Test Codes here \/ \/ \/
	
	@Test
	public void addOrderTest() { // Lawrence
		
		assertNotNull("Test if there is valid arraylist to add to", orderListTest);
		
		menuListTest.add(menuItem1);
		orderItem1 = new Order("Bob", "Testing", false, menuListTest);
		

		C206_CaseStudy.addOrder(orderListTest, orderItem1);
		assertEquals("Test that arraylist size is 1", 1, orderListTest.size());
		assertSame("Test that Order is added", orderItem1, orderListTest.get(0));
		
		menuListTest.clear();
		menuListTest.add(menuItem2);
		orderItem2 = new Order("Rob", "Testing", true, menuListTest);
		

		C206_CaseStudy.addOrder(orderListTest, orderItem2);
		assertEquals("Test that arraylist size is 2", 2, orderListTest.size());
		assertSame("Test that Order is added", orderItem2, orderListTest.get(1));
		
	}

	@Test
	public void deleteOrderTest() { // Lawrence
		//("Not yet implemented"); 
		menuListTest.add(menuItem1);
		orderItem1 = new Order("Bob", "Testing", false, menuListTest);
		

		C206_CaseStudy.addOrder(orderListTest, orderItem1);
		assertEquals("Test that arraylist size is 1", 1, orderListTest.size());
		
		C206_CaseStudy.userName = "Bob";
		C206_CaseStudy.deleteOrder(orderListTest, 1);
		assertEquals("Test that arraylist size is 0", 0, orderListTest.size());
	}
	
	@Test
	public void viewOrderTest() { // Lawrence
		
		menuListTest.add(menuItem1);
		orderItem1 = new Order("Bob", "Testing", false, menuListTest);
		
		
		C206_CaseStudy.addOrder(orderListTest, orderItem1);

		assertNotNull("Test that there are things to output to method", orderListTest.get(0).toString());
		
	}
	
	@Test
	public void totalOrderCostTest() { // Lawrence
		
		double total = 0;
		menuListTest.add(menuItem1);
		menuListTest.add(menuItem1);
		for (int i = 0; i < menuListTest.size(); i++) {
			total += menuListTest.get(i).getPrice();
		}
		
		assertEquals("Check that can get correct total price from menuItem arraylist", 2 * (menuItem1.getPrice()), total, 0);
	}
	
	@Test
	public void changeOrderStatusTest() { // Lawrence
		menuListTest.add(menuItem1);
		orderItem1 = new Order("Bob", "Testing", false, menuListTest);
		

		C206_CaseStudy.addOrder(orderListTest, orderItem1);
		
		C206_CaseStudy.changeOrderStatus(orderListTest, 1, "preparing", false);
		
		assertEquals("Check that order status is updated correctly",orderListTest.get(0).getStatus(), "preparing");
		assertEquals("Check that takeaway status is updated correctly",orderListTest.get(0).isTakeaway(), false);
	}
	
	
	@Test
	public void viewMenuTest() { // Keagan
		
		assertNotNull("Test if there is valid arraylist to retreive item from", menuListTest);
		
		String allMenu = C206_CaseStudy.retrieveMenuItems(menuListTest);
		String output = "";
		assertEquals("Test that the retrieved menuListTest is empty?", output, allMenu);
		
		C206_CaseStudy.addMenuItem(menuListTest, menuItem1);
		C206_CaseStudy.addMenuItem(menuListTest, menuItem2);
		assertEquals("Test that the menuItemTest arraylist is 2", 2, menuListTest.size());
	}
	
	@Test
	public void addMenuTest() { // Keagan
		
		assertNotNull("Test if there is valid arraylist to add to", menuListTest);
		
		C206_CaseStudy.addMenuItem(menuListTest, menuItem1);
		assertEquals("Test that arraylist is 1", 1, menuListTest.size());
		assertSame("Check that menuItem1 is added", menuItem1, menuListTest.get(0));
		
		C206_CaseStudy.addMenuItem(menuListTest, menuItem2);
		assertEquals("Test that arraylist is 2", 2, menuListTest.size());
		assertSame("Check that menuItem1 is added", menuItem2, menuListTest.get(1));
	}
	
	@Test
	public void deleteMenuTest() { // Keagan
		
		assertNotNull("Test if there is valid arraylist to delete from", menuListTest);
		
		menuListTest.add(menuItem1);
		menuListTest.add(menuItem2);
		
		C206_CaseStudy.name = "Crab";
		C206_CaseStudy.deleteMenuItem(menuListTest);
		assertEquals("Test that menuListTest arraylist is 1", 1, menuListTest.size());
	}
	
	@Test
	public void updateMenuTest() { // Keagan
		
		assertNotNull("Test if there is valid arrylist to update from", menuListTest);
		
		C206_CaseStudy.addMenuItem(menuListTest, menuItem2);
		
		boolean pass = C206_CaseStudy.doUpdateMenuItem(menuListTest, "Crab", 5.99);
		assertTrue("Test if the existing menu item is updated", pass);
	}
	
	@Test
	public void viewMenuByCategoryTest() {
		
		assertNotNull("Test if there is valid arraylist to retrieve item from", menuListTest);
		
		C206_CaseStudy.addMenuItem(menuListTest, menuItem1);
		C206_CaseStudy.addMenuItem(menuListTest, menuItem2);
		C206_CaseStudy.addMenuItem(menuListTest, menuItem3);
		C206_CaseStudy.addMenuItem(menuListTest, menuItem4);
	}
	
	
	@Test
	public void viewPurchaseTest() { // Jun Kai
		assertNotNull("Test if there is valid arraylist to retreive Purchase from", purchaseListTest);
		
		String allPurchase = C206_CaseStudy.retrievePurchaseOrders(purchaseListTest);
		String output = "";
		assertEquals("Test that the retrieved purchaseListTest is empty?", output, allPurchase);
		

		C206_CaseStudy.addPurchaseOrder(purchaseListTest, purchaseOrders);
		assertEquals("Test that the purchaseListTest arraylist is 1", 1, purchaseListTest.size());
	}
	
	@After
	public void tearDown() throws Exception {
	}
	
}

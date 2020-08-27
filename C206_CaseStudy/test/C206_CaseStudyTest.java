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
	private static MenuItem menuItem5;
	private static MenuItem menuItem6;
	
	private static Order orderItem1;
	private static Order orderItem2;
	
	private static PurchaseOrder purchaseOrders;
	private static ArrayList<Account> account;
	Account account1 = new Account("customer", "12376789", "111222", "YY", "password");
	Account account2 = new Account("Guest", "12376789", "222222", "YyY", "SB");


	@Before
	public void setUp() throws Exception {
		orderListTest = new ArrayList<Order>();
		menuListTest = new ArrayList<MenuItem>();
		purchaseListTest = new ArrayList<PurchaseOrder>();
		
		menuItem1 = new MenuItem("Chicken Burger", "Fast Food", 2.99);
		menuItem2 = new MenuItem("Fish Burger", "Fast Food", 3.99);
		menuItem3 = new MenuItem("Cheese Burger", "Fast Food", 4.99);
		menuItem4 = new MenuItem("Shrimp", "Seafood", 5.99);
		menuItem5 = new MenuItem("Crab", "Seadfood", 6.99);
		menuItem6 = new MenuItem("Salmon", "Seafood", 7.99);
		purchaseOrders = new PurchaseOrder("", 0);
		
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
		
		C206_CaseStudy.name = "Fish Burger";
		C206_CaseStudy.deleteMenuItem(menuListTest);
		assertEquals("Test that menuListTest arraylist is 1", 1, menuListTest.size());
	}
	
	@Test
	public void updateMenuTest() { // Keagan
		
		assertNotNull("Test if there is valid arrylist to update from", menuListTest);
		
		C206_CaseStudy.addMenuItem(menuListTest, menuItem2);
		
		boolean pass = C206_CaseStudy.doUpdateMenuItem(menuListTest, "Fish Burger", 3.99);
		assertTrue("Test if the existing menu item is updated", pass);
	}
	
	@Test
	public void viewMenuByPriceRangeTest() { // Keagan
		
		assertNotNull("Test if there is valid arraylist to retrieve item from", menuListTest);
		
		C206_CaseStudy.addMenuItem(menuListTest, menuItem1);
		C206_CaseStudy.addMenuItem(menuListTest, menuItem2);
		C206_CaseStudy.addMenuItem(menuListTest, menuItem3);
		C206_CaseStudy.addMenuItem(menuListTest, menuItem4);
		C206_CaseStudy.addMenuItem(menuListTest, menuItem5);
		C206_CaseStudy.addMenuItem(menuListTest, menuItem6);
		assertEquals("Test that menuListTest arraylist is 6", 6, menuListTest.size());
		
		Boolean pass = C206_CaseStudy.showMenuItemByPriceRange(menuListTest, 2.00, 5.00);
		assertTrue("Test if menu items price falls under the range between $2 and $5", pass);
		
		pass = C206_CaseStudy.showMenuItemByPriceRange(menuListTest, 8.00, 9.00);
		assertFalse("Test if menu items price falls under the range between $8 and $9", pass);
	}
	
	@Test
	public void addPurchaseTest() { // Jun Kai
		
		assertNotNull("Test if there is valid arraylist to add to", purchaseListTest);
		
		C206_CaseStudy.addPurchaseOrder(purchaseListTest, purchaseOrders);
		assertEquals("Test that arraylist is 1", 1, purchaseListTest.size());
		assertSame("Check that purchaseOrder is added", purchaseOrders, purchaseListTest.get(0));
		
	}
	
	@Test
	public void deletePurchaseTest() { // Jun Kai
		
		assertNotNull("Test if there is valid arraylist to delete from", purchaseListTest);
		
		purchaseListTest.add(purchaseOrders);
		
		C206_CaseStudy.ingredientname = "";
		C206_CaseStudy.deletePurchaseOrder(purchaseListTest, purchaseOrders);
		assertEquals("Test that purchaseListTest arraylist is 0", 0, purchaseListTest.size());
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
	
	@Test
	public void updatePurchaseOrderTest() { // Jun Kai
		
		assertNotNull("Test if there is valid arrylist to update from", purchaseListTest);
		
		C206_CaseStudy.addPurchaseOrder(purchaseListTest, purchaseOrders);
		
		boolean pass = C206_CaseStudy.doUpdatePurchaseOrder(purchaseListTest, "", 0);
		assertTrue("Test if the existing menu item is updated", pass);
	}
	
	@Test
	public void viewPurchaseOrderByItemTest() { // Jun Kai
		
		assertNotNull("Test if there is valid arraylist to retrieve item from", purchaseListTest);
		
		C206_CaseStudy.addPurchaseOrder(purchaseListTest, purchaseOrders);
		assertEquals("Test that menuListTest arraylist is 1", 1, purchaseListTest.size());
		
		Boolean pass = C206_CaseStudy.showPurchaseOrderByItem(purchaseListTest, "");
		assertTrue("Test if the purchase order is correctly display according to the Item", pass);
		
		pass = C206_CaseStudy.showPurchaseOrderByItem(purchaseListTest, "");
		assertFalse("Test if purchase order is display correctly by the Item", pass);
	}
	@Test
	public void addaccount() { //YY
		assertNotNull("If user creates an account, and his fill in details are wrong, it should return an error ",
				account);

		account.add(account1);

		C206_CaseStudy.addAccount(account);
		assertEquals("Test that account added is 1", 1, account.size());
	}
	
	public void deleteaccount() { //yy

		assertNotNull("Test if thr list is not empty so that Account can be deleted", account);
		C206_CaseStudy.addAccount(account);
		String test = C206_CaseStudy.dodeleteMember(account, "123");
		assertTrue("Test if Account in the list can be deleted" + test, true);
	}
	
	@Test
	public void viewaccount() { //yy
		account.add(account1);
		account.add(account2);
		C206_CaseStudy.viewAccount(account);
		assertNotNull("If the user clicks on his profile or settings, he can view his account and make changes. ",
				account.size());

	}
	
	@Test
	public void updateaccount() { //yy

		String test1 = C206_CaseStudy.updateAccount(account);
		assertTrue("If the user clicks on update, he can make updates to his accounts "+test1,true );
	}
	
	@Test
	public void checkusernameaccount() { //yy

		String test1 = C206_CaseStudy.checkusernameAccount(account);
		assertEquals("If the user fills in his username, the username will be acceptable if not in use ", test1);
	}
	
	@Test
	public void loginaccount() { //yy
		account.add(account1);
		account.add(account2);
		String test1 = C206_CaseStudy.loginAccount(account, "yueying", "shabi");
		assertNotNull("If user fill in login details, he will be able to login to his account ", test1);
	}
	@After
	public void tearDown() throws Exception {
	}
	
}

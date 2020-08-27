import java.util.ArrayList;

public class C206_CaseStudy {

	private static final int CUSTOMER = 1;
	private static final int STALL_STAFF = 2;
	private static final int CANTEEN_ADMIN = 3;

	private static final int OPTION_MENUITEM = 1;
	private static final int OPTION_ACCOUNT = 2;
	private static final int OPTION_ORDER = 3;
	private static final int OPTION_PURCHASEORDER = 4;
	private static final int OPTION_PROMOTION = 5;
	private static final int OPTION_USERTYPE = 6;
	private static final int OPTION_EXIT = 7;

	public static int userOption = 0;

	public static ArrayList<MenuItem> menuItem;
	public static ArrayList<Promotion> promoList;



	public static ArrayList<Order> orderList;
	public static ArrayList<MenuItem> orderInput;
	public static ArrayList<PurchaseOrder> purchaseList;
	private static ArrayList<Account> accList;
	public static Order orderItem;
	public static MenuItem menuItems;
	public static Promotion promoItem;
	

	public static PurchaseOrder purchaseOrders;


	public static String userName;
	public static String status;
	public static boolean takeAway;

	public static String name;
	public static String category;
	public static double price;

	public static String ingredientname;
	public static int date;

	public static void main(String[] args) {

		menuItem = new ArrayList<MenuItem>();
		orderList = new ArrayList<Order>();
		orderInput = new ArrayList<MenuItem>();
		promoList = new ArrayList<Promotion>();
		
		menuItem.add(new MenuItem("Cheese Burger", "Fast Food", 3.99));
		menuItem.add(new MenuItem("Crab", "Sea Food", 5.99));
		

		purchaseList = new ArrayList<PurchaseOrder>();
		accList = new ArrayList<Account>();

		accList.add(new Account("customer", "123123123", "12390234", "yueying", "woshishabi"));
		accList.add(new Account("puppy", "32132132", "32112323", "yueying", "woshiwangwang"));
		menuItem.add(new MenuItem("Chicken Burger", "Fast Food", 2.50));
		menuItem.add(new MenuItem("Fish Burger", "Fast Food", 3.50));
		menuItem.add(new MenuItem("Cheese Burger", "Fast Food", 4.50));
		menuItem.add(new MenuItem("Shrimp", "Seafood", 5.50));
		menuItem.add(new MenuItem("Crab", "Seafood", 6.50));
		menuItem.add(new MenuItem("Salmon", "Seafood", 7.50));

		int option = 0;

		while (userOption != CUSTOMER && userOption != STALL_STAFF && userOption != CANTEEN_ADMIN) {
			userTypeMenu();
			userOption = Helper.readInt("Enter User type > ");
			if (userOption != CUSTOMER && userOption != STALL_STAFF && userOption != CANTEEN_ADMIN) {
				System.out.println("Please enter valid user type!");
			}
		}

		while (option != 7) {

			optionMenu();
			option = Helper.readInt("Enter an option > ");

			if (option == OPTION_MENUITEM) { // Keagan
				// Do code for Menu Item here
				C206_CaseStudy.setHeader("OPTIONS");
				System.out.println(
						String.format("%-10s\n%-10s\n%-10s\n%-10s\n%-10s", "1. View All Menu Items", "2. Add Menu Item",
								"3. Delete Menu Item", "4. Update Menu Item", "5. View Menu Item By Price Range"));
				int menuOption = Helper.readInt("Option > ");
				int viewMenu = 1;
				int addMenu = 2;
				int delMenu = 3;
				int updateMenu = 4;
				int viewMenuByPriceRange = 5;
				if (menuOption == viewMenu) {
					viewAllMenuItems(menuItem);

				} else if (menuOption == addMenu) {
					MenuItem mi = addMenu();
					C206_CaseStudy.addMenuItem(menuItem, mi);

				} else if (menuOption == delMenu) {
					name = Helper.readString("Enter menu item name to delete from list > ");
					deleteMenuItem(menuItem);

				} else if (menuOption == updateMenu) {
					updateMenuItem(menuItem);

				} else if (menuOption == viewMenuByPriceRange) {
					viewMenuItemByPriceRange(menuItem);

				} else {
					System.out.println("Invalid choice");

				}
				
						
			} else if (option == OPTION_ACCOUNT) {
				// Do code for Account here
				System.out.println(String.format("%-10s\n%-10s\n%-10s\n%-10s\n%-10s\n", "1. Add User Account", "2. View User Account", "3. Delete User Account", "4. Update User Account", "5. Login"));
				int acctOption = Helper.readInt("Option > ");
				int addOpt = 1;
				int viewOpt =2;
				int delOpt = 3;
				int updateOpt = 4;
				int loginOpt =5;
				if (acctOption == addOpt) {
					addAccount(accList);
					
				} else if (acctOption == viewOpt) {
					viewAccount(accList);
					
				} else if (acctOption == delOpt) {
					deleteAccount();
					
				} else if (acctOption == updateOpt) {
					updateAccount(accList);
					
				} else if (acctOption == loginOpt) {
					loginAccount(accList, "", "");
					
				} else {
					System.out.println("Invalid Option!");
				}

			} else if (option == OPTION_ORDER) { // Lawrence
				// Do code for Order here
				System.out.println(String.format("%-10s\n%-10s\n%-10s\n%-10s\n%-20s", "1. Add Order", "2. Delete Order",
						"3. View All Orders", "4. Update Order Status", "any other no. to cancel"));
				int orderOption = Helper.readInt("Option > ");
				int addOd = 1;
				int remOd = 2;
				int viewOd = 3;
				int chngeStatus = 4;
				if (orderOption == addOd) {
					userName = Helper.readString("Username > ");
					status = "recieved";
					takeAway = Helper.readBoolean("Takeaway? >(Y/N) ");
					ArrayList<MenuItem> orderInput1 = new ArrayList<MenuItem>();

					String out = String.format("%-5s%-25s%-15s%-10s\n", "no.", "Name", "Category", "Price");
					out += String.format("%-5s%-25s%-15s%-10s\n", "===", "====", "========", "=====");
					if (menuItem != null) {
						for (int i = 0; i < menuItem.size(); i++) {
							out += String.format("%-5d%-50s\n", i + 1, menuItem.get(i).toString());
						}
					} else {
						out = "No Items Available!";
					}
					System.out.println(out);
					int chce = 0;
					double prce = 0.00;
					while (chce != 999) {
						System.out.println(String.format("Total Price: $%.2f", prce));
						chce = Helper.readInt("Enter Order Choice >(999 to submit) ");
						if (chce <= menuItem.size() && menuItem.get(chce - 1) != null && orderInput != null) {
							orderInput1.add(menuItem.get(chce - 1));
							prce += menuItem.get(chce - 1).getPrice();
						}
					}
					addOrder(orderList, new Order(userName, status, takeAway, orderInput1));

				} else if (orderOption == remOd) {
					viewAllOrder(orderList);
					int remOrder = Helper.readInt("Enter order No. to delete orders from > ");
					deleteOrder(orderList, remOrder);
				} else if (orderOption == viewOd) {
					viewAllOrder(orderList);
				} else if (orderOption == chngeStatus) {
					viewAllOrder(orderList);
					int chngeInput1 = Helper.readInt("Enter Order no. to change > ");
					String chngeInput2 = Helper.readString("Enter new Order status > ");
					boolean chngeInput3 = Helper.readBoolean("Enter Takeaway status (y/n)> ");
					changeOrderStatus(orderList, chngeInput1, chngeInput2, chngeInput3);
				} else {
					System.out.println("Invalid Choice!");
				}
				
				
				
			} else if(option == OPTION_PROMOTION) {
				//Do code for Promotion here
				int optionPromotion = Helper.readInt("Option > ");
				int updPromo = 1;
				int addPromoAndCheck = 2;
				int bonus = 3;
				
				if(optionPromotion == updPromo) {
				for(int i = 0; i < promoList.size();i++) {
					System.out.println(promoList.get(i).getPromotionCode());
				}
					String promoCode = Helper.readString("Enter Promotion code you would like to update> ");
					for(int i = 0; i < promoList.size();i++) {
						if(promoCode == promoList.get(i).getPromotionCode()) {
							String newEndDate = Helper.readString("Enter updated end date> ");
							double newDiscount = Helper.readDouble("Enter updated discount amount> ");
							
							promoList.get(i).setEndDate(newEndDate);
							promoList.get(i).setDiscountAmount(newDiscount);
							
						}
					}
					
					
				}
				if(optionPromotion == addPromoAndCheck) {
					String promoCode = Helper.readString("Enter promotion Code> ");
					String endDate = Helper.readString("Enter end date> ");
					double discAmt = Helper.readDouble("Enter discount amount> ");
					
					for(int i = 0; i < promoList.size(); i++) {
						if(promoList.get(i).getPromotionCode() != promoCode) {
							if(promoList.get(i).getEndDate() != endDate) {
								promoItem = new Promotion(promoCode, endDate, discAmt);
								promoList.add(promoItem);
							}else { 
								System.out.println("End Date needs to be unique");
								
							}
						}else {
							System.out.println("Promotion Code needs to be unique");
						}
					}
					
				}
				

			} else if (option == OPTION_PURCHASEORDER) { // Jun Kai
				// Do code for Purchase Order here
				System.out.println(String.format("%-10s\n%-10s\n%-10s\n%-10s\n%-10s", "1. Add Purchase List",
						"2. Delete Purchase List", "3. View Purchase List", "4. Update Purchase List",
						"5. Search Purchase List by Items"));
				int purchaseOption = Helper.readInt("Option > ");
				int addPo = 1;
				int remPo = 2;
				int viewPo = 3;
				int updatePo = 4;
				int viewPoByItems = 5;
				if (purchaseOption == viewPo) {
					viewAllPurchaseOrders(purchaseList);

				} else if (purchaseOption == addPo) {
					PurchaseOrder pl = addPurchase();
					C206_CaseStudy.addPurchaseOrder(purchaseList, pl);

				} else if (purchaseOption == remPo) {
					ingredientname = Helper.readString("Enter item from purchase Orders to remove it: ");
					deletePurchaseOrder(purchaseList, purchaseOrders);

				} else if (purchaseOption == updatePo) {
					updatePurchaseOrder(purchaseList);

				} else if (purchaseOption == viewPoByItems) {
					viewPurchaseOrderByItem(purchaseList);

				}


			} else if (option == OPTION_USERTYPE) { // Lawrence
				while (userOption != CUSTOMER && userOption != STALL_STAFF && userOption != CANTEEN_ADMIN) {

					userTypeMenu();
					userOption = Helper.readInt("Enter User type > ");
					if (userOption != CUSTOMER && userOption != STALL_STAFF && userOption != CANTEEN_ADMIN) {
						System.out.println("Please enter valid user type!");
					}
				}
			} else if (option == OPTION_EXIT) {
				System.out.println("Goodbye!");
			} else {
				System.out.println("Invalid choice!");
			}

		}
	}

	public static void userTypeMenu() {
		String output = String.format("%-5s%-20s", "No.", "User Type");
		output += String.format("\n%-5s%-20s", "===", "=========");
		output += String.format("\n%-5d%-20s", CUSTOMER, "Customer");
		output += String.format("\n%-5d%-20s", STALL_STAFF, "Stall staff");
		output += String.format("\n%-5d%-20s", CANTEEN_ADMIN, "Canteen Admin");
		System.out.println(output);
	}

	public static void optionMenu() {
		String output = String.format("%-5s%-20s", "No.", "Menu Choice");
		output += String.format("\n%-5s%-20s", "===", "=========");
		output += String.format("\n%-5d%-20s", 1, "Menu Item Options");
		output += String.format("\n%-5d%-20s", 2, "Account Options");
		output += String.format("\n%-5d%-20s", 3, "Order Options");
		output += String.format("\n%-5d%-20s", 4, "Purchase Order Options");
		output += String.format("\n%-5d%-20s", 5, "Promotion Options");
		output += String.format("\n%-5d%-20s", 6, "Change User Type");
		output += String.format("\n%-5d%-20s", 7, "Quit");
		System.out.println(output);
	}

	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

	// Create all the methods here \/ \/ \/

	public static void addOrder(ArrayList<Order> order, Order orderIt) { // Lawrence
		order.add(orderIt);
	}

	public static void deleteOrder(ArrayList<Order> order, int a) { // Lawrence
		order.remove(a - 1);
	}

	public static void viewAllOrder(ArrayList<Order> order) { // Lawrence
		String output = "";
		output += String.format("%-5s%-20s%-15s%-10s%-25s%-15s%-10s\n", "no.", "Username", "Status", "Takeaway",
				"Category", "Items", "Price");
		output += String.format("%-5s%-20s%-15s%-10s%-25s%-15s%-10s\n", "===", "========", "======", "========",
				"========", "=====", "=====");
		System.out.println(output);
		for (int i = 0; i < order.size(); i++) {
			if (order.get(i) != null) {
				System.out.println(String.format("%-5d\n%-105s", i + 1, order.get(i).toString()));
			}
		}
	}

	public static void changeOrderStatus(ArrayList<Order> orderList, int orderNo, String status, boolean takeaway) { // Lawrence
		if (orderList.get(orderNo - 1) != null) {
			orderList.get(orderNo - 1).setStatus(status);
			orderList.get(orderNo - 1).setTakeaway(takeaway);
			System.out.println("Update Succesfull!");
		} else {
			System.out.println("Invalid Order No.!");
		}
	}

	public static String retrieveMenuItems(ArrayList<MenuItem> menuItem) { // Keagan
		String output = "";
		for (int i = 0; i < menuItem.size(); i++) {
			output += String.format("%-25s %-15s %-10.2f\n", menuItem.get(i).getName(), menuItem.get(i).getCategory(),
					menuItem.get(i).getPrice());
		}
		return output;
	}

	public static void viewAllMenuItems(ArrayList<MenuItem> menuItem) { // Keagan
		C206_CaseStudy.setHeader("MENU ITEM LIST");
		String output = String.format("%-25s %-15s %-10s\n", "NAME", "CATEGORY", "PRICE");
		output += retrieveMenuItems(menuItem);
		System.out.println(output);
	}

	public static MenuItem addMenu() { // Keagan
		name = Helper.readString("Enter menu name: ");
		category = Helper.readString("Enter category: ");
		price = Helper.readDouble("Enter price: ");

		MenuItem mi = new MenuItem(name, category, price);
		return mi;
	}

	public static void addMenuItem(ArrayList<MenuItem> menuItem, MenuItem mi) { // Keagan
		menuItem.add(mi);
		System.out.println("Menu Item added!");
	}

	public static void deleteMenuItem(ArrayList<MenuItem> menuItem) { // Keagan
		for (int i = 0; i < menuItem.size(); i++) {
			if (menuItem.get(i).getName().equalsIgnoreCase(name) && menuItem.get(i) != null) {
				menuItem.remove(i);
				System.out.println("Menu Item removed!");
			}
		}
	}

	public static boolean doUpdateMenuItem(ArrayList<MenuItem> menuItem, String menuName, double menuPrice) { // Keagan
		boolean ok = false;

		for (int i = 0; i < menuItem.size(); i++) {
			name = menuItem.get(i).getName();

			if (menuName.equalsIgnoreCase(name)) {
				menuItem.get(i).setName(menuName);
				menuItem.get(i).setPrice(menuPrice);

				ok = true;
			}
		}
		return ok;
	}


	public static void updateMenuItem(ArrayList<MenuItem> menuItem) { // Keagan
		name = Helper.readString("Enter menu name > ");
		category = Helper.readString("Enter category > ");
		for (int i = 0; i < menuItem.size(); i++) {
			if (name.equalsIgnoreCase(menuItem.get(i).getName())
					&& category.equalsIgnoreCase(menuItem.get(i).getCategory()) && menuItem != null) {
				String newName = Helper.readString("Enter new menu name > ");
				double newPrice = Helper.readDouble("Enter new price > ");
				menuItem.get(i).setName(newName);
				menuItem.get(i).setPrice(newPrice);
				System.out.println("Menu Item updated!");
			}
		}
	}

	public static boolean showMenuItemByPriceRange(ArrayList<MenuItem> menuItem, double minPrice, double maxPrice) { // Keagan
		boolean viewPR = false;

		String output = String.format("%-25s %-15s %-10s\n", "NAME", "CATEGORY", "PRICE");
		name = "";
		category = "";

		for (int i = 0; i < menuItem.size(); i++) {
			name = menuItem.get(i).getName();
			category = menuItem.get(i).getCategory();
			price = menuItem.get(i).getPrice();

			if (minPrice < price && maxPrice > price) {
				output += String.format("%-25s %-15s %-10.2f\n", name, category, price);

				viewPR = true;
			}
		}
		System.out.println(output);
		return viewPR;
	}

	public static void viewMenuItemByPriceRange(ArrayList<MenuItem> menuItem) { // Keagan
		C206_CaseStudy.viewAllMenuItems(menuItem);
		C206_CaseStudy.setHeader("MENU ITEM LIST BY PRICE RANGE");

		if (!menuItem.isEmpty()) {
			double minPrice = Helper.readDouble("Enter minimum price > ");
			double maxPrice = Helper.readDouble("Enter maximum price > ");

			boolean viewPR = showMenuItemByPriceRange(menuItem, minPrice, maxPrice);
			if (viewPR == false) {
				System.out.println("No menu items falls under this range!");

			} else {
				System.out.println("List of menu items falls under this range");
			}
		}
	}

	public static PurchaseOrder addPurchase() { // Jun Kai
		ingredientname = Helper.readString("Enter ingredient to purchase: ");
		date = Helper.readInt("Date of purchase order: ");

		PurchaseOrder pl = new PurchaseOrder(ingredientname, date);
		return pl;

	}

	public static void addPurchaseOrder(ArrayList<PurchaseOrder> purchase, PurchaseOrder pl) { // Jun Kai
		purchase.add(pl);
		System.out.println("Purchase and date added!");

	}

	public static PurchaseOrder deletePurchaseOrder() { // Jun Kai
		date = Helper.readInt("Enter date to remove: ");

		PurchaseOrder pl = new PurchaseOrder(ingredientname, date);
		return pl;
	}

	public static void deletePurchaseOrder(ArrayList<PurchaseOrder> purchase, PurchaseOrder pl) { // Jun Kai
		for (int i = 0; i < purchase.size(); i++) {
			if (purchase.get(i).getIngredientname().equalsIgnoreCase(ingredientname) && purchase.get(i) != null) {
				purchase.remove(i);
				System.out.println("Ingredient from Purchase order removed!");
			}
		}
	}

	public static String retrievePurchaseOrders(ArrayList<PurchaseOrder> purchase) { // Jun Kai
		String output = "";
		for (int i = 0; i < purchase.size(); i++) {
			output += String.format("%-5d %-10s\n", i + 1, purchase.get(i).getIngredientname());
		}
		return output;
	}

	public static void viewAllPurchaseOrders(ArrayList<PurchaseOrder> purchase) { // Jun Kai
		C206_CaseStudy.setHeader("PURCHASE ORDER LIST");
		String output = String.format("%-5s %-10s\n", "No.", "Ingredient Name");
		output += retrievePurchaseOrders(purchase);
		System.out.println(output);
	}

	public static String getPurchaseList(ArrayList<PurchaseOrder> purchase) { // Jun Kai
		ingredientname = "";
		String output = "";
		for (int i = 0; i < purchaseList.size(); i++) {
			if (ingredientname.equalsIgnoreCase(purchaseList.get(i).getIngredientname()) && purchaseList != null) {
				output += String.format("%-25s %-15s %-10.2f\n", purchaseList.get(i).getIngredientname());
			}
		}
		return output;
	}

	public static boolean doUpdatePurchaseOrder(ArrayList<PurchaseOrder> purchase, String ingName, int podate) { // Jun Kai
		boolean ok = false;

		for (int i = 0; i < purchase.size(); i++) {
			name = purchaseList.get(i).getIngredientname();

			if (ingName.equalsIgnoreCase(ingredientname)) {
				purchaseList.get(i).setIngredientname(ingName);

				ok = true;
			}
		}
		return ok;
	}

	public static void updatePurchaseOrder(ArrayList<PurchaseOrder> purchase) { // Jun Kai
		char udItem = 'u';
		
		ingredientname = Helper.readString("Enter items to update > ");
		udItem = Helper.readChar("Do you want to change/remove item? ");
		if (udItem == 'u') {
			for (int i = 0; i < purchaseList.size(); i++) {
				if (ingredientname.equalsIgnoreCase(purchaseList.get(i).getIngredientname()) && purchaseList != null) {
					String newitem = Helper.readString("Enter new item to purchase order > ");
					purchaseList.get(i).setIngredientname(newitem);
					System.out.println("Purchase order updated!");
				}
			}
		} else {
			for (int i = 0; i < purchase.size(); i++) {
				if (purchase.get(i).getIngredientname().equalsIgnoreCase(ingredientname) && purchase.get(i) != null) {
					purchase.remove(i);
					System.out.println("Ingredient from Purchase order removed!");
				}
			}
		}
		date = Helper.readInt("Enter date of update: ");
		System.out.println("The date has been updated.");
	}

	public static boolean showPurchaseOrderByItem(ArrayList<PurchaseOrder> purchase, String searchitem) { // Jun Kai
		boolean findItem = false;

		String output = String.format("%-25s\n", "Ingredient Name");
		ingredientname = "";

		for (int i = 0; i < purchaseList.size(); i++) {
			ingredientname = purchaseList.get(i).getIngredientname();

			if (searchitem.equalsIgnoreCase(ingredientname)) {
				output += String.format("%-25s\n", ingredientname);

				findItem = true;
			}
		}
		System.out.println(output);
		return findItem;
	}

	public static void viewPurchaseOrderByItem(ArrayList<PurchaseOrder> purchase) { // Jun Kai
		ingredientname = Helper.readString("Enter item/ingredient to find purchase Orders: ");
		String output = String.format("%-10s\n", "Ingrdient Name");
		C206_CaseStudy.setHeader("PURCHASE LIST WITH THE ITEM SELECTED");

		for (int i = 0; i < purchase.size(); i++) {
			if (ingredientname.equalsIgnoreCase(purchase.get(i).getIngredientname())) {
				output += purchase.get(i).getIngredientname();
			}
		}
		System.out.println(output);
	}

	public static void addAccount(ArrayList<Account> account) { //yy
		String userRole = Helper.readString("Enter userrole: ");
		String contactNumber = Helper.readString("Enter contact number: ");
		String studentID = Helper.readString("Enter studentid: ");
		String username = Helper.readString("Enter username:");
		String password = Helper.readString("Enter password:");
		C206_CaseStudy.checkusernameAccount(account);
		C206_CaseStudy.loginAccount(account, username, password);
		Account Account = new Account(userRole, contactNumber, studentID, username, password);
		account.add(Account);
		System.out.println("Account added!");
	}

	public static void viewAccount(ArrayList<Account> account) { //yy
		Helper.line(111, "-");
		System.out.println("Account Menu");
		String output = String.format("%-15s %-15s %-15s %-15s %-15s %-15s %-15s\n", "UserRole", "Contact Number",
				"Student ID", "Username");
		Helper.line(111, "-");
		System.out.println(output);
		for (int i = 0; i < account.size(); i++) {
			output += String.format("%-15s %-15s %-15s %-15s\n", account.get(i).getuserRole(),
			output += String.format("%-15s %-15s %-15s %-15s %-15s %-15s %-15s\n", account.get(i).getuserRole(),
					account.get(i).getcontactNumber(), account.get(i).getstudentID(), account.get(i).getusername()));
			output += String.format("%" + 111 + "s", " ").replaceAll(" ", "-");
		}
		System.out.println(output);
	}

	public static void deleteAccount() { //yy
		C206_CaseStudy.setHeader("DELETE account");
		String account = Helper.readString("Enter the account to delete> ");
		int i = 0;
		
		boolean valid = false;
		for (i = 0; i < accList.size(); i++) {
			if (accList.get(i).getstudentID().contentEquals(account)) {
				valid = true;
				break;
			}
		}
		if (valid) {
			System.out.println(dodeleteMember(accList, "yueying"));

		} else {
			System.out.println("Invalid email");
			System.out.println();

		}
	}

	public static String dodeleteMember(ArrayList<Account> accList, String acc1) { //yy

		String output = "";
		boolean isValid = false;

		if (accList.isEmpty()) {
			output += "Empty Account List";
			return output;
		}

		for (Account a : accList) {
			if (a.getusername().contentEquals(acc1)) {
				isValid = true;
			}
		}

		if (!isValid) {
			output += "Account deleted";
			accList.remove(acc1);
		} else {
			output += "Account " + acc1 + " cannot be deleted";
		}
		return output;
	}

	public static String updateAccount(ArrayList<Account> account) { //yy
		String updaccount = Helper.readString("Enter which account to update: ");
		String output = "";
		for (int i = 0; i < account.size(); i++) {
			if (account.get(i).getusername().equals(updaccount)) {
				String username = Helper.readString("Enter newusername > ");
				String password = Helper.readString("Enter newpassword > ");
				account.get(i).setusername(username);
				account.get(i).setpassword(password);
				output += "Your account has been updated";
			}
		}
		return output;
	}

	public static String checkusernameAccount(ArrayList<Account> account) { //yy
		String username = Helper.readString("Enter unsername of your account: ");
		String output = "";
		for (int i = 0; i < account.size(); i++) {
			if (account.get(i).getusername().equals(username)) {
				output += "This username is already taken, please use a different one";
			}
		}
		return output;
	}

	public static String loginAccount(ArrayList<Account> account, String username, String password) { //yy
		String output = "";
		for (int i = 0; i < account.size(); i++) {
			if (account.get(i).getusername().equals(username) && account.get(i).getpassword().equals(password)) {
				output += "You have successfully logged in to your account";
			}
		}
		return output;
	}
}

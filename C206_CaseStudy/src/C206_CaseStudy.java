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
	
	public static ArrayList<Order> orderList;
	public static ArrayList<MenuItem> orderInput;
	public static ArrayList<PurchaseOrder> purchaseList;
	public static Order orderItem;
	public static MenuItem menuItems;
	public static PurchaseOrder purchaseOrders;
	
	public static String userName;
	public static String status;
	public static boolean takeAway;
	
	public static String name;
	public static String category;
	public static double price;
	
	public static String ingredientname;
	
	
	public static void main(String[] args) {
		
		menuItem = new ArrayList<MenuItem>();
		orderList = new ArrayList<Order>();
		orderInput = new ArrayList<MenuItem>();
		purchaseList = new ArrayList<PurchaseOrder>();
		
		
		menuItem.add(new MenuItem("Cheese Burger", "Fast Food", 3.99));
		menuItem.add(new MenuItem("Crab", "Sea Food", 5.99));
		
		int option = 0;
		
		while(userOption != CUSTOMER && userOption != STALL_STAFF && userOption != CANTEEN_ADMIN) {
			userTypeMenu();
			userOption = Helper.readInt("Enter User type > ");
			if(userOption != CUSTOMER && userOption != STALL_STAFF && userOption != CANTEEN_ADMIN) {
				System.out.println("Please enter valid user type!");
			}
		}
		
		while (option != 7) {
			
			optionMenu();
			option = Helper.readInt("Enter an option > ");
			
			if(option == OPTION_MENUITEM) { // Keagan
				//Do code for Menu Item here
				C206_CaseStudy.setHeader("ADD");
				System.out.println(String.format("%-10s\n%-10s\n%-10s", "1. View All Menu Items", "2. Add Menu Item", "3. Delete Menu Item"));
				int menuOption = Helper.readInt("Option > ");
				int viewMenu = 1;
				int addMenu = 2;
				int delMenu = 3;
				if (menuOption == viewMenu) {
					viewAllMenuItems(menuItem);
					
				} else if (menuOption == addMenu) {
					MenuItem mi = addMenu();
					C206_CaseStudy.addMenuItem(menuItem, mi);
					
				} else if (menuOption == delMenu) {
					name = Helper.readString("Enter menu item name to delete from list > ");
					deleteMenuItem(menuItem);
					
				} else {
					System.out.println("Invalid choice");
					
				}
				
				
			} else if(option == OPTION_ACCOUNT) {
				//Do code for Account here
				
			} else if(option == OPTION_ORDER) { // Lawrence
				//Do code for Order here
				System.out.println(String.format("%-10s\n%-10s\n%-10s\n%-10s\n%-20s", "1. Add Order", "2. Delete Order", "3. View All Orders", "4. Update Order Status", "any other no. to cancel"));
				int orderOption = Helper.readInt("Option > ");
				int addOd = 1;
				int remOd = 2;
				int viewOd = 3;
				int chngeStatus = 4;
				if(orderOption == addOd) {
					userName = Helper.readString("Username > ");
					status = "recieved";
					takeAway = Helper.readBoolean("Takeaway? >(Y/N) ");
					ArrayList<MenuItem> orderInput1 = new ArrayList<MenuItem>();
					
					String out = String.format("%-5s%-25s%-15s%-10s\n", "no.", "Name", "Category", "Price");
					out += String.format("%-5s%-25s%-15s%-10s\n", "===", "====", "========", "=====");
					if(menuItem != null) {
						for(int i = 0; i < menuItem.size(); i++) {
							out += String.format("%-5d%-50s\n",i + 1 , menuItem.get(i).toString());
						}
					} else {
						out = "No Items Available!";
					}
					System.out.println(out);
					int chce = 0;
					double prce = 0.00;
					while(chce != 999) {
						System.out.println(String.format("Total Price: $%.2f", prce));
						chce = Helper.readInt("Enter Order Choice >(999 to submit) ");
						if(chce <= menuItem.size() && menuItem.get(chce-1) != null && orderInput != null) {
							orderInput1.add(menuItem.get(chce-1));
							prce += menuItem.get(chce-1).getPrice();
						}
					}
					addOrder(orderList, new Order(userName, status, takeAway, orderInput1));

				} else if(orderOption == remOd) {
					viewAllOrder(orderList);
					int remOrder = Helper.readInt("Enter order No. to delete orders from > ");
					deleteOrder(orderList, remOrder);
				} else if(orderOption == viewOd) {
					viewAllOrder(orderList);
				} else if(orderOption == chngeStatus) {
					viewAllOrder(orderList);
					int chngeInput1 = Helper.readInt("Enter Order no. to change > ");
					String chngeInput2 = Helper.readString("Enter new Order status > ");
					boolean chngeInput3 = Helper.readBoolean("Enter Takeaway status (y/n)> ");
					changeOrderStatus(orderList, chngeInput1, chngeInput2, chngeInput3);
				}else {
					System.out.println("Invalid Choice!");
				}
				
				
			} else if(option == OPTION_PURCHASEORDER) {
				//Do code for Purchase Order here
				System.out.println(String.format("%-10s\n%-10s\n%-10s\n", "1. Add Purchase List", "2. Delete Purchase List", "3. View Purchase List"));
				int purchaseOption = Helper.readInt("Option > ");
				int addPo = 1;
				int remPo = 2;
				int viewPo = 3;
				if (purchaseOption == viewPo) {
					viewAllPurchaseOrders(purchaseList);

				} else if (purchaseOption == addPo) {
					PurchaseOrder pl = addPurchase();
					C206_CaseStudy.addPurchaseOrder(purchaseList, pl);
					
				}	else if(purchaseOption == remPo) {
					PurchaseOrder pl = deletePurchase();
					C206_CaseStudy.deletePurchaseOrder(purchaseList, pl);
				}
			} else if(option == OPTION_PROMOTION) {
				//Do code for Promotion here
				
			} else if(option == OPTION_USERTYPE) { // Lawrence
				while(userOption != CUSTOMER && userOption != STALL_STAFF && userOption != CANTEEN_ADMIN) {
					userTypeMenu();
					userOption = Helper.readInt("Enter User type > ");
					if(userOption != CUSTOMER && userOption != STALL_STAFF && userOption != CANTEEN_ADMIN) {
						System.out.println("Please enter valid user type!");
					}
				}
			} else if(option == OPTION_EXIT) {
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
	
	//Create all the methods here \/ \/ \/
	
	public static void addOrder(ArrayList<Order> order, Order orderIt) { // Lawrence 
		order.add(orderIt);
	}
	
	public static void deleteOrder(ArrayList<Order> order, int a) { // Lawrence
		order.remove(a - 1);
	}
	
	public static void viewAllOrder(ArrayList<Order> order) { // Lawrence
		String output = "";
		output += String.format("%-5s%-20s%-15s%-10s%-25s%-15s%-10s\n", "no.", "Username", "Status", "Takeaway", "Category", "Items", "Price");
		output += String.format("%-5s%-20s%-15s%-10s%-25s%-15s%-10s\n", "===", "========", "======", "========", "========", "=====", "=====");
		System.out.println(output);
		for(int i = 0; i < order.size(); i++) {
			if(order.get(i) != null) {
				System.out.println(String.format("%-5d\n%-105s", i+1, order.get(i).toString()));
			}
		}
	}
	
	public static void changeOrderStatus(ArrayList<Order> orderList, int orderNo, String status, boolean takeaway) {
		if(orderList.get(orderNo - 1) != null) {
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
			output = String.format("%-10s %-30s %-10.2f\n", menuItem.get(i).getName(), menuItem.get(i).getCategory(), 
					menuItem.get(i).getPrice()); 
		}
		return output;
	}
	
	public static void viewAllMenuItems(ArrayList<MenuItem> menu) { // Keagan
		for (int i = 0; i < menuItem.size(); i++) {
			C206_CaseStudy.setHeader("MENU ITEM LIST");
			String output = String.format("%-10s %-30s %-10s\n", "NAME", "CATEGORY", "PRICE");
			output += retrieveMenuItems(menuItem);
			System.out.println(output);
		}
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
	
	public static PurchaseOrder addPurchase() { // Jun Kai
		ingredientname = Helper.readString("Enter ingredient to purchase: ");
		
        PurchaseOrder pl= new PurchaseOrder(ingredientname);
		return pl;
	}
	
	public static void addPurchaseOrder(ArrayList<PurchaseOrder> purchase, PurchaseOrder pl) { // Jun Kai
		purchaseList.add(pl);
		System.out.println("Purchase added!");
	}
	
	public static PurchaseOrder deletePurchase() { // Jun Kai
		ingredientname = Helper.readString("Enter ingredient to remove: ");
		
        PurchaseOrder pl= new PurchaseOrder(ingredientname);
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
			output = String.format("%-10s", purchase.get(i).getIngredientname()); 
		}
		return output;
	}
	
	public static void viewAllPurchaseOrders(ArrayList<PurchaseOrder> purchase) { // Jun Kai
		for (int i = 0; i < purchaseList.size(); i++) {
			C206_CaseStudy.setHeader("Purchase Order LIST");
			String output = String.format("%-10s", "Ingredients");
			output += retrievePurchaseOrders(purchaseList);
			System.out.println(output);
		}
	}

}

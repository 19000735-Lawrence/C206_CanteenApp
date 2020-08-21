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
	public static Order orderItem;
	public static MenuItem menuItems;
	
	public static String userName;
	public static String status;
	public static boolean takeAway;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		menuItem = new ArrayList<MenuItem>();
		orderList = new ArrayList<Order>();
		orderInput = new ArrayList<MenuItem>();
		
		
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
			
			if(option == OPTION_MENUITEM) {
				//Do code for Menu Item here
				C206_CaseStudy.setHeader("ADD");
				MenuItem mi = addMenu();
				C206_CaseStudy.addMenuItem(menuItem, mi);
				
			} else if(option == OPTION_ACCOUNT) {
				//Do code for Account here
				
			} else if(option == OPTION_ORDER) { // Lawrence
				//Do code for Order here
				System.out.println(String.format("%-10s\n%-10s\n%-10s\n%-20s", "1. Add Order", "2. Delete Order", "3. View All Orders", "any other no. to cancel"));
				int orderOption = Helper.readInt("Option > ");
				int addOd = 1;
				int remOd = 2;
				int viewOd = 3;
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
					while(chce != 999) {
						chce = Helper.readInt("Enter Order Choice >(999 to submit) ");
						if(chce <= menuItem.size() && menuItem.get(chce-1) != null && orderInput != null) {
							orderInput1.add(menuItem.get(chce-1));
						}
					}
					addOrder(orderList, new Order(userName, status, takeAway, orderInput1));

				} else if(orderOption == remOd) {
					userName = Helper.readString("Enter username to delete orders from > ");
					deleteOrder(orderList);
				} else if(orderOption == viewOd) {
					viewAllOrder(orderList);
				} else {
					System.out.println("Invalid Choice!");
				}
				
				
			} else if(option == OPTION_PURCHASEORDER) {
				//Do code for Purchase Order here
				
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
	
	public static void deleteOrder(ArrayList<Order> order) { // Lawrence
		for(int i = 0; i < order.size(); i++) {
			if(order.get(i).getUsername().equalsIgnoreCase(userName) && order.get(i) != null) {
				order.remove(i);
				System.out.println("Order removed!");
			}
		}
	}
	
	public static void viewAllOrder(ArrayList<Order> order) { // Lawrence
		String output = "";
		output += String.format("%-20s%-15s%-10s%-25s%-15s%-10s\n", "Username", "Status", "Takeaway", "Items", "Category", "Price");
		output += String.format("%-20s%-15s%-10s%-25s%-15s%-10s\n", "========", "======", "========", "=====", "========", "=====");
		System.out.println(output);
		for(int i = 0; i < order.size(); i++) {
			if(order.get(i) != null) {
				System.out.println(order.get(i).toString());
			}
		}
	}
	
	public static String retrieveMenuItems(ArrayList<MenuItem> menu) { // Keagan
		String output = "";
		for (int i = 0; i < menu.size(); i++) {
			output = String.format("%-10s %-30s $-10.2f\n", menu.get(i).getName(), menu.get(i).getCategory(), 
					menu.get(i).getPrice()); 
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
		String name = Helper.readString("Enter menu name: ");
		String cat = Helper.readString("Enter category: ");
		double price = Helper.readDouble("Enter price: ");
		
		MenuItem mi = new MenuItem(name, cat, price);
		return mi;
	}
	
	public static void addMenuItem(ArrayList<MenuItem> menu, MenuItem mi) { // Keagan
		menuItem.add(mi);
		System.out.println("Menu Item added!");
	}
	
}

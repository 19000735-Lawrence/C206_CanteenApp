import java.util.ArrayList;

public class Order {
	
	private String username;
	private String status;
	private boolean takeaway;
	private ArrayList<MenuItem> items;
	
	public Order(String username, String status, boolean takeaway, ArrayList<MenuItem> items) {
		this.username = username;
		this.status = status;
		this.takeaway = takeaway;
		this.items = items;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isTakeaway() {
		return takeaway;
	}

	public void setTakeaway(boolean takeaway) {
		this.takeaway = takeaway;
	}

	public ArrayList<MenuItem> getItems() {
		return items;
	}

	public void setItems(ArrayList<MenuItem> items) {
		this.items = items;
	}
	
	public String toString() {
		String output = "";
//		output += String.format("%-20s%-15s%-10s%-25s%-15s%-10s\n", "Username", "Status", "Takeaway", "Items", "Category", "Price");
//		output += String.format("%-20s%-15s%-10s%-25s%-15s%-10s\n", "========", "======", "========", "=====", "========", "=====");
		if(items != null) {
			for(int i = 0; i < items.size(); i++) {
				output += String.format("%-20s%-15s%-10s%-25s%-15s$%-10s\n", username, status, Boolean.toString(this.takeaway), items.get(i).getName(), items.get(i).getCategory(), Double.toString(items.get(i).getPrice()));
			}
		} else {
			output = "There are no pending orders.";
		}
		
		return output;
	}
	
}

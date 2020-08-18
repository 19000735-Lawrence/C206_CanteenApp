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
		output += String.format("%s-20%s-15%s-10%-25s%-15s%-10s", "Username", "Status", "Takeaway", "Items", "Category", "Price");
		output += String.format("%s-20%s-15%s-10%-25s%-15s%-10s", "========", "======", "========", "=====", "========", "=====");
		if(items != null) {
			for(int i = 0; i < items.size(); i++) {
				output += String.format("%s-20%s-15%s-10%-25s%-15s$%-10s", this.username, this.status, Boolean.toString(this.takeaway), this.items.get(i).getName(), this.items.get(i).getCategory(), Double.toString(this.items.get(i).getPrice()));
			}
		} else {
			output = "There are no pending orders.";
		}
		
		return output;
	}
	
}

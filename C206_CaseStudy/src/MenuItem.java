
public class MenuItem {
	
	private String category;
	private String name;
	private double price;
	
	public MenuItem(String category, String name, double price) {
		this.category = category;
		this.name = name;
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public String toString() {
		String output = String.format("%-25s%-15s%-10d", this.name, this.category, this.price);
		return output;
	}
	
}


public class MenuItem {
	
	private String category;
	private String name;
	private double price;
	
	public MenuItem(String name, String category, double price) {
		this.name = name;
		this.category = category;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public String toString() {
		String output = String.format("%-25s %-15s %-10.2f\n", this.name, this.category, this.price);
		return output;
	}
	
}

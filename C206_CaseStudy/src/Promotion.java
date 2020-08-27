import java.util.ArrayList;

public class Promotion {

	private String name;
	private String cate;
	private double price;
	
	public Promotion(String name, String cate, double price) {
		this.name = name;
		this.cate = cate;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCate() {
		return cate;
	}

	public void setCate(String cate) {
		this.cate = cate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String toString() {
		String output = String.format("%-25s%-15s%-10.2f", this.name, this.cate, this.price);
		return output;
	}
	
}

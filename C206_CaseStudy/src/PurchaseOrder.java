


public class PurchaseOrder {
	
	private String ingredientname;
	private int date;

	

	public PurchaseOrder(String ingredientname, int date) {
		super();
		this.ingredientname = ingredientname;
		this.date = date;
	}

	public String getIngredientname() {
		return ingredientname;
	}

	public void setIngredientname(String ingredientname) {
		this.ingredientname = ingredientname;
	}
	
	public String toString() {
		String output = "";
		output += String.format("%-20s%",this.ingredientname);
		return output;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}
	
	

}

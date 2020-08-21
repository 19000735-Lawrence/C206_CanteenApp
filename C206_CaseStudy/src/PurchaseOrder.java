


public class PurchaseOrder {
	
	private String ingredientname;

	public PurchaseOrder(String ingredientname) {
		this.ingredientname = ingredientname;
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

}

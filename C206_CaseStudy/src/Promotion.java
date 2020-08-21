import java.util.ArrayList;

public class Promotion {

	private String status;
	private ArrayList<PromotionItem> items;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public ArrayList<PromotionItem> getItems() {
		return items;
	}
	public void setItems(ArrayList<PromotionItem> items) {
		this.items = items;
	}
	@Override
	public String toString() {
		return "Promotion [status=" + status + "]";
	}
	
	
	
}

import java.util.ArrayList;

public class Promotion {

	private String promotionCode;
	private String endDate;
	private double discountAmount;
	
	public Promotion(String promotionCode, String endDate, double discountAmount) {
		this.promotionCode = promotionCode;
		this.endDate = endDate;
		this.discountAmount = discountAmount;
	}

	public String getPromotionCode() {
		return promotionCode;
	}

	public void setPromotionCode(String promotionCode) {
		this.promotionCode = promotionCode;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public double getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(double discountAmount) {
		this.discountAmount = discountAmount;
	}

	@Override
	public String toString() {
		return "Promotion [promotionCode=" + promotionCode + ", endDate=" + endDate + ", discountAmount="
				+ discountAmount + "]";
	}
	
	
	
	
	
}

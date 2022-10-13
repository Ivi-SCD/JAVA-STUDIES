package entities;

public class ImportedProduct extends Product {
	private Double customsFee;

	public Double getCustomsFee() {
		return customsFee;
	}

	public void setCustomsFee(Double customsFee) {
		this.customsFee = customsFee;
	}

	public ImportedProduct() {
		super();
	}

	public ImportedProduct(String name, Double price, Double customsFee) {
		super(name, price);
		this.customsFee = customsFee;
	}
	
	public Double totalPrice() {
		return getPrice() + customsFee;
	}
	
	@Override
	public String priceTag() {
		return getName() + " $" + totalPrice() + " (Customs fee: $" + String.format("%.2f", customsFee) + ")";
	}
	
	@Override
	public String toString() {
		return priceTag();
	}
}
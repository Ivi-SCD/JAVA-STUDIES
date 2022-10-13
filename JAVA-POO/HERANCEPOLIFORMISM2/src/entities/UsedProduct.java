package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UsedProduct extends Product{
	private static SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	
	private Date manufactureDate;

	public UsedProduct() {
		super();
	}

	public UsedProduct(String name, Double price, Date manufactureDate) {
		super(name, price);
		this.manufactureDate = manufactureDate;
	}

	public Date getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}
	
	@Override
	public String priceTag() {
		return getName() + " (used) " + "$" + getPrice() + " (Manufacture date: " + formato.format(manufactureDate) + ")";
	}
	
	@Override
	public String toString() {
		return priceTag();
	}
}
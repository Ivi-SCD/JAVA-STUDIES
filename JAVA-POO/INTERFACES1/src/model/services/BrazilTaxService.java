package model.services;

public class BrazilTaxService implements TaxService{
	
	public double tax(double amount) {
		double tax  = (amount <= 100) ? amount *0.2 : amount * 0.15;
		return tax;
	}
}
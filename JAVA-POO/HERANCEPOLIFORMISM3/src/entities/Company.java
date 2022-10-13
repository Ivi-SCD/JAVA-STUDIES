package entities;

public class Company extends TaxPayer {
	
	private Integer numberOfEmployees;
	
	public Company() {
		super();
	}

	public Company(String name, double anualIncome, Integer numberOfEmployees) {
		super(name, anualIncome);
		this.numberOfEmployees = numberOfEmployees;
	}

	public Integer getNumberOfEmployees() {
		return numberOfEmployees;
	}

	public void setNumberOfEmployees(Integer numberOfEmployees) {
		this.numberOfEmployees = numberOfEmployees;
	}

	@Override
	public double tax() {
		int total = 0;
		if (numberOfEmployees < 10) {
			total += getAnualIncome()*0.16;
		}
		if (numberOfEmployees >= 10) {
			total += getAnualIncome()*0.14;
		}
		
		return total;
	}

	@Override
	public String toString() {
		return getName() + ": " + "$" + String.format("%.2f", tax());
	}
}
package entities;

public class OutSourcedEmployee extends Employee {

	private Double additionalCharge;
	
	public OutSourcedEmployee() {
		super();
	}

	public OutSourcedEmployee(String name, Integer hours, Double valuePerHour, Double additionalCharge) {
		super(name, hours, valuePerHour);
		this.additionalCharge = additionalCharge;
	}
	

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getName() + " - ");
		sb.append(payment() + additionalCharge*1.1);
		return sb.toString();
	}
}
package model.entities;

public class Airplane implements Comparable<Airplane> {

	private Integer id;
	private Double fuel;
	private String airline;
	private Integer passengers;

	public Airplane() {
	}
	
	public Airplane(Integer id, Double fuel, String airline, Integer passengers) {
		this.id = id;
		this.fuel = fuel;
		this.airline = airline;
		this.passengers = passengers;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getFuel() {
		return fuel;
	}

	public void setFuel(Double fuel) {
		this.fuel = fuel;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public Integer getPassengers() {
		return passengers;
	}

	public void setPassengers(Integer passengers) {
		this.passengers = passengers;
	}

	@Override
	public String toString() {
		return airline + " - " + "Fuel:" + fuel + " | Passengers: " + passengers;
	}

	@Override
	public int compareTo(Airplane o) {
		if(fuel == o.getFuel()) {
			return passengers.compareTo(o.getPassengers());
		}
		else {
			return fuel.compareTo(o.getFuel());
		}
	}
}
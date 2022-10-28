package entities;

public class Contact implements Comparable <Contact> {
	
	private Integer id;
	private Integer phonenumber;
	
	public Contact() {
	}
	
	public Contact(Integer id, Integer phonenumber) {
		this.phonenumber = phonenumber;
		if(id == null) {
			if(this.id == null) {
				setId(1);
			} else {
				setId(this.id+1);
			}
		} else {
			setId(this.id+1);
		}
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getPhonenumber() {
		return phonenumber;
	}
	
	public void setPhonenumber(Integer phonenumber) {
		this.phonenumber = phonenumber;
	}
	
	@Override
	public String toString() {
		return id + " - " + phonenumber;
	}

	@Override
	public int compareTo(Contact c) {
		return phonenumber.compareTo(c.getPhonenumber());
	}
}
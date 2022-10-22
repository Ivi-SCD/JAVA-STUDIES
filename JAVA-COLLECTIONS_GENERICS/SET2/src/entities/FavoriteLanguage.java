package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FavoriteLanguage implements Comparable<FavoriteLanguage>{
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private String name;
	private Date creationYear;
	private String ide;
	
	public FavoriteLanguage() {
	}

	public FavoriteLanguage(String name, Date creationYear, String ide) {
		this.name = name;
		this.creationYear = creationYear;
		this.ide = ide;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreationYear() {
		return creationYear;
	}

	public void setCreationYear(Date creationYear) {
		this.creationYear = creationYear;
	}

	public String getIde() {
		return ide;
	}

	public void setIde(String ide) {
		this.ide = ide;
	}

	@Override
	public int compareTo(FavoriteLanguage fl) {
		return name.compareTo(fl.getName());
	}

	@Override
	public String toString() {
		return "FavoriteLanguage [name=" + name + ", creationYear=" + sdf.format(creationYear) + ", ide=" + ide + "]";
	}

	
}
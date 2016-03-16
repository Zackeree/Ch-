package model;

public class User {
	private String id, password, email;
	private int infraction;
	private boolean admin;

	public void log_in(String id, String password) {
		if(this.id == id && this.password == password)
	}
	
	public String getID() {
		return this.id;
	}
	
	public void setID(String id) {
		this.id = id;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public int getInfraction() {
		return this.infraction;
	}
	
	public boolean isAdmin() {
		if(this.admin == true)
			return true;
		else
			return false;
	}
}
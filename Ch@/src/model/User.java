package model;

public class User {
	private String id, password, email;
	private int infraction;
	private boolean admin;
	private Room room;
	
	public User(String id, String password, String email) {
		this.id = id;
		this.password = password;
		this.email = email;
		this.admin = false;
	}
	
	/******These methods are WIP*********************
	public void log_in(String id, String password) {
		if(this.id == id && this.password == password)
	}
	
	public void log_out(User model)	{
		
	}
	*************************************************/
	public String getID() {
		return this.id;
	}
	
	public void setID(String id) {
		this.id = id;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getInfraction() {
		return this.infraction;
	}
	
	public void setInfraction(int time) {
		if(this.admin == true)
			this.infraction = time;
	}
	
	public boolean isAdmin() {
		if(this.admin == true)
			return true;
		else
			return false;
	}
	
	// This method is a toggle method. If already an admin, calling it removes admin status.
	public void setAdmin() {
		if(!this.admin)
			this.admin = true;
		else if(this.admin)
			this.admin = false;
	}
	
	// Not properly implemented
	public Room createRoom() {
		return this.room;
	}
	
	// Not properly implemented
	public void blockUser(User model) {
		
	}
	
	/* following methods are NOT properly implemented, and require admin privileges** 
	public void banUser(User model, int time) {
		if(this.admin == true)
			model.setInfraction(time);
	}
		
	public void ORDel() {
		
	}
	*********************************************************************************/
}
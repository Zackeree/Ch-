package controller;

import model.Library;
import model.User;
import persist.DerbyDatabase;

public class LoginController {
	
	private String errorMessage;
	private User model;
	DerbyDatabase db = new DerbyDatabase();
	
	public LoginController() {
		model = new User(null, null, null);
	}
	
	public String getError(String username, String password) {
		if (db.userAlreadyExists(username) == 1) {
        	model = db.retrieveUser(username);
        	if(!password.equals(model.getPassword())){
        		return "Invalid username or password.";
        	}
		}
		else {
			return "Invalid username or password.";
		}
		return "";
	}
	
	public boolean validateCredentials(String message) {
		if(message == "Invalid username or password.")
			return false;
		else
			return true;
	}
}

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
	
	public String getError() {
		
		return "";
	}
	
	public boolean validateCredentials() {
		
		return true;
	}
}

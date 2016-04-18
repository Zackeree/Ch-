package controller;

import model.User;
import persist.DerbyDatabase;

public class RegisterController {
	
	DerbyDatabase db = new DerbyDatabase();

	public boolean validateCredentials(String username, String password, String password2, String email) {
		
		return false;
	}
	
	public void registerUser(String username, String password, String email) {
		db.insertUser(username, password, email);
	}
}

package controller;

import model.User;
import persist.DerbyDatabase;

public class RegisterController {
	
	private String errorMessage = "";
	private User model;
	DerbyDatabase db = new DerbyDatabase();
	
	public RegisterController() {
		model = new User(null, null, null);
	}
	
	public String getError(String username, String password, String password2, String email) {
		if(username.isEmpty()||password.isEmpty()||password2.isEmpty()||email.isEmpty()) {
			return "One or more fields is empty.";
		}
		
		if(!password.equals(password2)) {
			return "Your passwords do not match.";
		}
		
		if(!model.validateEmail(email)){
			return "Your email is not valid.";
		}
		if(db.userAlreadyExists(username) == 1){
			return "That username is already taken.";
		}
		
		else 
			return "";
	}

	public boolean validateCredentials(String username, String password, String password2, String email) {
		if(errorMessage.equals("One or more fields is empty."))
			return false;
		if(errorMessage.equals("Your passwords do not match."))
			return false;
		if(errorMessage.equals("Your email is not valid."))
			return false;
		if(errorMessage.equals("That username is already taken."))
			return false;
		else
			return true;
	}
	
	public void registerUser(String username, String password, String email) {
		db.insertUser(username, password, email);
	}
}

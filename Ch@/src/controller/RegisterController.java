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
			errorMessage = "One or more fields is empty.";
			return errorMessage;
		}
		
		if(!password.equals(password2)) {
			errorMessage = "Your passwords do not match.";
			return errorMessage;
		}
		
		if(!model.validateEmail(email)){
			errorMessage = "Your email is not valid.";
			return errorMessage;
		}
		if(db.userAlreadyExists(username) == 1){
			errorMessage = "That username is already taken.";
			return errorMessage;
		}
		
		else { 
			errorMessage = "";
			return "";
		}
	}

	public boolean validateCredentials(String username, String password, String password2, String email) {
		if(errorMessage.equals("One or more fields is empty.") ||
		   errorMessage.equals("That username is already taken.") ||
		   errorMessage.equals("Your passwords do not match.") || 
		   errorMessage.equals("Your email is not valid."))
			return false;
		else
			return true;
	}
	
	public void registerUser(String username, String password, String email) {
		db.insertUser(username, password, email);
	}
}

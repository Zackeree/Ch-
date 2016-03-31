package model;

import java.util.ArrayList;

public class FakeDatabase {
	private ArrayList<User> userList = new ArrayList<User>();
	
	// Default FakeDatabase constructor
	public FakeDatabase() {
		userList.add(new User("test", "yes", "email@email.com"));
		userList.add(new User("Brandon", "sqrt", "blonge@chatroom.gov"));
		userList.add(new User("Zack", "allimager", "ceo@google.com"));
	}
	
	public boolean validate(FakeDatabase db,String user, String password) {
		if(db.userList.contains(user)) {
			if(db.userList.contains(password)) {
				if(db.userList.indexOf(user) == db.userList.indexOf(password))
					return true;
			}
		}
		
		return false;
	}
}
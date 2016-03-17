package model;

import java.util.ArrayList;

public class FakeDatabase {
	private ArrayList<User> userList = new ArrayList<User>();
	
	
	userList.add(new User("test", "yes", "email@email.com"));
	userList.add(new User("Brandon", "sqrt", "blonge@chatroom.gov"));
	userList.add(new User("Zack", "allimager", "ceo@google.com"));
}
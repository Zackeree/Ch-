package database;

import java.util.ArrayList;

import model.User;
import model.Message;

public class FakeDatabase implements IDatabase {
	private ArrayList<User> userList = new ArrayList<User>();
	private ArrayList<Message> messageList = new ArrayList<Message>();
	
	// Default FakeDatabase constructor
	public FakeDatabase() {
		userList.add(new User("test", "yes", "email@email.com"));
		userList.add(new User("Brandon", "sqrt", "blonge@chatroom.gov"));
		userList.add(new User("Zack", "allimager", "ceo@google.com"));
		
		messageList.add(new Message("Hey! Do you like spam?"));
		messageList.add(new Message("Yeah! I love spam!"));
		messageList.add(new Message("No way! ME TOOO!!! :D"));
		
	}
	
	public boolean validate(String id, String password) {
		
		for (User u : userList) {
			if (u.getID().equals(id) && u.getPassword().equals(password))
				return true;
		}
		
		return false;
	}
	
	@Override
	public void createUser(String id, String password, String email) {
		userList.add(new User(id,password,email));
	}
	
	@Override
	public User retrieveUser(String id) {
		for (User u : userList) {
			if (u.getID().equals(id)) {
				return u;
			}
		}
		return null;
	}

	@Override
	public void updateUser(String id, String password, String email) {
		for (User u : userList) {
			// (User can not update id, but may update password and email)
			if (u.getID().equals(id)) {
				u.setPassword(password);
				u.setEmail(email);
			}
		}
	}
	
	@Override
	public void deleteUser(String id) {
		for (User u : userList) {
			if (u.getID().equals(id)) {
				// Need User method to delete an account (u.remove();)
			}
		}
	}
	
	@Override
	public ArrayList<Message> retrieveMessages() {
		
		return messageList;
	}
	
	public void addMessage(Message message) {
		
		if (message.getText().isEmpty() == false) {
			
			messageList.add(message);
		}
	}
}
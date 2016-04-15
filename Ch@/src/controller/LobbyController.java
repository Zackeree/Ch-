package controller;

import java.util.ArrayList;
import java.util.List;

import model.*;
import persist.DatabaseProvider;
import persist.DerbyDatabase;
import persist.IDatabase;

public class LobbyController {
	
	private IDatabase db = null;

	public LobbyController() {
		DatabaseProvider.setInstance(new DerbyDatabase());
		db = DatabaseProvider.getInstance();
	}
	
	public ArrayList<User> getUsersInLobby() {
		List<User> userList = db.findAllUsers();
		ArrayList<User> users = null;
		
		if (userList.isEmpty()) {
			System.out.println("No users online.");
			return null;
		}
		else {
			users = new ArrayList<User>();
			for (User user : userList) {
				users.add(user);
				System.out.println(user.getID());
			}			
		}
		
		return users;
	}
	
	// to be filled. obviously
	public ArrayList<Room> getRooms() {
		
		return null;
	}
}

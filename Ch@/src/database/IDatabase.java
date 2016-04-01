package database;

import java.util.ArrayList;

import model.User;

public interface IDatabase {

	public boolean validate(String id, String password);
	
	public void createUser(String id, String password, String email);
	public User retrieveUser(String id);
	public void updateUser(String id, String password, String email);
	public void deleteUser(String id);

	
	public ArrayList retrieveMessages();
}

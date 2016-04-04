package model;

import java.util.ArrayList;

public class Lobby {
	private ArrayList<Room> rooms;
	private ArrayList<User> users;
	
	public ArrayList<Room> getRooms() {
		return this.rooms;
	}
	
	public void setRooms(ArrayList<Room> rooms) {
		this.rooms = rooms;
	}
	
	public ArrayList<User> getUsers() {
		return this.users;
	}
	
	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}
}

package model;
 
import java.util.ArrayList;

public class Room {
	private int roomId;
	private String name;
	private ArrayList<User> users;
	private ArrayList<Message> messages;
	private boolean privacy_flag;
	private User owner;
	
	public Room(String name, boolean privacy_flag, User owner) {
		this.name = name;
		this.privacy_flag = privacy_flag;
		this.owner = owner;
		this.users = new ArrayList<User>();
		this.messages = new ArrayList<Message>();
	}
	
	public void Purge() {
		
	}
	
	public void Delete() {
		
	}
	
	public void Join() {
		
	}
	
	public void Invite(User user) {
		users.add(user);
	}
	
	public void Kick(User user) {
		users.remove(user);
	}
	
	/* GETTERS AND SETTERS */
	public int getRoomId() {
		return this.roomId;
	}
	
	public void setRoomId(int id) {
		this.roomId = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public ArrayList<User> getUsers() {
		return this.users;
	}
	
	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}
	
	public ArrayList<Message> getMessages() {
		return this.messages;
	}
	
	public void setMessages(ArrayList<Message> messages) {
		this.messages = messages;
	}
	
	public boolean isPrivate() {
		return this.privacy_flag;
	}
	
	public void setPrivate(boolean setting) {
		this.privacy_flag = setting;
	}
	
	public User getOwner() {
		return this.owner;
	}
	
	public void setOwner(User user) {
		this.owner = user;
	}
}
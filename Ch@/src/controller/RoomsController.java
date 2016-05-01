package controller;

import java.util.ArrayList;

import model.Message;
import persist.DerbyDatabase;

public class RoomsController {

	private ArrayList<Message> messages;
	private Message model;
	DerbyDatabase db = new DerbyDatabase();
	
	public RoomsController() {
		model = new Message(null);
		messages = new ArrayList<Message>();
	}
	
	public ArrayList<Message> getMessages() {
		messages = db.retrieveMessages();
		return messages;
	}
	
	public void addMessage(Message message, String username) {
		db.insertMessage(message, username);
	}
}

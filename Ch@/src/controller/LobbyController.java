package controller;

import java.util.ArrayList;

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
	/*
	public ArrayList<User> getUsersInLobby() {
		
	}*/
}

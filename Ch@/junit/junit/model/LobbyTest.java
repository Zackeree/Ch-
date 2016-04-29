package junit.model;

import model.Lobby;
import model.Message;
import model.Room;
import model.User;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class LobbyTest {
	private Lobby model;
	private Room rmodel, rmodel2;
	private User uModel, uModel2;
	
	private ArrayList<Room> rooms;
	
	@Before
	public void setUp() {
		uModel = new User(null, null, null);
		uModel2 = new User("id", "pass", "email");
		
		rmodel = new Room("test", false, uModel);
		rmodel2 = new Room(null, true, uModel2);
		
		rooms.add(rmodel);
		
		model = new Lobby(rooms);
	}
	
	/*
	@Test
	public void testGetRooms() {
		assertEquals(rmodel, model.getRooms());
	}
	
	@Test
	public void testSetRooms() {
		
	}
	
	@Test
	public void testGetUsers() {
		
	}
	
	@Test
	public void testSetUsers() {
		
	}
	*/
}

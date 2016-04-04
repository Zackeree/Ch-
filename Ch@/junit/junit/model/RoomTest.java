package junit.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Room;
import model.User;

public class RoomTest {
	private Room model, model2;
	private User uModel, uModel2;

	@Before
	public void setUp() {
		model = new Room("test", false, null);
		model2 = new Room("RealZ", true, new User("id", "pass", "email"));
		uModel = new User(null, null, null);
		uModel2 = new User("id", "pass", "email");
	}
	
	@Test
	public void testPurge() {
		
	}
	
	@Test
	public void testDelete() {
		
	}
	
	@Test
	public void testJoin() {
		
	}
	
	@Test
	public void testInvite() {
		
	}
	
	@Test
	public void testKick() {
		
	}
	
	@Test
	public void testGetName() {
		
	}
	
	@Test
	public void testSetName() {
		
	}

	@Test
	public void testGetUsers() {
		
	}

	@Test
	public void testSetUsers() {
		
	}

	@Test
	public void testGetMessages() {
		
	}

	@Test
	public void testSetMessages() {
		
	}

	@Test
	public void testIsPrivate() {
		
	}

	@Test
	public void testSetPrivate() {
		
	}

	@Test
	public void testGetOwner() {
		
	}

	@Test
	public void testSetOwner() {
		
	}
}
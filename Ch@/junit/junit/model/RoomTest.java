package junit.model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import model.Message;
import model.Room;
import model.User;

public class RoomTest {
	private Room model, model2;
	private User uModel, uModel2;
	private ArrayList<User> users, users2;
	private ArrayList<Message> messages, messages2;

	@Before
	public void setUp() {		
		uModel = new User(null, null, null);
		uModel2 = new User("id", "pass", "email");
		
		model = new Room("test", false, uModel);
		model2 = new Room(null, true, uModel2);
		
		users = new ArrayList<User>();
		users2 = new ArrayList<User>();
		
		messages = new ArrayList<Message>();
		messages2 = new ArrayList<Message>();

		users2.add(uModel);
		users2.add(uModel2);
		
		messages2.add(new Message("teeeest"));
		messages2.add(new Message("ok"));
		
		model2.setUsers(users2);
		model2.setMessage(messages2.get(1));
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
		model.Invite(uModel);
		model2.Invite(uModel2);
		
		assertTrue(model.getUsers().contains(uModel));
		assertTrue(model2.getUsers().contains(uModel2));
		assertFalse(model.getUsers().contains(uModel2));
	}
	
	@Test
	public void testKick() {
		model2.Kick(uModel2);
		
		assertFalse(model2.getUsers().contains(uModel2));
	}
	
	@Test
	public void testGetName() {
		assertEquals("test", model.getName());
		assertEquals(null, model2.getName());
	}
	
	@Test
	public void testSetName() {
		model.setName(null);
		model2.setName("'");
		assertEquals(null, model.getName());
		assertEquals("'", model2.getName());
	}

	@Test
	public void testGetUsers() {
		assertEquals(users, model.getUsers());
		assertEquals(users2, model2.getUsers());
	}

	@Test
	public void testSetUsers() {
		model.setUsers(users2);
		model2.setUsers(users);
		
		assertEquals(users2, model.getUsers());
		assertEquals(users, model2.getUsers());
	}

	@Test
	public void testGetMessages() {
		assertEquals(messages, model.getMessages());
		assertEquals(messages2, model2.getMessages());
	}

	@Test
	public void testSetMessage() {
		model.setMessage(messages2.get(1));
		//model2.setMessage(messages.get(1));
		
		assertEquals(messages2.get(1), model.getMessages().get(1));
		//assertEquals(messages.get(1), model2.getMessages().get(1));
	}

	@Test
	public void testIsPrivate() {
		assertEquals(false, model.isPrivate());
		assertEquals(true, model2.isPrivate());
	}

	@Test
	public void testSetPrivate() {
		model.setPrivate(true);
		model2.setPrivate(false);
		
		assertEquals(true, model.isPrivate());
		assertEquals(false, model2.isPrivate());
	}

	@Test
	public void testGetOwner() {
		assertEquals(uModel.toString(), model.getOwner().toString());
		assertEquals(uModel2.toString(), model2.getOwner().toString());
	}

	@Test
	public void testSetOwner() {
		model.setOwner(uModel2);
		model2.setOwner(uModel);
		
		assertEquals(uModel2.toString(), model.getOwner().toString());
		assertEquals(uModel.toString(), model2.getOwner().toString());
	}
}
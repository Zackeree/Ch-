package junit.queries;

import persist.DerbyDatabase;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import model.Message;
import model.User;

public class DerbyDatabaseTest {

	private DerbyDatabase db;
	private User user;
	private Message message;
	
	@Before
	public void setUp() {
		db = new DerbyDatabase();
		user = new User(null, null, null);
		message = new Message(null);
	}
	
	@Test
	public void testRetrieveUser() {
		user = db.retrieveUser("zhenry");
		assertEquals("zhenry", user.getID());
		user = db.retrieveUser("test");
		assertEquals("test", user.getID());
		user = db.retrieveUser("blonge");
		assertNotEquals("false", user.getID());
	}
	
	@Test
	public void testRetrieveMessages() {
		ArrayList <Message> messages = new ArrayList<Message>();
		messages = db.retrieveMessages();
		message = messages.get(0);
		assertTrue(message.getText().contains("this is a string"));
		message = messages.get(1);
		assertTrue(message.getText().contains("this is another string"));
		message = messages.get(2);
		assertTrue(message.getText().contains("this is sparta"));
		message = messages.get(3);
		assertTrue(message.getText().contains("No this is Patrick."));
	}
	
	@Test
	public void testUserAlreadyExists() {
		int temp = db.userAlreadyExists("zhenry");
		assertEquals(1, temp);
		temp = db.userAlreadyExists("test");
		assertEquals(1, temp);
		temp = db.userAlreadyExists("blonge");
		assertEquals(1, temp);
		temp = db.userAlreadyExists("ff");
		assertEquals(0, temp);
	}

	@Test
	public void testFindMessageByID() {
		
	}

	@Test
	public void testFindMessageByUser() {
		
	}

	@Test
	public void testFindMessageByRoom() {
		
	}

	@Test
	public void testFindAllUsers() {
		
	}

	@Test
	public void testInsertUser() {
		
	}

	@Test
	public void testInsertMessage() {
		
	}
}

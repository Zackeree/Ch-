package junit.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.User;

public class UserTest {
	private User model, model2;
	@Before
	public void setUp() {
		model = new User("name","pass","testworks@maybe.not");
		model2 = new User("anothername","notpass","doesnot@work.jk");
	}
	
	@Test
	public void testGetUserIDNum() {
		assertEquals(0, model.getUserIDNum());
	}
	
	@Test
	public void testSetUserIDNum() {
		model.setUserIDNum(267);
		assertEquals(267, model.getUserIDNum());
	}
	
	@Test
	public void testGetID() {
		assertEquals("name", model.getID());
	}
	
	@Test
	public void testSetID() {
		model.setID("ok");
		assertEquals("ok", model.getID());
		
		model.setID(null);
		assertEquals(null, model.getID());
	}
	
	@Test
	public void testGetPassword() {
		assertEquals("pass", model.getPassword());
	}
	
	@Test
	public void testSetPassword() {
		model.setPassword("*******");
		assertEquals("*******", model.getPassword());
		
		model.setPassword(null);
		assertEquals(null, model.getPassword());
	}

	@Test
	public void testGetEmail() {
		assertEquals("testworks@maybe.not", model.getEmail());
	}
	
	@Test
	public void testValidEmail() {
		assertTrue(model.validateEmail(model.getEmail()));
		assertFalse(model.validateEmail("a@b."));
		assertTrue(model.validateEmail("b.long@gmail.com"));
		assertFalse(model.validateEmail("a@.com"));
		assertTrue(model.validateEmail("a@b.c"));
		assertFalse(model.validateEmail("@gmail.com"));
		assertFalse(model.validateEmail("a@b@c"));
	}
	
	@Test
	public void testSetEmail() {
		model.setEmail("yes@google.com");
		assertEquals("yes@google.com", model.getEmail());
		
		model.setEmail(null);
		assertEquals(null, model.getEmail());
	}
	
	@Test
	public void testGetInfraction() {
		assertEquals(0, model.getInfraction());
	}
	
	@Test
	public void testSetInfraction() {
		model.setInfraction(20);
		assertEquals(20, model.getInfraction());
		
		model.setInfraction(-1);
		assertEquals(-1, model.getInfraction());
	}
	
	@Test
	public void testIsAdmin() {
		assertEquals(false, model.isAdmin());
	}
	
	@Test
	public void testSetAdmin() {
		model.setAdmin(true);
		assertEquals(true, model.isAdmin());
	}
	
	@Test
	public void testToString() {
		String expected = "User [userIdNum=0, id=name, password=pass, email=testworks@maybe.not, "
				+ "infraction=0, admin=false, room=null]";
		assertEquals(expected, model.toString());
	}
	
	@Test
	public void testEquals() {
		Object test = model;
		Object test2 = model2;
		assertTrue(model.equals(test));
		assertFalse(model.equals(test2));
	}
	
}

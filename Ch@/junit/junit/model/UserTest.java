package junit.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.User;

public class UserTest {
	private User model;
	@Before
	public void setUp() {
		model = new User("name","pass","testworks@maybe.not");
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
}

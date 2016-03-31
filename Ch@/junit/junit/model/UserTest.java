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
	public void testGetPassword() {
		assertEquals("pass", model.getPassword());
	}

	@Test
	public void testGetEmail() {
		assertEquals("testworks@maybe.not", model.getEmail());
	}
	
	// ADD MORE TEST CASES TO THIS
	
}

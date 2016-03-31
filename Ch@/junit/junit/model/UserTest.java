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
	public void testSetID() {
		model.setID("namechanged");
		assertEquals("namechanged", model.getID());
	}
	
	// ADD MORE TEST CASES TO THIS
	
}

package junit.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import database.FakeDatabase;
import model.User;

public class FakeDatabaseTest {
	private FakeDatabase db;
	
	@Before
	public void setUp() {
		db = new FakeDatabase();
		db.createUser("imauser", "imapassword", "123@4.5");
	}
	
	@Test
	public void testValidate() {
		assertTrue(db.validate("imauser", "imapassword"));
	}
	
	@Test
	public void testRetrieveUser() {
		assertEquals("123@4.5", db.retrieveUser("imauser").getEmail());
		
	}
	
	// ADD MORE TEST CASES TO THIS
	
}

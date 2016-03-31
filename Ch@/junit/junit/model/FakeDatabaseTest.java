package junit.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.FakeDatabase;

public class FakeDatabaseTest {
	private FakeDatabase model;
	
	@Before
	public void setUp() {
		model = new FakeDatabase();
		
	}
	
	@Test
	public void testValidate() {
		assertTrue(model.validate(model, "test", "yes"));
	}
	
	
	// ADD MORE TEST CASES TO THIS
	
}

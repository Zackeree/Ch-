package junit.model;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import model.Message;

public class MessageTest {
	private Message model;
	@Before
	public void setUp() {
		model = new Message("asddamnfe");
	}
	
	@Test
	public void testValidMessage() {
		
		assertEquals("asd****fe", model.ValidateMessage());
	}
	
	@Test
	public void testGetTime() {
		
		System.out.println(model.GetTime());
	}
	
	// ADD MORE TEST CASES TO THIS
	
}

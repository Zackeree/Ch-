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
		model = new Message();
		
	}
	
	@Test
	public void testValidMessage() {
		assertEquals("asd****fe", model.ValidateMessage("asddamnfe"));
		
	}
	
	@Test
	public void testGetTime() {
		Date now = new Date();
		String time = new SimpleDateFormat("h:mm:ss a").format(now);

		System.out.println(time);
	}
	
	// ADD MORE TEST CASES TO THIS
	
}

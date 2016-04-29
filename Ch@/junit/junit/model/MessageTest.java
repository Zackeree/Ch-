package junit.model;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import model.Message;

public class MessageTest {
	private Message model, model2;
	@Before
	public void setUp() {
		model = new Message("asddamnfe");
		model2 = new Message("My name is Bob!");
	}
	
	@Test
	public void testValidMessage() {
		assertEquals("asd****fe", model.getValidatedMessage().getText());
	}
	
	@Test
	public void testGetIdNum() {
		assertEquals(0, model.getIdNum());
	}
	
	@Test
	public void testSetIdNum() {
		model.setIdNum(36);
		assertEquals(36, model.getIdNum());
	}
	
	@Test
	public void testGetText() {
		assertEquals("asddamnfe", model.getText());
		assertEquals("My name is Bob!", model2.getText());
	}
	
	@Test
	public void testSetText() {
		model.setText("Hellow");
		assertEquals("Hellow", model.getText());
	}
	
}

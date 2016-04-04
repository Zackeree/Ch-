package junit.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Room;
import model.User;

public class RoomTest {
	private Room model, model2;

	@Before
	public void setUp() {
		model = new Room("test", false, null);
		model2 = new Room("RealZ", true, new User("id", "pass", "email"));
	}
	
	
}
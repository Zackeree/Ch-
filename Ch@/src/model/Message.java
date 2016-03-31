package model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;


public class Message {
	private String text;
	private int length;
	private long time;
	
	
	public String ValidateMessage(String text) {
		
		text = text.toLowerCase().replaceAll("damn", "****");
		
		return text;
	}
	
	public String GetTime() {
		
		Date now = new Date();
		String time = new SimpleDateFormat("h:mm:ss a").format(now);
		
		return time;
	}
}

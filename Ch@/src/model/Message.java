package model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;


public class Message {
	private int idNum;
	private String text;
	private int length;
	private long time;
	
	public Message(String text) {
		this.text = text;
	}
	
	public String ValidateMessage() {
		
		this.text = this.text.toLowerCase().replaceAll("damn", "****");
		
		return text;
	}
	
	public int getIdNum() {
		return this.idNum;
	}
	
	public void setIdNum(int id) {
		this.idNum = id;
	}
	
	public String getText() {
		return this.text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public String GetTime() {
		
		Date now = new Date();
		String time = new SimpleDateFormat("h:mm:ss a").format(now);
		
		return time;
	}
}
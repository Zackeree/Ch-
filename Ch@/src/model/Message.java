package model;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class Message {
	private int idNum;
	private String text;
	private String time;
	
	public Message(String text) {
		this.text = text;
		Date now = new Date();
		this.time = new SimpleDateFormat("h:mm:ss a").format(now);
	}

	public Message getValidatedMessage() {
		//this.text = this.text.toLowerCase().replaceAll("damn", "****");
		return this;
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

	public String getTime() {
		return time;	
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	public String toString() {
		return text + "\t" + time.toString();
	}
}
package model;

import java.time.LocalDateTime;

public class Message {
	private int idNum;
	private String text;
	private LocalDateTime time;

	public Message(String text) {
		this.text = text;
		this.time = LocalDateTime.now();
	}

	public Message getValidatedMessage() {
		this.text = this.text.toLowerCase().replaceAll("damn", "****");
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

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	
	public String toString() {
		return text + "\t" + time.toString();
	}
}
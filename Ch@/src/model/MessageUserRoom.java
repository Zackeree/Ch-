package model;

public class MessageUserRoom {

	private int messageIdNum;
	private int userIdNum;
	private int roomIdNum;
	
	public MessageUserRoom() {
		
	}
	
	public int getMessageIDNum() {
		return this.messageIdNum;
	}
	
	public void setMessageIDNum(int mIDNum) {
		this.messageIdNum = mIDNum;
	}
	
	public int getUserIDNum() {
		return this.userIdNum;
	}
	
	public void setUserIDNum(int uIDNum) {
		this.userIdNum = uIDNum;
	}
	
	public int getRoomIDNum() {
		return this.roomIdNum;
	}
	
	public void setRoomIDNum(int rIDNum) {
		this.roomIdNum = rIDNum;
	}
}

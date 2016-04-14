package persist;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.Author;
import model.Book;
import model.BookAuthor;
import model.Message;
import model.MessageUserRoom;
import model.Room;
import model.User;

public class InitialData {

	// reads initial Author data from CSV file and returns a List of Authors
	public static List<Author> getAuthors() throws IOException {
		List<Author> authorList = new ArrayList<Author>();
		ReadCSV readAuthors = new ReadCSV("authors.csv");
		try {
			// auto-generated primary key for authors table
			Integer authorId = 1;
			while (true) {
				List<String> tuple = readAuthors.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				Author author = new Author();

				// read author ID from CSV file, but don't use it
				// it's there for reference purposes, just make sure that it is correct
				// when setting up the BookAuthors CSV file				
				Integer.parseInt(i.next());
				// auto-generate author ID, instead
				author.setAuthorId(authorId++);				
				author.setLastname(i.next());
				author.setFirstname(i.next());
				authorList.add(author);
			}
			System.out.println("authorList loaded from CSV file");
			return authorList;
		} finally {
			readAuthors.close();
		}
	}
	
	public static List<User> getUsers() throws IOException {
		List<User> userList = new ArrayList<User>();
		ReadCSV readUsers = new ReadCSV("users.csv");
		try {
			// auto-generated primary key for users table
			Integer userId = 1;
			while (true) {
				List<String> tuple = readUsers.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				User user = new User(null, null, null);

				// read user ID # from CSV file, but don't use it
				// it's there for reference purposes, just make sure that it is correct
				// when setting up the UserRoomMessage CSV file				
				Integer.parseInt(i.next());
				// auto-generate user ID #, instead
				user.setUserIDNum(userId++);				
				user.setID(i.next());
				user.setPassword(i.next());
				user.setEmail(i.next());
				userList.add(user);
			}
			System.out.println("userList loaded from CSV file");
			return userList;
		} finally {
			readUsers.close();
		}
	}
	
	public static List<Room> getRooms() throws IOException {
		List<Room> roomList = new ArrayList<Room>();
		ReadCSV readRooms = new ReadCSV("rooms.csv");
		try {
			Integer roomId = 1;
			while (true) {
				List<String> tuple = readRooms.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				Room room = new Room(null, false, null);
				Integer.parseInt(i.next());
				
				room.setRoomId(roomId++);
				room.setName(i.next());
				room.setPrivate(Boolean.parseBoolean(i.next()));
				roomList.add(room);
			}
			System.out.println("roomList loaded from CSV file");
			return roomList;
		} finally {
			readRooms.close();
		}
	}
	
	public static List<Message> getMessages() throws IOException {
		List<Message> messageList = new ArrayList<Message>();
		ReadCSV readMessages = new ReadCSV("messages.csv");
		try {
			Integer messageId = 1;
			while (true) {
				List<String> tuple = readMessages.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				Message message = new Message(null);
				Integer.parseInt(i.next());
				
				message.setIdNum(messageId++);
				message.setText(i.next());
				messageList.add(message);
			}
			System.out.println("messageList loaded from CSV file");
			return messageList;
		} finally {
			readMessages.close();
		}
	}
	
	// reads initial Book data from CSV file and returns a List of Books
	public static List<Book> getBooks() throws IOException {
		List<Book> bookList = new ArrayList<Book>();
		ReadCSV readBooks = new ReadCSV("books.csv");
		try {
			// auto-generated primary key for table books
			Integer bookId = 1;
			while (true) {
				List<String> tuple = readBooks.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				Book book = new Book();
				
				// read book ID from CSV file, but don't use it
				// it's there for reference purposes, just make sure that it is correct
				// when setting up the BookAuthors CSV file
				Integer.parseInt(i.next());
				// auto-generate book ID, instead
				book.setBookId(bookId++);				
//				book.setAuthorId(Integer.parseInt(i.next()));  // no longer in books table
				book.setTitle(i.next());
				book.setIsbn(i.next());
				bookList.add(book);
			}
			System.out.println("bookList loaded from CSV file");			
			return bookList;
		} finally {
			readBooks.close();
		}
	}
	
	// reads initial BookAuthor data from CSV file and returns a List of BookAuthors
	public static List<BookAuthor> getBookAuthors() throws IOException {
		List<BookAuthor> bookAuthorList = new ArrayList<BookAuthor>();
		ReadCSV readBookAuthors = new ReadCSV("book_authors.csv");
		try {
			while (true) {
				List<String> tuple = readBookAuthors.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				BookAuthor bookAuthor = new BookAuthor();
				bookAuthor.setBookId(Integer.parseInt(i.next()));				
				bookAuthor.setAuthorId(Integer.parseInt(i.next()));
				bookAuthorList.add(bookAuthor);
			}
			System.out.println("bookAuthorList loaded from CSV file");			
			return bookAuthorList;
		} finally {
			readBookAuthors.close();
		}
	}
	
	public static List<MessageUserRoom> getMessageUserRoom() throws IOException {
		List<MessageUserRoom> MURList = new ArrayList<MessageUserRoom>();
		ReadCSV readMUR = new ReadCSV("message_user_room.csv");
		try {
			while (true) {
				List<String> tuple = readMUR.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				MessageUserRoom MUR = new MessageUserRoom();
				MUR.setMessageIDNum(Integer.parseInt(i.next()));	
				MUR.setUserIDNum(Integer.parseInt(i.next()));
				MUR.setRoomIDNum(Integer.parseInt(i.next()));
				MURList.add(MUR);
			}
			System.out.println("MessageUserRoomList loaded from CSV file");			
			return MURList;
		} finally {
			readMUR.close();
		}
	}
}
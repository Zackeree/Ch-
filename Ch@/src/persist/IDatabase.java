package persist;

import java.util.List;

import model.Author;
import model.Book;
import model.Message;
import model.Pair;
import model.Room;
import model.User;

public interface IDatabase {
	public List<Pair<Author, Book>> findAuthorAndBookByTitle(String title);
	public List<Pair<Author, Book>> findAuthorAndBookByAuthorLastName(String lastName);
	public Integer insertBookIntoBooksTable(String title, String isbn, String lastName, String firstName);
	public List<Pair<Author, Book>> findAllBooksWithAuthors();
	public List<Author> findAllAuthors();
	public List<Author> removeBookByTitle(String title);
	public List<User> findAllUsers();
	public List<Pair<Message, Room>> findMessageByRoom();
	public User retrieveUser(String username);
}

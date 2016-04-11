package queries;

import java.util.List;
import java.util.Scanner;

import model.Author;
import model.Book;
import model.Pair;
import persist.DatabaseProvider;
import persist.IDatabase;

public class AllBooksQuery {
	public static void main(String[] args) throws Exception {
		Scanner keyboard = new Scanner(System.in);

		// Create the default IDatabase instance
		InitDatabase.init(keyboard);
		
		// get the DB instance and execute transaction
		IDatabase db = DatabaseProvider.getInstance();
		List<Pair<Author, Book>> authorBookList = db.findAllBooksWithAuthors();
		
		// check if anything was returned and output the list
		if (authorBookList.isEmpty()) {
			System.out.println("There are no books in the database");
		}
		else {
			for (Pair<Author, Book> authorBook : authorBookList) {
				Author author = authorBook.getLeft();
				Book book = authorBook.getRight();
				System.out.println(book.getTitle() + ", " + book.getIsbn() + ", " + author.getLastname() + ", " + author.getFirstname());
			}
		}
	}
}

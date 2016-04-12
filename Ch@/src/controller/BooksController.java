package controller;

import java.util.ArrayList;
import java.util.List;

import model.Author;
import model.Book;
import model.Pair;
import persist.DatabaseProvider;
import persist.DerbyDatabase;
import persist.IDatabase;

public class BooksController {

	private IDatabase db    = null;

	public BooksController() {
		
		// creating DB instance here
		DatabaseProvider.setInstance(new DerbyDatabase());
		db = DatabaseProvider.getInstance();		
	}

	public ArrayList<Book> getTitleByAuthor(String lastName) {
		
		// get the list of (Author, Book) pairs from DB
		List<Pair<Author, Book>> authorBookList = db.findAuthorAndBookByAuthorLastName(lastName);
		ArrayList<Book> books = null;
		
		if (authorBookList.isEmpty()) {
			System.out.println("No books found for author <" + lastName + ">");
			return null;
		}
		else {
			books = new ArrayList<Book>();
			for (Pair<Author, Book> authorBook : authorBookList) {
				Author author = authorBook.getLeft();
				Book book = authorBook.getRight();
				books.add(book);
				System.out.println(author.getLastname() + "," + author.getFirstname() + "," + book.getTitle() + "," + book.getIsbn());
			}			
		}
		
		// return of books for this author
		return books;
	}
}

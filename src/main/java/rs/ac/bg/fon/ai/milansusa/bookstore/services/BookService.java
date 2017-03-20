package rs.ac.bg.fon.ai.milansusa.bookstore.services;

import java.util.List;

import rs.ac.bg.fon.ai.milansusa.bookstore.model.Book;
import rs.ac.bg.fon.ai.milansusa.bookstore.persistance.SimpleBookstorePersistance;

public class BookService {
	
	private SimpleBookstorePersistance persistance = new SimpleBookstorePersistance();

	public List<Book> getAllBooks() {
		return persistance.getAllBooks();
	}
}

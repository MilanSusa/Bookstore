package rs.ac.bg.fon.ai.milansusa.bookstore.services;

import java.util.List;

import rs.ac.bg.fon.ai.milansusa.bookstore.model.Book;
import rs.ac.bg.fon.ai.milansusa.bookstore.persistance.BookstorePersistance;
import rs.ac.bg.fon.ai.milansusa.bookstore.persistance.DummyBookstorePersistanceImpl;

public class BookService {
	
	private BookstorePersistance persistance = new DummyBookstorePersistanceImpl();

	public List<Book> getAllBooks() {
		return persistance.getAllBooks();
	}
}

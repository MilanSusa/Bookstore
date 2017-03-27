package rs.ac.bg.fon.ai.milansusa.bookstore.services;

import java.util.Collection;

import rs.ac.bg.fon.ai.milansusa.bookstore.model.Book;
import rs.ac.bg.fon.ai.milansusa.bookstore.persistance.BookstorePersistence;
import rs.ac.bg.fon.ai.milansusa.bookstore.persistance.DummyBookstorePersistenceImpl;

public class BookService {
	
	private BookstorePersistence persistance = new DummyBookstorePersistenceImpl();

	public Collection<Book> getAllBooks() {
		return persistance.getAllBooks();
	}
}

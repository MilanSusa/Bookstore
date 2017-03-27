package rs.ac.bg.fon.ai.milansusa.bookstore.services;

import java.util.Collection;

import rs.ac.bg.fon.ai.milansusa.bookstore.model.Author;
import rs.ac.bg.fon.ai.milansusa.bookstore.persistance.BookstorePersistence;
import rs.ac.bg.fon.ai.milansusa.bookstore.persistance.DummyBookstorePersistenceImpl;

public class AuthorService {
	
	private BookstorePersistence persistance = new DummyBookstorePersistenceImpl();

	public Collection<Author> getAllAuthors() {
		return persistance.getAllAuthors();
	}
}

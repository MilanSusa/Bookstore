package rs.ac.bg.fon.ai.milansusa.bookstore.services;

import java.util.List;

import rs.ac.bg.fon.ai.milansusa.bookstore.model.Author;
import rs.ac.bg.fon.ai.milansusa.bookstore.persistance.BookstorePersistance;
import rs.ac.bg.fon.ai.milansusa.bookstore.persistance.DummyBookstorePersistanceImpl;

public class AuthorService {
	
	private BookstorePersistance persistance = new DummyBookstorePersistanceImpl();

	public List<Author> getAllAuthors() {
		return persistance.getAllAuthors();
	}
}

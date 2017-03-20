package rs.ac.bg.fon.ai.milansusa.bookstore.services;

import java.util.List;

import rs.ac.bg.fon.ai.milansusa.bookstore.model.Author;
import rs.ac.bg.fon.ai.milansusa.bookstore.persistance.SimpleBookstorePersistance;

public class AuthorService {
	
	private SimpleBookstorePersistance persistance = new SimpleBookstorePersistance();

	public List<Author> getAllAuthors() {
		return persistance.getAllAuthors();
	}
}

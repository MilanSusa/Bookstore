package rs.ac.bg.fon.ai.milansusa.bookstore.services;

import java.util.Collection;
import rs.ac.bg.fon.ai.milansusa.bookstore.model.Author;
import rs.ac.bg.fon.ai.milansusa.bookstore.persistance.BookstorePersistence;
import rs.ac.bg.fon.ai.milansusa.bookstore.persistance.DatabasePersistence;

public class AuthorService {

	private BookstorePersistence persistance = new DatabasePersistence();

	public Collection<Author> getAllAuthors() {
		return persistance.getAllAuthors();
	}

	public Author getAuthor(long authorId) {
		return persistance.getAuthor(authorId);
	}

}

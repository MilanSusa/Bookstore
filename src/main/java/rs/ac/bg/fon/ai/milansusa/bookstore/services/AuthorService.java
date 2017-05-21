package rs.ac.bg.fon.ai.milansusa.bookstore.services;

import rs.ac.bg.fon.ai.milansusa.bookstore.model.Author;
import rs.ac.bg.fon.ai.milansusa.bookstore.persistance.BookstorePersistence;
import rs.ac.bg.fon.ai.milansusa.bookstore.persistance.DatabasePersistence;
import rs.ac.bg.fon.ai.milansusa.bookstore.persistance.Result;

public class AuthorService {

	private BookstorePersistence persistance = new DatabasePersistence();

	public Result<Author> getAllAuthors(int page, int limit, String query) {
		return persistance.getAllAuthors(page, limit, query);
	}

	public Author getAuthor(long authorId) {
		return persistance.getAuthor(authorId);
	}

}

package rs.ac.bg.fon.ai.milansusa.bookstore.services;

import rs.ac.bg.fon.ai.milansusa.bookstore.model.Author;
import rs.ac.bg.fon.ai.milansusa.bookstore.persistance.BookstorePersistence;
import rs.ac.bg.fon.ai.milansusa.bookstore.persistance.HibernatePersistence;
import rs.ac.bg.fon.ai.milansusa.bookstore.persistance.Result;

public class AuthorService {

	private BookstorePersistence persistence = new HibernatePersistence();

	public Result<Author> getAllAuthors(int page, int limit, String query) {
		return persistence.getAllAuthors(page, limit, query);
	}

	public Author getAuthor(long authorId) {
		return persistence.getAuthor(authorId);
	}

}

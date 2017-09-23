package rs.ac.bg.fon.ai.milansusa.bookstore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.bg.fon.ai.milansusa.bookstore.model.Author;
import rs.ac.bg.fon.ai.milansusa.bookstore.persistance.BookstorePersistence;
import rs.ac.bg.fon.ai.milansusa.bookstore.persistance.Result;

@Service
public class AuthorService {

	@Autowired
	private BookstorePersistence persistence;

	public Result<Author> getAllAuthors(int page, int limit, String query) {
		return persistence.getAllAuthors(page, limit, query);
	}

	public Author getAuthor(long authorId) {
		return persistence.getAuthor(authorId);
	}

}

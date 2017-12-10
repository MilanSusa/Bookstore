package rs.ac.bg.fon.ai.milansusa.bookstore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.bg.fon.ai.milansusa.bookstore.dao.AuthorDAO;
import rs.ac.bg.fon.ai.milansusa.bookstore.dao.Result;
import rs.ac.bg.fon.ai.milansusa.bookstore.model.Author;

@Service
public class AuthorService {

	@Autowired
	private AuthorDAO authorDAO;

	public Result<Author> getAllAuthors(int page, int limit, String query) {
		return authorDAO.getAllAuthors(page, limit, query);
	}

	public Author getAuthor(long authorId) {
		return authorDAO.getAuthor(authorId);
	}

}

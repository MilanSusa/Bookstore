package rs.ac.bg.fon.ai.milansusa.bookstore.dao;

import rs.ac.bg.fon.ai.milansusa.bookstore.model.Author;

public interface AuthorDAO {

	Result<Author> getAllAuthors(int page, int limit, String query);

	Author getAuthor(long id);

}

package rs.ac.bg.fon.ai.milansusa.bookstore.dao;

import rs.ac.bg.fon.ai.milansusa.bookstore.model.Book;

public interface BookDAO {

	Result<Book> getAllBooks(int page, int limit, String query);

	Book getBook(long id);
	
}

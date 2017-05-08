package rs.ac.bg.fon.ai.milansusa.bookstore.services;

import rs.ac.bg.fon.ai.milansusa.bookstore.model.Book;
import rs.ac.bg.fon.ai.milansusa.bookstore.persistance.BookstorePersistence;
import rs.ac.bg.fon.ai.milansusa.bookstore.persistance.DatabasePersistence;
import rs.ac.bg.fon.ai.milansusa.bookstore.persistance.Result;

public class BookService {

	private BookstorePersistence persistance = new DatabasePersistence();

	public Result<Book> getAllBooks(int page, int limit) {
		return persistance.getAllBooks(page, limit);
	}

	public Book getBook(long bookId) {
		return persistance.getBook(bookId);
	}

}

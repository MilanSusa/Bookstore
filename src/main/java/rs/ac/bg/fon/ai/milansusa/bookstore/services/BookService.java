package rs.ac.bg.fon.ai.milansusa.bookstore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.bg.fon.ai.milansusa.bookstore.model.Book;
import rs.ac.bg.fon.ai.milansusa.bookstore.persistance.BookstorePersistence;
import rs.ac.bg.fon.ai.milansusa.bookstore.persistance.Result;

@Service
public class BookService {

	@Autowired
	private BookstorePersistence persistance;

	public Result<Book> getAllBooks(int page, int limit, String query) {
		return persistance.getAllBooks(page, limit, query);
	}

	public Book getBook(long bookId) {
		return persistance.getBook(bookId);
	}

}

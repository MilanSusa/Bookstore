package rs.ac.bg.fon.ai.milansusa.bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.bg.fon.ai.milansusa.bookstore.dao.BookDAO;
import rs.ac.bg.fon.ai.milansusa.bookstore.dao.Result;
import rs.ac.bg.fon.ai.milansusa.bookstore.model.Book;

@Service
public class BookService {

	@Autowired
	private BookDAO bookDAO;

	public Result<Book> getAllBooks(int page, int limit, String query) {
		return bookDAO.getAllBooks(page, limit, query);
	}

	public Book getBook(long bookId) {
		return bookDAO.getBook(bookId);
	}

}

package rs.ac.bg.fon.ai.milansusa.bookstore.persistance;

import java.util.List;

import rs.ac.bg.fon.ai.milansusa.bookstore.model.Author;
import rs.ac.bg.fon.ai.milansusa.bookstore.model.Book;
import rs.ac.bg.fon.ai.milansusa.bookstore.model.Review;

public interface BookstorePersistance {

	List<Author> getAllAuthors();

	List<Book> getAllBooks();

	List<Review> getAllReviews();

	List<Review> getBookReviews(long bookId);

}
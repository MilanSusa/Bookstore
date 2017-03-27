package rs.ac.bg.fon.ai.milansusa.bookstore.persistance;

import java.util.Collection;

import rs.ac.bg.fon.ai.milansusa.bookstore.model.Author;
import rs.ac.bg.fon.ai.milansusa.bookstore.model.Book;
import rs.ac.bg.fon.ai.milansusa.bookstore.model.Review;

public interface BookstorePersistance {

	Collection<Author> getAllAuthors();

	Author getAuthor(long id);

	Collection<Book> getAllBooks();
	
	Book getBook(long id);

	Collection<Review> getAllReviews();

	Review getReview(long id);
	
	Collection<Review> getBookReviews(long bookId);

}
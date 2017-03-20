package rs.ac.bg.fon.ai.milansusa.bookstore.persistance;

import java.util.List;
import java.util.Set;

import rs.ac.bg.fon.ai.milansusa.bookstore.model.Author;
import rs.ac.bg.fon.ai.milansusa.bookstore.model.Book;
import rs.ac.bg.fon.ai.milansusa.bookstore.model.Review;

public class DummyBookstorePersistanceImpl implements BookstorePersistance {
	
	private static List<Author> allAuthors;
	private static List<Book> allBooks;
	private static List<Review> allReviews;
	
	static {
		Book book1 = new Book();
		book1.setId(1);
		book1.setTitle("");
		allBooks.add(book1);
		
	}

	/* (non-Javadoc)
	 * @see rs.ac.bg.fon.ai.milansusa.bookstore.persistance.BookstorePersistance#getAllAuthors()
	 */
	@Override
	public List<Author> getAllAuthors() {
		return allAuthors;
	}

	/* (non-Javadoc)
	 * @see rs.ac.bg.fon.ai.milansusa.bookstore.persistance.BookstorePersistance#getAllBooks()
	 */
	@Override
	public List<Book> getAllBooks() {
		return allBooks;
	}

	/* (non-Javadoc)
	 * @see rs.ac.bg.fon.ai.milansusa.bookstore.persistance.BookstorePersistance#getAllReviews()
	 */
	@Override
	public List<Review> getAllReviews() {
		return allReviews;
	}

	/* (non-Javadoc)
	 * @see rs.ac.bg.fon.ai.milansusa.bookstore.persistance.BookstorePersistance#getBookReviews(long)
	 */
	@Override
	public Review getBookReviews(long bookId) {
		return allReviews.get(0);
	}

	
}

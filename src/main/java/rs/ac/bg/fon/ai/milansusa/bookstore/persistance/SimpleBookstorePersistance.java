package rs.ac.bg.fon.ai.milansusa.bookstore.persistance;

import java.util.List;
import java.util.Set;

import rs.ac.bg.fon.ai.milansusa.bookstore.model.Author;
import rs.ac.bg.fon.ai.milansusa.bookstore.model.Book;
import rs.ac.bg.fon.ai.milansusa.bookstore.model.Review;

public class SimpleBookstorePersistance {
	
	private static List<Author> allAuthors;
	private static List<Book> allBooks;
	private static List<Review> allReviews;
	
	static {
		Book book1 = new Book();
		book1.setId(1);
		book1.setTitle("");
		allBooks.add(book1);
		
	}

	public List<Author> getAllAuthors() {
		return allAuthors;
	}

	public List<Book> getAllBooks() {
		return allBooks;
	}

	public List<Review> getAllReviews() {
		return allReviews;
	}

	public Review getBookReviews(long bookId) {
		return allReviews.get(0);
	}

	
}

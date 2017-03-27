package rs.ac.bg.fon.ai.milansusa.bookstore.persistance;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import rs.ac.bg.fon.ai.milansusa.bookstore.model.Author;
import rs.ac.bg.fon.ai.milansusa.bookstore.model.Book;
import rs.ac.bg.fon.ai.milansusa.bookstore.model.Review;
import rs.ac.bg.fon.ai.milansusa.bookstore.model.enums.Gender;

public class DummyBookstorePersistenceImpl implements BookstorePersistence {

	private static Map<Long, Author> allAuthors = new HashMap<>();
	private static Map<Long, Book> allBooks = new HashMap<>();
	private static Map<Long, Review> allReviews = new HashMap<>();

	static {
		Author author1 = new Author();
		author1.setId(1);
		author1.setFirstName("Napoleon");
		author1.setLastName("Hill");
		author1.setGender(Gender.MALE);
		allAuthors.put(1L, author1);

		Author author2 = new Author();
		author2.setId(2);
		author2.setFirstName("Ekhart");
		author2.setLastName("Tole");
		author2.setGender(Gender.MALE);
		allAuthors.put(2L, author2);

		Book book1 = new Book();
		book1.setId(1);
		book1.setTitle("Think and Grow Rich");
		book1.setReleaseYear(1937);
		allBooks.put(1L, book1);

		Book book2 = new Book();
		book2.setId(2);
		book2.setTitle("The Power of Now");
		book2.setReleaseYear(1996);
		allBooks.put(2L, book2);

		Review review1 = new Review();
		review1.setId(1);
		review1.setReviewerFistName("Mika");
		review1.setReviewerLastName("Peric");
		review1.setRank(9.18);
		allReviews.put(1L, review1);

		Review review2 = new Review();
		review2.setId(2);
		review2.setReviewerFistName("Jovana");
		review2.setReviewerLastName("Lazic");
		review2.setRank(8.54);
		allReviews.put(2L, review2);

		Set<Book> authorsBooks1 = new HashSet<>();
		authorsBooks1.add(book1);
		author1.setBooks(authorsBooks1);

		Set<Book> authorsBooks2 = new HashSet<>();
		authorsBooks2.add(book2);
		author2.setBooks(authorsBooks2);

		Set<Author> booksAuthors1 = new HashSet<>();
		booksAuthors1.add(author1);
		book1.setAuthors(booksAuthors1);

		Set<Author> booksAuthors2 = new HashSet<>();
		booksAuthors2.add(author2);
		book2.setAuthors(booksAuthors2);

		Set<Review> booksReviews1 = new HashSet<>();
		booksReviews1.add(review1);
		book1.setReviews(booksReviews1);

		Set<Review> booksReviews2 = new HashSet<>();
		booksReviews2.add(review2);
		book2.setReviews(booksReviews2);
	}

	@Override
	public Collection<Author> getAllAuthors() {
		return allAuthors.values();
	}
	
	@Override
	public Author getAuthor(long id) {
		return allAuthors.get(id);
	}

	@Override
	public Collection<Book> getAllBooks() {
		return allBooks.values();
	}
	
	@Override
	public Book getBook(long id) {
		return allBooks.get(id);
	}

	@Override
	public Collection<Review> getAllReviews() {
		return allReviews.values();
	}
	
	@Override
	public Review getReview(long id) {
		return allReviews.get(id);
	}

	@Override
	public Collection<Review> getBookReviews(long bookId) {
		Book book = getBook(bookId);
		
		if (book != null) {
			return book.getReviews();
		} else {
			throw new RuntimeException("There is no book with ID: " + bookId);
		}
	}

}

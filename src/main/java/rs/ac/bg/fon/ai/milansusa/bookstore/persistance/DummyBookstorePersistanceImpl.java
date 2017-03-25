package rs.ac.bg.fon.ai.milansusa.bookstore.persistance;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import rs.ac.bg.fon.ai.milansusa.bookstore.model.Author;
import rs.ac.bg.fon.ai.milansusa.bookstore.model.Book;
import rs.ac.bg.fon.ai.milansusa.bookstore.model.Review;
import rs.ac.bg.fon.ai.milansusa.bookstore.model.enums.Gender;

public class DummyBookstorePersistanceImpl implements BookstorePersistance {

	private static List<Author> allAuthors = new LinkedList<>();
	private static List<Book> allBooks = new LinkedList<>();
	private static List<Review> allReviews = new LinkedList<>();

	static {
		Author author1 = new Author();
		author1.setId(1);
		author1.setFirstName("Napoleon");
		author1.setLastName("Hill");
		author1.setGender(Gender.MALE);
		allAuthors.add(author1);

		Author author2 = new Author();
		author2.setId(2);
		author2.setFirstName("Ekhart");
		author2.setLastName("Tole");
		author2.setGender(Gender.MALE);
		allAuthors.add(author2);

		Book book1 = new Book();
		book1.setId(1);
		book1.setTitle("Think and Grow Rich");
		book1.setReleaseYear(1937);
		allBooks.add(book1);

		Book book2 = new Book();
		book2.setId(2);
		book2.setTitle("The Power of Now");
		book2.setReleaseYear(1996);
		allBooks.add(book2);

		Review review1 = new Review();
		review1.setId(1);
		review1.setReviewerFistName("Mika");
		review1.setReviewerLastName("Peric");
		review1.setRank(9.18);
		allReviews.add(review1);

		Review review2 = new Review();
		review2.setId(2);
		review2.setReviewerFistName("Jovana");
		review2.setReviewerLastName("Lazic");
		review2.setRank(8.54);
		allReviews.add(review2);

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
	public List<Author> getAllAuthors() {
		return allAuthors;
	}

	@Override
	public List<Book> getAllBooks() {
		return allBooks;
	}

	@Override
	public List<Review> getAllReviews() {
		return allReviews;
	}

	@Override
	public List<Review> getBookReviews(long bookId) {
		List<Review> reviews = new LinkedList<>();
		for (int i = 0; i < allBooks.size(); i++) {
			Book book = allBooks.get(i);
			if (book.getId() == bookId) {
				reviews.addAll(book.getReviews());
				if (reviews.isEmpty()) {
					throw new RuntimeException(
							"There are no reviews for the book with ID: "
									+ bookId);
				}
				return reviews;
			}
		}
		throw new RuntimeException("There is no book with ID: " + bookId);
	}

}

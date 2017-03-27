package rs.ac.bg.fon.ai.milansusa.bookstore.services;

import java.util.Collection;

import rs.ac.bg.fon.ai.milansusa.bookstore.model.Review;
import rs.ac.bg.fon.ai.milansusa.bookstore.persistance.BookstorePersistence;
import rs.ac.bg.fon.ai.milansusa.bookstore.persistance.DummyBookstorePersistenceImpl;

public class ReviewService {

	private BookstorePersistence persistance = new DummyBookstorePersistenceImpl();

	public Collection<Review> getAllReviews() {
		return persistance.getAllReviews();
	}

	public Collection<Review> getReviewsForBook(long bookId) {
		return persistance.getBookReviews(bookId);
	}
}

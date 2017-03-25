package rs.ac.bg.fon.ai.milansusa.bookstore.services;

import java.util.List;

import rs.ac.bg.fon.ai.milansusa.bookstore.model.Review;
import rs.ac.bg.fon.ai.milansusa.bookstore.persistance.BookstorePersistance;
import rs.ac.bg.fon.ai.milansusa.bookstore.persistance.DummyBookstorePersistanceImpl;

public class ReviewService {

	private BookstorePersistance persistance = new DummyBookstorePersistanceImpl();

	public List<Review> getAllReviews() {
		return persistance.getAllReviews();
	}

	public List<Review> getReviewsForBook(long bookId) {
		return persistance.getBookReviews(bookId);
	}
}

package rs.ac.bg.fon.ai.milansusa.bookstore.services;

import java.util.Collection;
import rs.ac.bg.fon.ai.milansusa.bookstore.model.Review;
import rs.ac.bg.fon.ai.milansusa.bookstore.persistance.BookstorePersistence;
import rs.ac.bg.fon.ai.milansusa.bookstore.persistance.DatabasePersistence;

public class ReviewService {

	private BookstorePersistence persistance = new DatabasePersistence();

	public Collection<Review> getAllReviews() {
		return persistance.getAllReviews();
	}

	public Review getReview(long reviewId) {
		return persistance.getReview(reviewId);
	}

	public Collection<Review> getReviewsForBook(long bookId) {
		return persistance.getBookReviews(bookId);
	}

}

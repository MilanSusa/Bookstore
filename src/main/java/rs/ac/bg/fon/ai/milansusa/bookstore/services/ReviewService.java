package rs.ac.bg.fon.ai.milansusa.bookstore.services;

import rs.ac.bg.fon.ai.milansusa.bookstore.model.Review;
import rs.ac.bg.fon.ai.milansusa.bookstore.persistance.BookstorePersistence;
import rs.ac.bg.fon.ai.milansusa.bookstore.persistance.HibernatePersistence;
import rs.ac.bg.fon.ai.milansusa.bookstore.persistance.Result;

public class ReviewService {

	private BookstorePersistence persistence = new HibernatePersistence();

	public Result<Review> getAllReviews(int page, int limit, String query) {
		return persistence.getAllReviews(page, limit, query);
	}

	public Review getReview(long reviewId) {
		return persistence.getReview(reviewId);
	}

	public Result<Review> getReviewsForBook(long bookId, int page, int limit,
			String query) {
		return persistence.getBookReviews(bookId, page, limit, query);
	}

}

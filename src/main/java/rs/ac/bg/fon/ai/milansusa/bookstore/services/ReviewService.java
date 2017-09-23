package rs.ac.bg.fon.ai.milansusa.bookstore.services;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;

import rs.ac.bg.fon.ai.milansusa.bookstore.model.Review;
import rs.ac.bg.fon.ai.milansusa.bookstore.persistance.BookstorePersistence;
import rs.ac.bg.fon.ai.milansusa.bookstore.persistance.Result;

@Service
public class ReviewService {

	@Autowired
	private BookstorePersistence persistence;

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

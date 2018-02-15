package rs.ac.bg.fon.ai.milansusa.bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.bg.fon.ai.milansusa.bookstore.dao.Result;
import rs.ac.bg.fon.ai.milansusa.bookstore.dao.ReviewDAO;
import rs.ac.bg.fon.ai.milansusa.bookstore.model.Review;

@Service
public class ReviewService {

	@Autowired
	private ReviewDAO reviewDAO;

	public Result<Review> getAllReviews(int page, int limit, String query) {
		return reviewDAO.getAllReviews(page, limit, query);
	}

	public Review getReview(long reviewId) {
		return reviewDAO.getReview(reviewId);
	}

	public Result<Review> getReviewsForBook(long bookId, int page, int limit, String query) {
		return reviewDAO.getBookReviews(bookId, page, limit, query);
	}

}

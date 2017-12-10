package rs.ac.bg.fon.ai.milansusa.bookstore.dao;

import rs.ac.bg.fon.ai.milansusa.bookstore.model.Review;

public interface ReviewDAO {

	Result<Review> getAllReviews(int page, int limit, String query);

	Review getReview(long id);

	Result<Review> getBookReviews(long bookId, int page, int limit, String query);

}

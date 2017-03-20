package rs.ac.bg.fon.ai.milansusa.bookstore.services;

import java.util.List;

import rs.ac.bg.fon.ai.milansusa.bookstore.model.Review;
import rs.ac.bg.fon.ai.milansusa.bookstore.persistance.SimpleBookstorePersistance;

public class ReviewService {
	
	private SimpleBookstorePersistance persistance = new SimpleBookstorePersistance();

	public List<Review> getAllReviews() {
		return persistance.getAllReviews();
	}
	
	public Review getReviewsForBook(long bookId) {
		return persistance.getBookReviews(bookId);
	}
}

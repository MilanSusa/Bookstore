package rs.ac.bg.fon.ai.milansusa.bookstore.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import rs.ac.bg.fon.ai.milansusa.bookstore.dao.Result;
import rs.ac.bg.fon.ai.milansusa.bookstore.dao.ReviewDAOImpl;
import rs.ac.bg.fon.ai.milansusa.bookstore.model.Review;

@RunWith(SpringRunner.class)
public class ReviewServiceTest {

	@TestConfiguration
	static class ReviewServiceTestContextConfiguration {

		@Bean
		public ReviewService reviewService() {
			return new ReviewService();
		}

	}

	@Autowired
	private ReviewService reviewService;
	@MockBean
	private ReviewDAOImpl reiewDAOImpl;

	private final long id = 1L;
	private final String reveiwerFirstName = "Milan";
	private final String reviewerLastName = "Susa";
	private final double rank = 9;

	@Before
	public void setUp() {
		Review review = new Review(this.id, this.reveiwerFirstName, this.reviewerLastName, this.rank);
		when(reviewService.getReview(1)).thenReturn(review);
		when(reviewService.getAllReviews(1, 1, "")).thenReturn(new Result<>(Arrays.asList(review), 1));
	}

	@Test
	public void getReview_whenIdFound_ShouldReturnReview() {
		Review actualReview = reviewService.getReview(1);
		assertReview(actualReview);
	}

	@Test
	public void getAllReviews_shouldReturnReviews() {
		Result<Review> actualReviewsResult = reviewService.getAllReviews(1, 1, "");
		actualReviewsResult.getData().forEach(actualReview -> assertReview(actualReview));
	}

	private void assertReview(Review actualReview) {
		assertEquals(this.id, actualReview.getId());
		assertEquals(this.reveiwerFirstName, actualReview.getReviewerFirstName());
		assertEquals(this.reviewerLastName, actualReview.getReviewerLastName());
		assertEquals(String.valueOf(this.rank), String.valueOf(actualReview.getRank()));
	}

}
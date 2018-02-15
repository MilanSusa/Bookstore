package rs.ac.bg.fon.ai.milansusa.bookstore.rest;

import java.util.Collection;
import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.bg.fon.ai.milansusa.bookstore.dao.Result;
import rs.ac.bg.fon.ai.milansusa.bookstore.model.Review;
import rs.ac.bg.fon.ai.milansusa.bookstore.rest.json.ReviewJsonSerializer;
import rs.ac.bg.fon.ai.milansusa.bookstore.service.ReviewService;

@RestController
@RequestMapping("/webapi/reviews")
public class ReviewResource {

	@Autowired
	private ReviewService reviewService;

	@GetMapping
	public String getReviews(@RequestParam(value = "limit", required = false) Integer limit,
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "query", required = false) String query) {
		if (limit == null || limit == 0) {
			limit = 10;
		}
		if (page == null || page == 0) {
			page = 1;
		}
		if (query == null) {
			query = "";
		}
		Result<Review> result = reviewService.getAllReviews(page, limit, query);
		String response = ReviewJsonSerializer.serializeReviews(result);
		return response;
	}

	@GetMapping("/{id}")
	public String getReview(@PathVariable("id") long reviewId) {
		Review review = reviewService.getReview(reviewId);
		Collection<Review> reviewHolder = new LinkedList<>();
		reviewHolder.add(review);
		String response = ReviewJsonSerializer.serializeReviews(new Result<>(reviewHolder, 1));
		return response;
	}

}

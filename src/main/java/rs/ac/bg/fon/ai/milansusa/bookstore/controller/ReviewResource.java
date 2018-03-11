package rs.ac.bg.fon.ai.milansusa.bookstore.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.bg.fon.ai.milansusa.bookstore.controller.json.ReviewJsonSerializer;
import rs.ac.bg.fon.ai.milansusa.bookstore.dao.Result;
import rs.ac.bg.fon.ai.milansusa.bookstore.model.Review;
import rs.ac.bg.fon.ai.milansusa.bookstore.service.ReviewService;

@RestController
@RequestMapping("/webapi/reviews")
public class ReviewResource {

	@Autowired
	private ReviewService reviewService;

	@GetMapping
	public String getReviews(@RequestParam(value = "limit", required = false, defaultValue = "10") Integer limit,
			@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
			@RequestParam(value = "query", required = false, defaultValue = "") String query) {
		Result<Review> result = reviewService.getAllReviews(page, limit, query);
		return ReviewJsonSerializer.serializeReviews(result);
	}

	@GetMapping("/{id}")
	public String getReview(@PathVariable("id") long reviewId) {
		Review review = reviewService.getReview(reviewId);
		return ReviewJsonSerializer.serializeReviews(new Result<>(Arrays.asList(review), 1));
	}

}

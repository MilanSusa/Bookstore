package rs.ac.bg.fon.ai.milansusa.bookstore.rest;

import java.util.Collection;
import java.util.LinkedList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import rs.ac.bg.fon.ai.milansusa.bookstore.config.DIConfig;
import rs.ac.bg.fon.ai.milansusa.bookstore.model.Review;
import rs.ac.bg.fon.ai.milansusa.bookstore.persistance.Result;
import rs.ac.bg.fon.ai.milansusa.bookstore.rest.json.ReviewJsonSerializer;
import rs.ac.bg.fon.ai.milansusa.bookstore.services.ReviewService;

@Path("/reviews")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Component
public class ReviewResource {

	@Autowired
	private ReviewService reviewService = DIConfig.ctx
			.getBean(ReviewService.class);

	@GET
	public String getReviews(@QueryParam("limit") int limit,
			@QueryParam("page") int page, @QueryParam("query") String query) {
		if (limit == 0) {
			limit = 10;
		}
		if (page == 0) {
			page = 1;
		}
		Result<Review> result = reviewService.getAllReviews(page, limit, query);
		String response = ReviewJsonSerializer.serializeReviews(result);
		return response;
	}

	@GET
	@Path("/{id}")
	public String getReview(@PathParam("id") long reviewId) {
		Review review = reviewService.getReview(reviewId);
		Collection<Review> reviewHolder = new LinkedList<>();
		reviewHolder.add(review);
		String response = ReviewJsonSerializer.serializeReviews(new Result<>(
				reviewHolder, 1));
		return response;
	}

}

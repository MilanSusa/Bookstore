package rs.ac.bg.fon.ai.milansusa.bookstore.rest;

import java.util.Collection;
import java.util.LinkedList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import rs.ac.bg.fon.ai.milansusa.bookstore.model.Review;
import rs.ac.bg.fon.ai.milansusa.bookstore.rest.json.ReviewJsonSerializer;
import rs.ac.bg.fon.ai.milansusa.bookstore.services.ReviewService;

@Path("/reviews")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ReviewResource {

	private ReviewService reviewService = new ReviewService();

	@GET
	public String getReviews() {
		Collection<Review> allReviews = reviewService.getAllReviews();
		String response = ReviewJsonSerializer.serializeReviews(allReviews);
		return response;
	}

	@GET
	@Path("/{id}")
	public String getReview(@PathParam("id") long reviewId) {
		Review review = reviewService.getReview(reviewId);
		Collection<Review> reviewHolder = new LinkedList<>();
		reviewHolder.add(review);
		String response = ReviewJsonSerializer.serializeReviews(reviewHolder);
		return response;
	}

}

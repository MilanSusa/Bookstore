package rs.ac.bg.fon.ai.milansusa.bookstore.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import rs.ac.bg.fon.ai.milansusa.bookstore.services.ReviewService;

@Path("/reviews")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ReviewResource {

	private ReviewService reviewService = new ReviewService();

	@GET
	public String getReviews() {
		return "[]";
	}
}

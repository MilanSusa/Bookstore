package rs.ac.bg.fon.ai.milansusa.rest.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import rs.ac.bg.fon.ai.milansusa.rest.service.ReviewService;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ReviewResource {

	ReviewService ReviewService = new ReviewService();

	@GET
	public String getReviews(@PathParam("bookId") long bookId) {
		return ReviewService.getAllReviews(bookId);
	}
}

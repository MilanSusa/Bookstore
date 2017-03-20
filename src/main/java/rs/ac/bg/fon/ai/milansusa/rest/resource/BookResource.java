package rs.ac.bg.fon.ai.milansusa.rest.resource;

import javax.ws.rs.Consumes;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import rs.ac.bg.fon.ai.milansusa.rest.service.BookService;

@Path("/books")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookResource {

	BookService bookService = new BookService();

	@GET
	public String getBooks() {
		return bookService.getAllBooks();
	}

	@Path("/{bookId}/reviews")
	public ReviewResource getReviewResource() {
		return new ReviewResource();
	}
}

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

import rs.ac.bg.fon.ai.milansusa.bookstore.model.Book;
import rs.ac.bg.fon.ai.milansusa.bookstore.model.Review;
import rs.ac.bg.fon.ai.milansusa.bookstore.persistance.Result;
import rs.ac.bg.fon.ai.milansusa.bookstore.rest.json.BookJsonSerializer;
import rs.ac.bg.fon.ai.milansusa.bookstore.rest.json.ReviewJsonSerializer;
import rs.ac.bg.fon.ai.milansusa.bookstore.services.BookService;
import rs.ac.bg.fon.ai.milansusa.bookstore.services.ReviewService;

@Path("/books")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookResource {

	private BookService bookService = new BookService();
	private ReviewService reviewService = new ReviewService();

	@GET
	public String getBooks(@QueryParam("limit") int limit, @QueryParam("page") int page) {
		// setting default values if 0
		if (limit == 0) {
			limit = 10;
		}
		if (page == 0) {
			limit = 1;
		}
		
		
		Result<Book> result = bookService.getAllBooks(page, limit);
		String response = BookJsonSerializer.serializeBooks(result.getData());
		return response;
	}

	@GET
	@Path("/{id}")
	public String getBook(@PathParam("id") long bookId) {
		Book book = bookService.getBook(bookId);
		Collection<Book> bookHolder = new LinkedList<Book>();
		bookHolder.add(book);
		String response = BookJsonSerializer.serializeBooks(bookHolder);
		return response;
	}

	@GET
	@Path("/{id}/reviews")
	public String getBookReviews(@PathParam("id") long bookId) {
		Collection<Review> allBookReviews = reviewService
				.getReviewsForBook(bookId);
		String response = ReviewJsonSerializer.serializeReviews(allBookReviews);
		return response;
	}

}

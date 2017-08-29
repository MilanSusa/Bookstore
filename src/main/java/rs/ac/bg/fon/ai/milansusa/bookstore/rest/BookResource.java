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
@Component
public class BookResource {

	@Autowired
	private BookService bookService = DIConfig.ctx.getBean(BookService.class);
	@Autowired
	private ReviewService reviewService = DIConfig.ctx
			.getBean(ReviewService.class);

	@GET
	public String getBooks(@QueryParam("limit") int limit,
			@QueryParam("page") int page, @QueryParam("query") String query) {
		if (limit == 0) {
			limit = 10;
		}
		if (page == 0) {
			page = 1;
		}
		Result<Book> result = bookService.getAllBooks(page, limit, query);
		String response = BookJsonSerializer.serializeBooks(result);
		return response;
	}

	@GET
	@Path("/{id}")
	public String getBook(@PathParam("id") long bookId) {
		Book book = bookService.getBook(bookId);
		Collection<Book> bookHolder = new LinkedList<Book>();
		bookHolder.add(book);
		String response = BookJsonSerializer.serializeBooks(new Result<>(
				bookHolder, 1));
		return response;
	}

	@GET
	@Path("/{id}/reviews")
	public String getBookReviews(@PathParam("id") long bookId,
			@QueryParam("limit") int limit, @QueryParam("page") int page,
			@QueryParam("query") String query) {
		if (limit == 0) {
			limit = 10;
		}
		if (page == 0) {
			page = 1;
		}
		Result<Review> result = reviewService.getReviewsForBook(bookId, page,
				limit, query);
		String response = ReviewJsonSerializer.serializeReviews(result);
		return response;
	}

}

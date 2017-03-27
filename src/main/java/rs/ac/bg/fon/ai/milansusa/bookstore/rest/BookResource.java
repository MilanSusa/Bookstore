package rs.ac.bg.fon.ai.milansusa.bookstore.rest;

import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import rs.ac.bg.fon.ai.milansusa.bookstore.model.Book;
import rs.ac.bg.fon.ai.milansusa.bookstore.model.Review;
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
	public String getBooks() {
		Collection<Book> allBooks = bookService.getAllBooks();
		String response = BookJsonSerializer.serializeBooks(allBooks);
		return response;
	}

	@GET
	@Path("/{id}/reviews")
	public String getBookReviews(@PathParam("id") long bookId) {
		Collection<Review> allBookReviews = reviewService.getReviewsForBook(bookId);
		String response = ReviewJsonSerializer.serializeReviews(allBookReviews);
		return response;
	}
}

package rs.ac.bg.fon.ai.milansusa.bookstore.rest;

import java.util.Collection;
import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.bg.fon.ai.milansusa.bookstore.model.Book;
import rs.ac.bg.fon.ai.milansusa.bookstore.model.Review;
import rs.ac.bg.fon.ai.milansusa.bookstore.persistance.Result;
import rs.ac.bg.fon.ai.milansusa.bookstore.rest.json.BookJsonSerializer;
import rs.ac.bg.fon.ai.milansusa.bookstore.rest.json.ReviewJsonSerializer;
import rs.ac.bg.fon.ai.milansusa.bookstore.services.BookService;
import rs.ac.bg.fon.ai.milansusa.bookstore.services.ReviewService;

@RestController
@RequestMapping("/webapi/books")
public class BookResource {

	@Autowired
	private BookService bookService;
	@Autowired
	private ReviewService reviewService;

	@RequestMapping(method = RequestMethod.GET)
	public String getBooks(
			@RequestParam(value = "limit", required = false) Integer limit,
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
		Result<Book> result = bookService.getAllBooks(page, limit, query);
		String response = BookJsonSerializer.serializeBooks(result);
		return response;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String getBook(@PathVariable("id") long bookId) {
		Book book = bookService.getBook(bookId);
		Collection<Book> bookHolder = new LinkedList<Book>();
		bookHolder.add(book);
		String response = BookJsonSerializer.serializeBooks(new Result<>(
				bookHolder, 1));
		return response;
	}

	@RequestMapping(value = "/{id}/reviews", method = RequestMethod.GET)
	public String getBookReviews(@PathVariable("id") long bookId,
			@RequestParam(value = "limit", required = false) Integer limit,
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
		Result<Review> result = reviewService.getReviewsForBook(bookId, page,
				limit, query);
		String response = ReviewJsonSerializer.serializeReviews(result);
		return response;
	}

}

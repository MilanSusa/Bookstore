package rs.ac.bg.fon.ai.milansusa.bookstore.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.bg.fon.ai.milansusa.bookstore.controller.json.BookJsonSerializer;
import rs.ac.bg.fon.ai.milansusa.bookstore.controller.json.ReviewJsonSerializer;
import rs.ac.bg.fon.ai.milansusa.bookstore.dao.Result;
import rs.ac.bg.fon.ai.milansusa.bookstore.model.Book;
import rs.ac.bg.fon.ai.milansusa.bookstore.model.Review;
import rs.ac.bg.fon.ai.milansusa.bookstore.service.BookService;
import rs.ac.bg.fon.ai.milansusa.bookstore.service.ReviewService;

@RestController
@RequestMapping("/webapi/books")
public class BookResource {

	@Autowired
	private BookService bookService;
	@Autowired
	private ReviewService reviewService;

	@GetMapping
	public String getBooks(@RequestParam(value = "limit", required = false, defaultValue = "10") Integer limit,
			@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
			@RequestParam(value = "query", required = false, defaultValue = "") String query) {
		Result<Book> result = bookService.getAllBooks(page, limit, query);
		return BookJsonSerializer.serializeBooks(result);
	}

	@GetMapping("/{id}")
	public String getBook(@PathVariable("id") long bookId) {
		Book book = bookService.getBook(bookId);
		return BookJsonSerializer.serializeBooks(new Result<>(Arrays.asList(book), 1));
	}

	@GetMapping("/{id}/reviews")
	public String getReviewsForBook(@PathVariable("id") long bookId,
			@RequestParam(value = "limit", required = false, defaultValue = "10") Integer limit,
			@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
			@RequestParam(value = "query", required = false, defaultValue = "") String query) {
		Result<Review> result = reviewService.getReviewsForBook(bookId, page, limit, query);
		return ReviewJsonSerializer.serializeReviews(result);
	}

}

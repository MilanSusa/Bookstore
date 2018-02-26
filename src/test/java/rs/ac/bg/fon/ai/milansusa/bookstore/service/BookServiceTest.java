package rs.ac.bg.fon.ai.milansusa.bookstore.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import rs.ac.bg.fon.ai.milansusa.bookstore.dao.BookDAOImpl;
import rs.ac.bg.fon.ai.milansusa.bookstore.dao.Result;
import rs.ac.bg.fon.ai.milansusa.bookstore.model.Book;

@RunWith(SpringRunner.class)
public class BookServiceTest {

	@TestConfiguration
	static class BookServiceTestContextConfiguration {
		@Bean
		public BookService bookService() {
			return new BookService();
		}
	}

	@Autowired
	private BookService bookService;
	@MockBean
	private BookDAOImpl bookDAOImpl;

	private final long id = 1L;
	private final String title = "Think and Grow Rich";
	private final int year = 1937;

	@Before
	public void setUp() {
		Book book = new Book(this.id, this.title, this.year);
		when(bookService.getBook(1)).thenReturn(book);
		when(bookService.getAllBooks(1, 1, "")).thenReturn(new Result<>(Arrays.asList(book), 1));
	}

	@Test
	public void getBook_whenIdFound_ShouldReturnBook() {
		Book actualBook = bookService.getBook(1);
		assertEquals(this.id, actualBook.getId());
		assertEquals(this.title, actualBook.getTitle());
		assertEquals(this.year, actualBook.getReleaseYear());
	}

	@Test
	public void getAllBooks_shouldReturnBooks() {
		Result<Book> actualBooksResult = bookService.getAllBooks(1, 1, "");
		actualBooksResult.getData().forEach(i -> {
			assertEquals(this.id, i.getId());
			assertEquals(this.title, i.getTitle());
			assertEquals(this.year, i.getReleaseYear());
		});
	}

}

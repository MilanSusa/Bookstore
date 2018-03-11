package rs.ac.bg.fon.ai.milansusa.bookstore.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import rs.ac.bg.fon.ai.milansusa.bookstore.controller.BookResource;
import rs.ac.bg.fon.ai.milansusa.bookstore.service.BookService;
import rs.ac.bg.fon.ai.milansusa.bookstore.service.ReviewService;

@RunWith(SpringRunner.class)
@WebMvcTest(BookResource.class)
public class BookResourceTest {

	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private BookService bookService;
	@MockBean
	private ReviewService reviewService;

	@Test
	public void getBooks_whenUsernameAndPasswordNotProvided_shouldReturnUnauthorized() throws Exception {
		this.mockMvc.perform(get("/webapi/books").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isUnauthorized());
	}

	@Test
	public void getBook_whenUsernameAndPasswordNotProvided_shouldReturnUnauthorized() throws Exception {
		this.mockMvc.perform(get("/webapi/books/1").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isUnauthorized());
	}

}
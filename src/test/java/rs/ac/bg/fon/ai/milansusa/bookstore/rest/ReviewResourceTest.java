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

import rs.ac.bg.fon.ai.milansusa.bookstore.controller.ReviewResource;
import rs.ac.bg.fon.ai.milansusa.bookstore.service.ReviewService;

@RunWith(SpringRunner.class)
@WebMvcTest(ReviewResource.class)
public class ReviewResourceTest {

	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private ReviewService reviewService;

	@Test
	public void getReveiws_whenUsernameAndPasswordNotProvided_shouldReturnUnauthorized() throws Exception {
		this.mockMvc.perform(get("/webapi/reviews").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isUnauthorized());
	}

	@Test
	public void getReview_whenUsernameAndPasswordNotProvided_shouldReturnUnauthorized() throws Exception {
		this.mockMvc.perform(get("/webapi/books/1").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isUnauthorized());
	}

}

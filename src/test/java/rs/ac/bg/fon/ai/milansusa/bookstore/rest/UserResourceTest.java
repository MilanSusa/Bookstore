package rs.ac.bg.fon.ai.milansusa.bookstore.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import rs.ac.bg.fon.ai.milansusa.bookstore.service.UserService;

@RunWith(SpringRunner.class)
@WebMvcTest(UserResource.class)
public class UserResourceTest {

	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private UserService userService;

	@Test
	public void saveUser_whenUsernameAndPasswordNotProvided_shouldReturnUnauthorized() throws Exception {
		this.mockMvc.perform(post("webapi/registration").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isUnauthorized());
	}

}

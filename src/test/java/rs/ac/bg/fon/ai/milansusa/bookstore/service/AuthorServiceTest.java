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

import rs.ac.bg.fon.ai.milansusa.bookstore.dao.AuthorDAOImpl;
import rs.ac.bg.fon.ai.milansusa.bookstore.dao.Result;
import rs.ac.bg.fon.ai.milansusa.bookstore.model.Author;
import rs.ac.bg.fon.ai.milansusa.bookstore.model.Gender;

@RunWith(SpringRunner.class)
public class AuthorServiceTest {

	@TestConfiguration
	static class AuthorServiceTestContextConfiguration {
		@Bean
		public AuthorService authorService() {
			return new AuthorService();
		}
	}

	@Autowired
	private AuthorService authorService;
	@MockBean
	private AuthorDAOImpl authorDAOImpl;

	private final long id = 1L;
	private final String firstName = "Napoleon";
	private final String lastName = "Hill";
	private final Gender gender = Gender.MALE;

	@Before
	public void setUp() {
		Author author = new Author(this.id, this.firstName, this.lastName, this.gender);
		when(authorService.getAuthor(1)).thenReturn(author);
		when(authorService.getAllAuthors(1, 1, "")).thenReturn(new Result<>(Arrays.asList(author), 1));
	}

	@Test
	public void getAuthor_whenIdFound_ShouldReturnAuthor() {
		Author actualAuthor = authorService.getAuthor(1);
		assertEquals(this.id, actualAuthor.getId());
		assertEquals(this.firstName, actualAuthor.getFirstName());
		assertEquals(this.lastName, actualAuthor.getLastName());
		assertEquals(String.valueOf(this.gender), String.valueOf(actualAuthor.getGender()));
	}

	@Test
	public void getAllAuthors_shouldReturnAuthors() {
		Result<Author> actualAuthorsResult = authorService.getAllAuthors(1, 1, "");
		actualAuthorsResult.getData().forEach(i -> {
			assertEquals(this.id, i.getId());
			assertEquals(this.firstName, i.getFirstName());
			assertEquals(this.lastName, i.getLastName());
			assertEquals(String.valueOf(this.gender), String.valueOf(i.getGender()));
		});
	}

}

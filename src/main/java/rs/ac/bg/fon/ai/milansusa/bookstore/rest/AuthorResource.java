package rs.ac.bg.fon.ai.milansusa.bookstore.rest;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.bg.fon.ai.milansusa.bookstore.dao.Result;
import rs.ac.bg.fon.ai.milansusa.bookstore.model.Author;
import rs.ac.bg.fon.ai.milansusa.bookstore.rest.json.AuthorJsonSerializer;
import rs.ac.bg.fon.ai.milansusa.bookstore.service.AuthorService;

@RestController
@RequestMapping("/webapi/authors")
public class AuthorResource {

	@Autowired
	private AuthorService authorService;

	@GetMapping
	public String getAuthors(@RequestParam(value = "limit", required = false) Integer limit,
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
		Result<Author> result = authorService.getAllAuthors(page, limit, query);
		return AuthorJsonSerializer.serializeAuthors(result);
	}

	@GetMapping("/{id}")
	public String getAuthor(@PathVariable("id") long authorId) {
		Author author = authorService.getAuthor(authorId);
		return AuthorJsonSerializer.serializeAuthors(new Result<>(Arrays.asList(author), 1));
	}

}

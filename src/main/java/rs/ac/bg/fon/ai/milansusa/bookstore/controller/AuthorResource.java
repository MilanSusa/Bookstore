package rs.ac.bg.fon.ai.milansusa.bookstore.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.bg.fon.ai.milansusa.bookstore.controller.json.AuthorJsonSerializer;
import rs.ac.bg.fon.ai.milansusa.bookstore.dao.Result;
import rs.ac.bg.fon.ai.milansusa.bookstore.model.Author;
import rs.ac.bg.fon.ai.milansusa.bookstore.service.AuthorService;

@RestController
@RequestMapping("/webapi/authors")
public class AuthorResource {

	@Autowired
	private AuthorService authorService;

	@GetMapping
	public String getAuthors(@RequestParam(value = "limit", required = false, defaultValue = "10") Integer limit,
			@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
			@RequestParam(value = "query", required = false, defaultValue = "") String query) {
		Result<Author> result = authorService.getAllAuthors(page, limit, query);
		return AuthorJsonSerializer.serializeAuthors(result);
	}

	@GetMapping("/{id}")
	public String getAuthor(@PathVariable("id") long authorId) {
		Author author = authorService.getAuthor(authorId);
		return AuthorJsonSerializer.serializeAuthors(new Result<>(Arrays.asList(author), 1));
	}

}
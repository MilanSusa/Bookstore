package rs.ac.bg.fon.ai.milansusa.bookstore.rest;

import java.util.Collection;
import java.util.LinkedList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import rs.ac.bg.fon.ai.milansusa.bookstore.model.Author;
import rs.ac.bg.fon.ai.milansusa.bookstore.persistance.Result;
import rs.ac.bg.fon.ai.milansusa.bookstore.rest.json.AuthorJsonSerializer;
import rs.ac.bg.fon.ai.milansusa.bookstore.services.AuthorService;

@Path("/authors")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthorResource {

	private AuthorService authorService = new AuthorService();

	@GET
	public String getAuthors(@QueryParam("limit") int limit,
			@QueryParam("page") int page) {
		if (limit == 0) {
			limit = 10;
		}
		if (page == 0) {
			page = 1;
		}
		Result<Author> result = authorService.getAllAuthors(page, limit);
		String response = AuthorJsonSerializer.serializeAuthors(result);
		return response;
	}

	@GET
	@Path("/{id}")
	public String getAuthor(@PathParam("id") long authorId) {
		Author author = authorService.getAuthor(authorId);
		Collection<Author> authorHolder = new LinkedList<>();
		authorHolder.add(author);
		String response = AuthorJsonSerializer.serializeAuthors(new Result<>(
				authorHolder, 1));
		return response;
	}

}

package rs.ac.bg.fon.ai.milansusa.bookstore.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import rs.ac.bg.fon.ai.milansusa.bookstore.model.Author;
import rs.ac.bg.fon.ai.milansusa.bookstore.rest.json.AuthorJsonSerializer;
import rs.ac.bg.fon.ai.milansusa.bookstore.services.AuthorService;

@Path("/authors")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthorResource {

	private AuthorService authorService = new AuthorService();
	
	@GET
	public String getAuthors() {
/*		return "[" 
				+ "{" 
				+ "\"id\": 1," 
				+ "\"firstName\": \"Napoleon\","
				+ "\"lasName\": \"Hill\"," 
				+ "\"gender\": \"MALE\"" 
				+ "},"
				+ "{" 
				+ "\"id\": 2," 
				+ "\"firstName\": \"Ekhart\","
				+ "\"lasName\": \"Tole\"," 
				+ "\"gender\": \"MALE\"" 
				+ "}" 
				+ "]";*/
		
		List<Author> allAuthors = authorService.getAllAuthors();
		String response = AuthorJsonSerializer.serializeAuthors(allAuthors);
		return response;
	}
	
}

package rs.ac.bg.fon.ai.milansusa.bookstore.rest.json;

import java.util.Collection;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import rs.ac.bg.fon.ai.milansusa.bookstore.model.Author;

public class AuthorJsonSerializer {

	public static String serializeAuthors(Collection<Author> allAuthors) {
		JsonArray authorsArray = new JsonArray();
		for (Author author : allAuthors) {
			JsonObject authorJson = new JsonObject();
			authorJson.addProperty("id", String.valueOf(author.getId()));
			authorJson.addProperty("firstName", author.getFirstName());
			authorJson.addProperty("lastName", author.getLastName());
			authorJson
					.addProperty("gender", String.valueOf(author.getGender()));
			authorsArray.add(authorJson);
		}
		return authorsArray.toString();
	}

}

package rs.ac.bg.fon.ai.milansusa.bookstore.rest.json;

import java.util.List;

import rs.ac.bg.fon.ai.milansusa.bookstore.model.Author;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class AuthorJsonSerializer {

	public static String serializeAuthors(List<Author> authors) {
		JsonArray authorsArray = new JsonArray();
		for (Author author : authors) {
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

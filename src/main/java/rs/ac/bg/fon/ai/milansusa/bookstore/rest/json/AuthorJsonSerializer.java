package rs.ac.bg.fon.ai.milansusa.bookstore.rest.json;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import rs.ac.bg.fon.ai.milansusa.bookstore.model.Author;
import rs.ac.bg.fon.ai.milansusa.bookstore.persistance.Result;

public class AuthorJsonSerializer {

	public static String serializeAuthors(Result<Author> allAuthors) {
		JsonObject result = new JsonObject();
		JsonObject pagination = new JsonObject();
		pagination.addProperty("maxResults",
				String.valueOf(allAuthors.getMaxResults()));
		result.add("pagination", pagination);
		JsonArray authorsArray = new JsonArray();
		for (Author author : allAuthors.getData()) {
			JsonObject authorJson = new JsonObject();
			authorJson.addProperty("id", String.valueOf(author.getId()));
			authorJson.addProperty("firstName", author.getFirstName());
			authorJson.addProperty("lastName", author.getLastName());
			authorJson
					.addProperty("gender", String.valueOf(author.getGender()));
			authorsArray.add(authorJson);
		}
		result.add("data", authorsArray);
		return result.toString();
	}

}

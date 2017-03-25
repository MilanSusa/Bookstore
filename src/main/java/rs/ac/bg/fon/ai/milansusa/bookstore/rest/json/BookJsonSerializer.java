package rs.ac.bg.fon.ai.milansusa.bookstore.rest.json;

import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import rs.ac.bg.fon.ai.milansusa.bookstore.model.Book;

public class BookJsonSerializer {

	public static String serializeBooks(List<Book> books) {
		JsonArray booksArray = new JsonArray();
		for (Book book : books) {
			JsonObject bookJson = new JsonObject();
			bookJson.addProperty("id", String.valueOf(book.getId()));
			bookJson.addProperty("title", book.getTitle());
			bookJson.addProperty("releaseYear",
					String.valueOf(book.getReleaseYear()));
			booksArray.add(bookJson);
		}
		return booksArray.toString();
	}

}

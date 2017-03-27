package rs.ac.bg.fon.ai.milansusa.bookstore.rest.json;

import java.util.Collection;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import rs.ac.bg.fon.ai.milansusa.bookstore.model.Book;

public class BookJsonSerializer {

	public static String serializeBooks(Collection<Book> allBooks) {
		JsonArray booksArray = new JsonArray();
		for (Book book : allBooks) {
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

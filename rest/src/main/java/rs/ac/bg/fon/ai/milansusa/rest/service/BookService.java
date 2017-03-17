package rs.ac.bg.fon.ai.milansusa.rest.service;

public class BookService {

	public String getAllBooks() {
		return "["
				+ "{"
				+ "\"id\": 1,"
				+ "\"title\": \"Think and Grow Rich\","
				+ "\"releaseYear\": 1937"
				+ "},"
				+ "{"
				+ "\"id\": 2,"
				+ "\"title\": \"The Power of Now\","
				+ "\"releaseYear\": 1997"
				+ "}"
				+ "]";
	}
}

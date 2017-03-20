package rs.ac.bg.fon.ai.milansusa.rest.service;

public class ReviewService {

	public String getAllReviews(long bookId) {
		if (bookId == 1) {
			return "[" 
					+ "{" 
					+ "\"id\": 1, "
					+ "\"reviewerFirstName\": \"Mika\", "
					+ "\"reviewerLastName\": \"Peric\", " 
					+ "\"rank\": 9.18 "
					+ "}" 
					+ "]";
		}
		if (bookId == 2) {
			return "[" 
					+ "{ " 
					+ "\"id\": 2,"
					+ "\"reviewerFirstName\":\"Jovana\", "
					+ "\"reviewerLastName\": \"Lazic\", " 
					+ "\"rank\": 8.54 "
					+ "}" 
					+ "]";
		}
		return null;
	}
}

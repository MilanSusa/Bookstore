package rs.ac.bg.fon.ai.milansusa.bookstore.rest.json;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import rs.ac.bg.fon.ai.milansusa.bookstore.model.Review;
import rs.ac.bg.fon.ai.milansusa.bookstore.persistance.Result;

public class ReviewJsonSerializer {

	public static String serializeReviews(Result<Review> allReviews) {
		JsonObject result = new JsonObject();
		JsonObject pagination = new JsonObject();
		pagination.addProperty("maxResults",
				String.valueOf(allReviews.getMaxResults()));
		result.add("pagination", pagination);
		JsonArray reviewsArray = new JsonArray();
		for (Review review : allReviews.getData()) {
			JsonObject reviewJson = new JsonObject();
			reviewJson.addProperty("id", String.valueOf(review.getId()));
			reviewJson.addProperty("reviewerFirstName",
					review.getReviewerFirstName());
			reviewJson.addProperty("reviewerLastName",
					review.getReviewerLastName());
			reviewJson.addProperty("rank", String.valueOf(review.getRank()));
			reviewJson.addProperty("created",
					String.valueOf(review.getCreated()));
			reviewsArray.add(reviewJson);
		}
		result.add("data", reviewsArray);
		return result.toString();
	}

}

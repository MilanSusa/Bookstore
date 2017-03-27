package rs.ac.bg.fon.ai.milansusa.bookstore.rest.json;

import java.util.Collection;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import rs.ac.bg.fon.ai.milansusa.bookstore.model.Review;

public class ReviewJsonSerializer {

	public static String serializeReviews(Collection<Review> allReviews) {
		JsonArray reviewsArray = new JsonArray();
		for (Review review : allReviews) {
			JsonObject reviewJson = new JsonObject();
			reviewJson.addProperty("id", String.valueOf(review.getId()));
			reviewJson.addProperty("reviewerFirstName",
					review.getReviewerFistName());
			reviewJson.addProperty("reviewerLastName",
					review.getReviewerLastName());
			reviewJson.addProperty("rank", String.valueOf(review.getRank()));
			reviewJson.addProperty("created",
					String.valueOf(review.getCreated()));
			reviewsArray.add(reviewJson);
		}
		return reviewsArray.toString();
	}

}

package rs.ac.bg.fon.ai.milansusa.bookstore.rest.json;

import java.util.List;

import rs.ac.bg.fon.ai.milansusa.bookstore.model.Review;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class ReviewJsonSerializer {

	public static String serializeReviews(List<Review> reviews) {
		JsonArray reviewsArray = new JsonArray();
		for (Review review : reviews) {
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

package rs.ac.bg.fon.ai.milansusa.bookstore.controller.json;

import com.google.gson.JsonObject;

import rs.ac.bg.fon.ai.milansusa.bookstore.model.User;

public class UserJsonSerializer {

	public static String serializeUser(User user) {
		JsonObject userJson = new JsonObject();
		userJson.addProperty("id", String.valueOf(user.getId()));
		userJson.addProperty("email", user.getEmail());
		userJson.addProperty("name", user.getName());
		userJson.addProperty("password", user.getPassword());
		return userJson.toString();
	}
}

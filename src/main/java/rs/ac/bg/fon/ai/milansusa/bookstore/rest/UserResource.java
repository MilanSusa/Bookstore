package rs.ac.bg.fon.ai.milansusa.bookstore.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonObject;

import rs.ac.bg.fon.ai.milansusa.bookstore.model.User;
import rs.ac.bg.fon.ai.milansusa.bookstore.service.UserService;
import rs.ac.bg.fon.ai.milansusa.bookstore.service.UserServiceException;

@RestController
@RequestMapping("/webapi/registration")
public class UserResource {

	@Autowired
	UserService userService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public String saveUser(@RequestBody User user) throws UserServiceException {
		userService.saveUser(user);
		MailSender.sendMail(user);
		JsonObject response = new JsonObject();
		response.addProperty("code", String.valueOf(Response.CREATED.getCode()));
		response.addProperty("message", String.valueOf(Response.CREATED.getBody()));
		return response.toString();
	}

}

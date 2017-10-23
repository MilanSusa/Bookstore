package rs.ac.bg.fon.ai.milansusa.bookstore.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.bg.fon.ai.milansusa.bookstore.model.User;
import rs.ac.bg.fon.ai.milansusa.bookstore.services.UserService;

@RestController
@RequestMapping("/webapi/registration")
public class UserResource {

	@Autowired
	UserService userService;

	@RequestMapping(method = RequestMethod.POST)
	public void createUser(@RequestBody User user) {
		userService.saveUser(user);
	}

}

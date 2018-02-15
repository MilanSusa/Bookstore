package rs.ac.bg.fon.ai.milansusa.bookstore.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.bg.fon.ai.milansusa.bookstore.model.User;
import rs.ac.bg.fon.ai.milansusa.bookstore.service.UserService;
import rs.ac.bg.fon.ai.milansusa.bookstore.service.UserServiceException;

@RestController
@RequestMapping("/webapi/registration")
public class UserResource {

	@Autowired
	UserService userService;

	@PostMapping
	public void saveUser(@RequestBody User user) throws UserServiceException {
		userService.saveUser(user);
		SendMailSSL.sendMail(user);
	}

}

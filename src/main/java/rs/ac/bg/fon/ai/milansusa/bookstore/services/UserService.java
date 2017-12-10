package rs.ac.bg.fon.ai.milansusa.bookstore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.bg.fon.ai.milansusa.bookstore.dao.UserDAO;
import rs.ac.bg.fon.ai.milansusa.bookstore.model.User;

@Service
public class UserService {

	@Autowired
	private UserDAO userDAO;

	public void saveUser(User user) {
		userDAO.saveUser(user);
	}

}

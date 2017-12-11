package rs.ac.bg.fon.ai.milansusa.bookstore.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.bg.fon.ai.milansusa.bookstore.dao.UserDAO;
import rs.ac.bg.fon.ai.milansusa.bookstore.model.User;

@Service
public class UserService {

	@Autowired
	private UserDAO userDAO;
	private static final Logger logger = LogManager.getLogger(UserService.class);

	public void saveUser(User user) throws UserServiceException {
		try {
			userDAO.saveUser(user);
		} catch (Exception e) {
			logger.error("User with email [" + user.getEmail() + "] is not persisted.");
			throw new UserServiceException(e.getMessage());
		}
	}

}

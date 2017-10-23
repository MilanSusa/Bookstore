package rs.ac.bg.fon.ai.milansusa.bookstore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.bg.fon.ai.milansusa.bookstore.model.User;
import rs.ac.bg.fon.ai.milansusa.bookstore.persistance.BookstorePersistence;

@Service
public class UserService {

	@Autowired
	private BookstorePersistence persistence;

	public void saveUser(User user) {
		persistence.saveUser(user);
	}

}

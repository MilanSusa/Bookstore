package rs.ac.bg.fon.ai.milansusa.bookstore.dao;

import java.util.Optional;

import rs.ac.bg.fon.ai.milansusa.bookstore.model.User;

public interface UserDAO {

	Optional<User> getUser(String username);

	void saveUser(User user) throws Exception;

}

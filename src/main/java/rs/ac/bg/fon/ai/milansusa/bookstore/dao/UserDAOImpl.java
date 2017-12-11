package rs.ac.bg.fon.ai.milansusa.bookstore.dao;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.ac.bg.fon.ai.milansusa.bookstore.model.Role;
import rs.ac.bg.fon.ai.milansusa.bookstore.model.User;

@Transactional
@Service("rs.ac.bg.fon.ai.milansusa.bookstore.dao.UserDAO")
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	private static final Logger logger = LogManager.getLogger(UserDAOImpl.class);

	@SuppressWarnings("unchecked")
	@Override
	public Optional<User> getUser(String username) {
		logger.info("Fetching user with username [" + username + "] from database.");
		return sessionFactory.getCurrentSession().createQuery("FROM User WHERE username = :username")
				.setParameter("username", username).uniqueResultOptional();
	}

	@Override
	public void saveUser(User user) throws Exception {
		logger.info("Saving user with email [" + user.getEmail() + "] to database.");
		User testUser = getUser(user.getUsername()).orElse(null);
		if (testUser != null) {
			logger.error("User with email [" + user.getEmail() + "] already exists.");
			throw new Exception("User with email [" + user.getEmail() + "] already exists.");
		}
		Role role = new Role("USER");
		Set<Role> roles = new HashSet<>();
		roles.add(role);
		user.setRoles(roles);
		role.setUser(user);
		user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
		sessionFactory.getCurrentSession().save(user);
		sessionFactory.getCurrentSession().save(role);
	}

}

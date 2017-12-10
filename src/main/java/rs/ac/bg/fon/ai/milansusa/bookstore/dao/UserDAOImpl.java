package rs.ac.bg.fon.ai.milansusa.bookstore.dao;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

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

	@SuppressWarnings("unchecked")
	@Override
	public Optional<User> getUser(String username) {
		return sessionFactory.getCurrentSession().createQuery("FROM User WHERE username = :username")
				.setParameter("username", username).uniqueResultOptional();
	}

	@Override
	public void saveUser(User user) {
		User testUser = getUser(user.getUsername()).orElse(null);
		if (testUser != null) {
			return;
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

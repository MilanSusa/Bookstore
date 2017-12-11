package rs.ac.bg.fon.ai.milansusa.bookstore.services;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import rs.ac.bg.fon.ai.milansusa.bookstore.dao.UserDAO;
import rs.ac.bg.fon.ai.milansusa.bookstore.model.CustomUserDetails;
import rs.ac.bg.fon.ai.milansusa.bookstore.model.User;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserDAO userDAO;
	private static final Logger logger = LogManager.getLogger(CustomUserDetailsService.class);

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.info("Loading user by username [" + username + "].");
		Optional<User> optionalUser = userDAO.getUser(username);
		optionalUser.orElseThrow(() -> new UsernameNotFoundException("Username: " + username + " not found"));
		return optionalUser.map(CustomUserDetails::new).get();
	}

}

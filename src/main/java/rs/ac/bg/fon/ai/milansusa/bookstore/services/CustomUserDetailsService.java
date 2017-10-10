package rs.ac.bg.fon.ai.milansusa.bookstore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import rs.ac.bg.fon.ai.milansusa.bookstore.model.CustomUserDetails;
import rs.ac.bg.fon.ai.milansusa.bookstore.persistance.BookstorePersistence;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private BookstorePersistence persistance;
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		return (CustomUserDetails) persistance.getUser(username);
	}

}

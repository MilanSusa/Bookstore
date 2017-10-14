package rs.ac.bg.fon.ai.milansusa.bookstore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;

import rs.ac.bg.fon.ai.milansusa.bookstore.services.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomUserDetailsService userDetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests().antMatchers("/**").authenticated().anyRequest().permitAll().and().formLogin()
				.loginPage("/login.html").permitAll().and().logout().permitAll();
	}

	@Override
	@Autowired
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(getPasswordEncoder());
	}

	private PasswordEncoder getPasswordEncoder() {
		return new PasswordEncoder() {

			@Override
			public boolean matches(CharSequence rawPassword, String encodedPassword) {
				if (BCrypt.checkpw(rawPassword.toString(), encodedPassword))
					return true;
				return false;
			}

			@Override
			public String encode(CharSequence rawPassword) {
				return BCrypt.hashpw(rawPassword.toString(), BCrypt.gensalt());
			}

		};
	}

}

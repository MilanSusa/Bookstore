package rs.ac.bg.fon.ai.milansusa.bookstore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		 http.authorizeRequests().antMatchers("/*").hasRole("USER").and()
//		 .formLogin();
		http.csrf().disable();
		http.authorizeRequests().antMatchers("/**").authenticated()
				.anyRequest().permitAll().and().formLogin().permitAll();
	}

	@Override
	@Autowired
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(
				getPasswordEncoder());
//		auth.inMemoryAuthentication().withUser("test").password("pass").roles("USER");
	}

	private PasswordEncoder getPasswordEncoder() {
		return new PasswordEncoder() {

			@Override
			public boolean matches(CharSequence charSequence, String s) {
				return true;
			}

			@Override
			public String encode(CharSequence charSequence) {
				return charSequence.toString();
			}

		};
	}
}

package rs.ac.bg.fon.ai.milansusa.bookstore.config;

import org.springframework.context.ApplicationContext;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import rs.ac.bg.fon.ai.milansusa.bookstore.services.AuthorService;
import rs.ac.bg.fon.ai.milansusa.bookstore.services.BookService;
import rs.ac.bg.fon.ai.milansusa.bookstore.services.ReviewService;

@Configuration
@ComponentScan(value = { "rs.ac.bg.fon.ai.milansusa.bookstore.services" })
public class DIConfig {

	public static ApplicationContext ctx = new AnnotationConfigApplicationContext(
			DIConfig.class);;

	@Bean
	public AuthorService getAuthorService() {
		return new AuthorService();
	}

	@Bean
	public BookService getBookService() {
		return new BookService();
	}

	@Bean
	public ReviewService getReviewService() {
		return new ReviewService();
	}

}

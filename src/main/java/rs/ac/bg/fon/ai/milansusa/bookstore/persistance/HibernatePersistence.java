package rs.ac.bg.fon.ai.milansusa.bookstore.persistance;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.ac.bg.fon.ai.milansusa.bookstore.model.Author;
import rs.ac.bg.fon.ai.milansusa.bookstore.model.Book;
import rs.ac.bg.fon.ai.milansusa.bookstore.model.Review;
import rs.ac.bg.fon.ai.milansusa.bookstore.model.Role;
import rs.ac.bg.fon.ai.milansusa.bookstore.model.User;

@Transactional
@Service("rs.ac.bg.fon.ai.milansusa.bookstore.persistance.BookstorePersistence")
public class HibernatePersistence implements BookstorePersistence {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Result<Author> getAllAuthors(int page, int limit, String query) {
		String queryText = "FROM Author WHERE lastName LIKE '" + query + "%' ORDER BY lastName";
		@SuppressWarnings("unchecked")
		Collection<Author> authors = sessionFactory.getCurrentSession().createQuery(queryText)
				.setFirstResult((page - 1) * limit).setMaxResults(limit).list();
		queryText = "FROM Author WHERE lastName LIKE '" + query + "%'";
		int maxResults = sessionFactory.getCurrentSession().createQuery(queryText).list().size();
		return new Result<>(authors, maxResults);
	}

	@Override
	public Author getAuthor(long id) {
		return (Author) sessionFactory.getCurrentSession().get(Author.class, id);
	}

	@Override
	public Result<Book> getAllBooks(int page, int limit, String query) {
		String queryText = "FROM Book WHERE title LIKE '" + query + "%' ORDER BY title";
		@SuppressWarnings("unchecked")
		Collection<Book> books = sessionFactory.getCurrentSession().createQuery(queryText)
				.setFirstResult((page - 1) * limit).setMaxResults(limit).list();
		queryText = "FROM Book WHERE title LIKE '" + query + "%'";
		int maxResults = sessionFactory.getCurrentSession().createQuery(queryText).list().size();
		return new Result<>(books, maxResults);
	}

	@Override
	public Book getBook(long id) {
		return (Book) sessionFactory.getCurrentSession().get(Book.class, id);
	}

	@Override
	public Result<Review> getAllReviews(int page, int limit, String query) {
		String queryText = "FROM Review WHERE reviewerLastName LIKE '" + query + "%' ORDER BY reviewerLastName";
		@SuppressWarnings("unchecked")
		Collection<Review> reviews = sessionFactory.getCurrentSession().createQuery(queryText)
				.setFirstResult((page - 1) * limit).setMaxResults(limit).list();
		queryText = "FROM Review WHERE reviewerLastName LIKE '" + query + "%'";
		int maxResults = sessionFactory.getCurrentSession().createQuery(queryText).list().size();
		return new Result<>(reviews, maxResults);
	}

	@Override
	public Review getReview(long id) {
		return (Review) sessionFactory.getCurrentSession().get(Review.class, id);
	}

	@Override
	public Result<Review> getBookReviews(long bookId, int page, int limit, String query) {
		String queryText = "FROM Review WHERE bookId = " + bookId + " AND reviewerLastName LIKE '" + query
				+ "%' ORDER BY reviewerLastName";
		@SuppressWarnings("unchecked")
		Collection<Review> reviews = sessionFactory.getCurrentSession().createQuery(queryText)
				.setFirstResult((page - 1) * limit).setMaxResults(limit).list();
		queryText = "FROM Review WHERE bookId = " + bookId + " AND reviewerLastName LIKE '" + query + "%'";
		int maxResults = sessionFactory.getCurrentSession().createQuery(queryText).list().size();
		return new Result<>(reviews, maxResults);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Optional<User> getUser(String username) {
		return sessionFactory.getCurrentSession().createQuery("FROM User WHERE username = :username")
				.setParameter("username", username).uniqueResultOptional();
	}

	@Override
	public void saveUser(User user) {
		Set<Role> roles = new HashSet<>();
		roles.add(new Role("USER"));
		user.setRoles(roles);
		user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
		sessionFactory.getCurrentSession().save(user);
	}

}

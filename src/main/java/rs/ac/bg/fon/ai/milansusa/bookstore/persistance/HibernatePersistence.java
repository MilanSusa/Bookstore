package rs.ac.bg.fon.ai.milansusa.bookstore.persistance;

import java.util.Collection;    

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.ac.bg.fon.ai.milansusa.bookstore.model.Author;
import rs.ac.bg.fon.ai.milansusa.bookstore.model.Book;
import rs.ac.bg.fon.ai.milansusa.bookstore.model.Review;

@Transactional
@Service ("rs.ac.bg.fon.ai.milansusa.bookstore.persistance.BookstorePersistence")
public class HibernatePersistence implements BookstorePersistence {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Result<Author> getAllAuthors(int page, int limit, String query) {
		String queryText = "FROM Author WHERE lastName LIKE '" + query + "%' ORDER BY lastName";
		@SuppressWarnings("unchecked")
		Collection<Author> authors = sessionFactory.getCurrentSession()
												   .createQuery(queryText)
												   .setFirstResult((page - 1) * limit)
											       .setMaxResults(limit)
											       .list();
		queryText = "FROM Author WHERE lastName LIKE '" + query + "%'";
		int maxResults = sessionFactory.getCurrentSession().createQuery(queryText).list().size();
		return new Result<>(authors, maxResults);
	}

	@Override
	public Author getAuthor(long id) {
		Author author = (Author) sessionFactory.getCurrentSession().get(Author.class, id);
		return author;
	}

	@Override
	public Result<Book> getAllBooks(int page, int limit, String query) {
		String queryText = "FROM Book WHERE title LIKE '" + query + "%' ORDER BY title";
		@SuppressWarnings("unchecked")
		Collection<Book> books = sessionFactory.getCurrentSession()
											   .createQuery(queryText)
											   .setFirstResult((page - 1) * limit)
											   .setMaxResults(limit)
											   .list();
		queryText = "FROM Book WHERE title LIKE '" + query + "%'";
		int maxResults = sessionFactory.getCurrentSession().createQuery(queryText).list().size();
		return new Result<>(books, maxResults);
	}

	@Override
	public Book getBook(long id) {
		Book book = (Book) sessionFactory.getCurrentSession().get(Book.class, id);
		return book;
	}

	@Override
	public Result<Review> getAllReviews(int page, int limit, String query) {
		String queryText = "FROM Review WHERE reviewerLastName LIKE '" + query + "%' ORDER BY reviewerLastName";
		@SuppressWarnings("unchecked")
		Collection<Review> reviews = sessionFactory.getCurrentSession()
												   .createQuery(queryText)
												   .setFirstResult((page - 1) * limit)
												   .setMaxResults(limit)
												   .list();
		queryText = "FROM Review WHERE reviewerLastName LIKE '" + query + "%'";
		int maxResults = sessionFactory.getCurrentSession().createQuery(queryText).list().size();
		return new Result<>(reviews, maxResults);
	}

	@Override
	public Review getReview(long id) {
		Review review = (Review) sessionFactory.getCurrentSession().get(Review.class, id);
		return review;
	}

	@Override
	public Result<Review> getBookReviews(long bookId, int page, int limit, String query) {
		String queryText = "FROM Review WHERE bookId = " + bookId + " AND reviewerLastName LIKE '" + query + "%' ORDER BY reviewerLastName";
		@SuppressWarnings("unchecked")
		Collection<Review> reviews = sessionFactory.getCurrentSession()
												   .createQuery(queryText)
												   .setFirstResult((page - 1) * limit)
												   .setMaxResults(limit)
												   .list();
		queryText = "FROM Review WHERE bookId = " + bookId + " AND reviewerLastName LIKE '" + query + "%'";
		int maxResults = sessionFactory.getCurrentSession().createQuery(queryText).list().size();
		return new Result<>(reviews, maxResults);
	}

}

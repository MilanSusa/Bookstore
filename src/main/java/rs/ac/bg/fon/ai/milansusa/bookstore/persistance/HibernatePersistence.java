package rs.ac.bg.fon.ai.milansusa.bookstore.persistance;

import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import rs.ac.bg.fon.ai.milansusa.bookstore.model.Author;
import rs.ac.bg.fon.ai.milansusa.bookstore.model.Book;
import rs.ac.bg.fon.ai.milansusa.bookstore.model.Review;

public class HibernatePersistence implements BookstorePersistence {

	private final SessionFactory sessionFactory = new Configuration()
			.configure().buildSessionFactory();
	private Session session = null;

	private void openSession() {
		session = sessionFactory.openSession();
		session.beginTransaction();
	}

	private void closeSession() {
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public Result<Author> getAllAuthors(int page, int limit, String query) {
		openSession();
		String queryText = "FROM Author WHERE lastName LIKE '" + query + "%' ORDER BY lastName";
		Collection<Author> authors = session.createQuery(queryText)
											.setFirstResult((page - 1) * limit)
											.setMaxResults(limit)
											.list();
		queryText = "FROM Author WHERE lastName LIKE '" + query + "%'";
		int maxResults = session.createQuery(queryText).list().size();
		closeSession();
		return new Result<>(authors, maxResults);
	}

	@Override
	public Author getAuthor(long id) {
		openSession();
		Author author = (Author) session.get(Author.class, id);
		closeSession();
		return author;
	}

	@Override
	public Result<Book> getAllBooks(int page, int limit, String query) {
		openSession();
		String queryText = "FROM Book WHERE title LIKE '" + query + "%' ORDER BY title";
		Collection<Book> books = session.createQuery(queryText)
										.setFirstResult((page - 1) * limit)
										.setMaxResults(limit)
										.list();
		queryText = "FROM Book WHERE title LIKE '" + query + "%'";
		int maxResults = session.createQuery(queryText).list().size();
		closeSession();
		return new Result<>(books, maxResults);
	}

	@Override
	public Book getBook(long id) {
		openSession();
		Book book = (Book) session.get(Book.class, id);
		closeSession();
		return book;
	}

	@Override
	public Result<Review> getAllReviews(int page, int limit, String query) {
		openSession();
		String queryText = "FROM Review WHERE reviewerLastName LIKE '" + query + "%' ORDER BY reviewerLastName";
		Collection<Review> reviews = session.createQuery(queryText)
											.setFirstResult((page - 1) * limit)
											.setMaxResults(limit)
											.list();
		queryText = "FROM Review WHERE reviewerLastName LIKE '" + query + "%'";
		int maxResults = session.createQuery(queryText).list().size();
		closeSession();
		return new Result<>(reviews, maxResults);
	}

	@Override
	public Review getReview(long id) {
		openSession();
		Review review = (Review) session.get(Review.class, id);
		closeSession();
		return review;
	}

	@Override
	public Collection<Review> getBookReviews(long bookId) {
		// TODO Auto-generated method stub
		return null;
	}

}

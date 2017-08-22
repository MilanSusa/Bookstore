package rs.ac.bg.fon.ai.milansusa.bookstore.persistance;

import java.util.Collection;

import javax.persistence.Query;

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
		String queryText = "from Author ";
		if (query != null && !query.isEmpty()) {
			queryText += "where lastName like '" + query + "%' ";
		}
		queryText += "order by lastName ";
		Query q = session.createQuery(queryText);
		q.setFirstResult((page - 1) * limit);
		q.setMaxResults(limit);
		Collection<Author> authors = ((org.hibernate.query.Query) q).list();
		String queryText1 = "from Author ";
		if (query != null && !query.isEmpty()) {
			queryText1 += "where lastName like '" + query + "%' ";
		}
		Query q1 = session.createQuery(queryText1);
		int maxResults = ((org.hibernate.query.Query) q1).list().size();
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
		String queryText = "from Book ";
		if (query != null && !query.isEmpty()) {
			queryText += "where title like '" + query + "%' ";
		}
		queryText += "order by title ";
		Query q = session.createQuery(queryText);
		q.setFirstResult((page - 1) * limit);
		q.setMaxResults(limit);
		Collection<Book> books = ((org.hibernate.query.Query) q).list();
		String queryText1 = "from Book ";
		if (query != null && !query.isEmpty()) {
			queryText1 += "where title like '" + query + "%' ";
		}
		Query q1 = session.createQuery(queryText1);
		int maxResults = ((org.hibernate.query.Query) q1).list().size();
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
		String queryText = "from Review ";
		if (query != null && !query.isEmpty()) {
			queryText += "where reviewerLastName like '" + query + "%' ";
		}
		queryText += "order by reviewerLastName ";
		Query q = session.createQuery(queryText);
		q.setFirstResult((page - 1) * limit);
		q.setMaxResults(limit);
		Collection<Review> reviews = ((org.hibernate.query.Query) q).list();
		String queryText1 = "from Review ";
		if (query != null && !query.isEmpty()) {
			queryText1 += "where reviewerLastName like '" + query + "%' ";
		}
		Query q1 = session.createQuery(queryText1);
		int maxResults = ((org.hibernate.query.Query) q1).list().size();
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

package rs.ac.bg.fon.ai.milansusa.bookstore.dao;

import java.util.Collection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.ac.bg.fon.ai.milansusa.bookstore.model.Book;

@Transactional
@Service("rs.ac.bg.fon.ai.milansusa.bookstore.dao.BookDAO")
public class BookDAOImpl implements BookDAO {

	@Autowired
	private SessionFactory sessionFactory;
	private static final Logger logger = LogManager.getLogger(BookDAOImpl.class);

	@Override
	public Result<Book> getAllBooks(int page, int limit, String query) {
		logger.info("Fetching all books from database.");
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
		logger.info("Fetching book with id [" + id + "] from database.");
		return (Book) sessionFactory.getCurrentSession().get(Book.class, id);
	}

}

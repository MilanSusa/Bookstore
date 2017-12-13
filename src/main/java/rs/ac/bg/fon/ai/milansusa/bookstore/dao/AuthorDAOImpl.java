package rs.ac.bg.fon.ai.milansusa.bookstore.dao;

import java.util.Collection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import rs.ac.bg.fon.ai.milansusa.bookstore.model.Author;

@Transactional
@Repository
public class AuthorDAOImpl implements AuthorDAO {

	@Autowired
	private SessionFactory sessionFactory;
	private static final Logger logger = LogManager.getLogger(AuthorDAOImpl.class);

	@Override
	public Result<Author> getAllAuthors(int page, int limit, String query) {
		logger.info("Fetching all authors from database.");
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
		logger.info("Fetching author with id [" + id + "] from database.");
		return (Author) sessionFactory.getCurrentSession().get(Author.class, id);
	}

}

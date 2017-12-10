package rs.ac.bg.fon.ai.milansusa.bookstore.dao;

import java.util.Collection;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.ac.bg.fon.ai.milansusa.bookstore.model.Author;

@Transactional
@Service("rs.ac.bg.fon.ai.milansusa.bookstore.dao.AuthorDAO")
public class AuthorDAOImpl implements AuthorDAO {

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

}

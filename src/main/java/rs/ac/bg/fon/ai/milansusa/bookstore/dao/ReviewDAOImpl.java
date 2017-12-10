package rs.ac.bg.fon.ai.milansusa.bookstore.dao;

import java.util.Collection;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.ac.bg.fon.ai.milansusa.bookstore.model.Review;

@Transactional
@Service("rs.ac.bg.fon.ai.milansusa.bookstore.dao.ReviewDAO")
public class ReviewDAOImpl implements ReviewDAO {

	@Autowired
	private SessionFactory sessionFactory;

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

}

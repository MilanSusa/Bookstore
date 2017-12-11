package rs.ac.bg.fon.ai.milansusa.bookstore.dao;

import java.util.Collection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
	private static final Logger logger = LogManager.getLogger(ReviewDAOImpl.class);

	@Override
	public Result<Review> getAllReviews(int page, int limit, String query) {
		logger.info("Fetching all reviews from database.");
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
		logger.info("Fetching review with id [" + id + "] from database.");
		return (Review) sessionFactory.getCurrentSession().get(Review.class, id);
	}

	@Override
	public Result<Review> getBookReviews(long bookId, int page, int limit, String query) {
		logger.info("Fetching all reviews for book with id [" + bookId + "] from database.");
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

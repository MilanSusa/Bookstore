package rs.ac.bg.fon.ai.milansusa.bookstore.persistance;

import java.util.Collection;
import java.util.LinkedList;
import java.sql.*;
import rs.ac.bg.fon.ai.milansusa.bookstore.model.Author;
import rs.ac.bg.fon.ai.milansusa.bookstore.model.Book;
import rs.ac.bg.fon.ai.milansusa.bookstore.model.Review;
import rs.ac.bg.fon.ai.milansusa.bookstore.model.enums.Gender;

public class DatabasePersistence implements BookstorePersistence {

	private final String database = "jdbc:mysql://localhost:3306/bookstore";
	private final String username = "root";
	private final String password = "root";

	Connection connection = null;
	Statement statement = null;

	private void openConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(database, username,
					password);
			statement = connection.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Result<Author> getAllAuthors(int page, int limit, String query) {
		Collection<Author> authors = new LinkedList<>();
		int maxResults = 0;
		openConnection();
		try {
			String q = "SELECT * " + 
						"FROM authors ";
					
			if (query != null && !query.isEmpty()) {
				q += "WHERE lastName LIKE '" + query + "%' ";
			}
			
			q+=	"ORDER BY lastName " + 
				"LIMIT ? " + 
				"OFFSET ? ";
			PreparedStatement preparedStatement = connection
					.prepareStatement(q);
			preparedStatement.setLong(1, limit);
			preparedStatement.setLong(2, (page - 1) * limit);
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				Author author = new Author();
				author.setId(result.getLong("id"));
				author.setFirstName(result.getString("firstName"));
				author.setLastName(result.getString("lastName"));
				author.setGender(Gender.valueOf(result.getString("gender")));
				authors.add(author);
			}
			String q1 = "SELECT COUNT(*)" + 
						"FROM authors";
			
			if (query != null && !query.isEmpty()) {
				q1 += "WHERE lastName LIKE '" + query + "%' ";
			}
			ResultSet result1 = statement.executeQuery(q1);
			if (result1.next()) {
				maxResults = result1.getInt("COUNT(*)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection();
		return new Result<Author>(authors, maxResults);
	}

	@Override
	public Author getAuthor(long id) {
		Author author = new Author();
		String query = "SELECT * " + 
						"FROM authors " + 
						"WHERE id = ?";
		openConnection();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(query);
			preparedStatement.setLong(1, id);
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				author.setId(result.getLong("id"));
				author.setFirstName(result.getString("firstName"));
				author.setLastName(result.getString("lastName"));
				author.setGender(Gender.valueOf(result.getString("gender")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection();
		return author;
	}

	@Override
	public Result<Book> getAllBooks(int page, int limit, String query) {
		Collection<Book> books = new LinkedList<>();
		int maxResults = 0;
		openConnection();
		try {
			String q = 
				"SELECT * " + 
				"FROM books ";
			
			if (query != null && !query.isEmpty()) {
				q += "WHERE title LIKE '" + query + "%' ";
			}
			
			q += "ORDER BY title " +
				 "LIMIT ? " + 
				 "OFFSET ? ";
			
			PreparedStatement preparedStatement = connection.prepareStatement(q);
			preparedStatement.setLong(1, limit);
			preparedStatement.setLong(2, (page - 1) * limit);
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				Book book = new Book();
				book.setId(result.getLong("id"));
				book.setTitle(result.getString("title"));
				book.setReleaseYear(result.getInt("releaseYear"));
				book.setAuthor(result.getString("author"));
				books.add(book);
			}
			
			String q1 = "SELECT COUNT(*)" + 
						"FROM books ";
							
			if (query != null && !query.isEmpty()) {
				q1 += "WHERE title LIKE '" + query + "%' ";
			}
			
			ResultSet result1 = statement.executeQuery(q1);
			if (result1.next()) {
				maxResults = result1.getInt("COUNT(*)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection();
		return new Result<Book>(books, maxResults);
	}

	@Override
	public Book getBook(long id) {
		Book book = new Book();
		String query = "SELECT * FROM books WHERE id = ?";
		openConnection();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(query);
			preparedStatement.setLong(1, id);
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				book.setId(result.getLong("id"));
				book.setTitle(result.getString("title"));
				book.setReleaseYear(result.getInt("releaseYear"));
				book.setAuthor(result.getString("author"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection();
		return book;
	}

	@Override
	public Result<Review> getAllReviews(int page, int limit, String query) {
		Collection<Review> reviews = new LinkedList<>();
		int maxResults = 0;
		openConnection();
		try {
			String q = "SELECT * " + 
						"FROM reviews ";
			if (query != null && !query.isEmpty()) {
				q += "WHERE reviewerLastName LIKE '" + query + "%' ";
			}
			q +="ORDER BY rank " + 
				"LIMIT ? " + 
				"OFFSET ? ";
			PreparedStatement preparedStatement = connection
					.prepareStatement(q);
			preparedStatement.setLong(1, limit);
			preparedStatement.setLong(2, (page - 1) * limit);
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				Review review = new Review();
				review.setId(result.getLong("id"));
				review.setReviewerFistName(result
						.getString("reviewersFirstName"));
				review.setReviewerLastName(result
						.getString("reviewersLastName"));
				review.setRank(result.getDouble("rank"));
				review.setCreated(result.getDate("created"));
				reviews.add(review);
			}
			String q1 = "SELECT COUNT(*)" + 
						"FROM reviews";
			
			if (query != null && !query.isEmpty()) {
				q1 += "WHERE reviewerLastName LIKE '" + query + "%' ";
			}
			ResultSet result1 = statement.executeQuery(q1);
			if (result1.next()) {
				maxResults = result1.getInt("COUNT(*)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection();
		return new Result<>(reviews, maxResults);
	}

	@Override
	public Review getReview(long id) {
		Review review = new Review();
		String query = "SELECT * FROM reviews WHERE id = ?";
		openConnection();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(query);
			preparedStatement.setLong(1, id);
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				review.setId(result.getLong("id"));
				review.setReviewerFistName(result
						.getString("reviewersFirstName"));
				review.setReviewerLastName(result
						.getString("reviewersLastName"));
				review.setRank(result.getDouble("rank"));
				review.setCreated(result.getDate("created"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection();
		return review;
	}

	@Override
	public Collection<Review> getBookReviews(long bookId) {
		Collection<Review> reviews = new LinkedList<>();
		String query = "SELECT * FROM reviews WHERE bookId = ?";
		openConnection();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(query);
			preparedStatement.setLong(1, bookId);
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				Review review = new Review();
				review.setId(result.getLong("id"));
				review.setReviewerFistName(result
						.getString("reviewersFirstName"));
				review.setReviewerLastName(result
						.getString("reviewersLastName"));
				review.setRank(result.getDouble("rank"));
				review.setCreated(result.getDate("created"));
				reviews.add(review);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection();
		return reviews;
	}

}

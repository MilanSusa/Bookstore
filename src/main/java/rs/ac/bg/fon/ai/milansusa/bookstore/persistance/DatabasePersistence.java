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
	public Collection<Author> getAllAuthors() {
		Collection<Author> authors = new LinkedList<>();
		openConnection();
		try {
			ResultSet result = statement.executeQuery("SELECT * FROM authors");
			while (result.next()) {
				Author author = new Author();
				author.setId(result.getLong("id"));
				author.setFirstName(result.getString("firstName"));
				author.setLastName(result.getString("lastName"));
				author.setGender(Gender.valueOf(result.getString("gender")));
				authors.add(author);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection();
		return authors;
	}

	@Override
	public Author getAuthor(long id) {
		Author author = new Author();
		String query = "SELECT * FROM authors WHERE id = ?";
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
	public Collection<Book> getAllBooks() {
		Collection<Book> books = new LinkedList<>();
		openConnection();
		try {
			ResultSet result = statement.executeQuery("SELECT * FROM books");
			while (result.next()) {
				Book book = new Book();
				book.setId(result.getLong("id"));
				book.setTitle(result.getString("title"));
				book.setReleaseYear(result.getInt("releaseYear"));
				books.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection();
		return books;
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
			ResultSet result = preparedStatement.executeQuery(query);
			while (result.next()) {
				book.setId(result.getLong("id"));
				book.setTitle(result.getString("title"));
				book.setReleaseYear(result.getInt("releaseYear"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection();
		return book;
	}

	@Override
	public Collection<Review> getAllReviews() {
		Collection<Review> reviews = new LinkedList<>();
		openConnection();
		try {
			ResultSet result = statement.executeQuery("SELECT * FROM reviews");
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

	@Override
	public Review getReview(long id) {
		Review review = new Review();
		String query = "SELECT * FROM reviews WHERE id = ?";
		openConnection();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(query);
			preparedStatement.setLong(1, id);
			ResultSet result = preparedStatement.executeQuery(query);
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
		String query = "SELECT * FROM reviews WHERE forBook = ?";
		openConnection();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(query);
			preparedStatement.setLong(1, bookId);
			ResultSet result = preparedStatement.executeQuery(query);
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

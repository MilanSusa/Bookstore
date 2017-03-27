package rs.ac.bg.fon.ai.milansusa.bookstore.persistance;

import java.util.Collection;

import rs.ac.bg.fon.ai.milansusa.bookstore.model.Author;
import rs.ac.bg.fon.ai.milansusa.bookstore.model.Book;
import rs.ac.bg.fon.ai.milansusa.bookstore.model.Review;

public class DatabasePersistence implements BookstorePersistence {
	
	private final String database = "bookstore";
	private final String username = "root";
	private final String password = "root";
	
	// Connection connection = null;
	// Statement statement = null;
	
	private void openConnection() {
		// open connection and create statement that are class fields
	}
	
	private void closeConnection() {
		// close connection
	}

	@Override
	public Collection<Author> getAllAuthors() {
		openConnection();
		// ResultSet result = statement.executeQuery("SELECT * FROM books");
		
		closeConnection();
		return null;
	}

	@Override
	public Author getAuthor(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book getBook(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Review> getAllReviews() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Review getReview(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Review> getBookReviews(long bookId) {
		// TODO Auto-generated method stub
		return null;
	}

}

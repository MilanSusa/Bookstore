package rs.ac.bg.fon.ai.milansusa.rest.model;

import java.util.HashSet;
import java.util.Set;

public class Book {

	private long id;
	private String title;
	private int releaseYear;
	private Set<Author> authors = new HashSet<>();
	private Set<Review> reviews = new HashSet<>();

	public Book() {

	}

	public Book(long id, String title, int releaseYear) {
		this.id = id;
		this.title = title;
		this.releaseYear = releaseYear;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

	public Set<Review> getReviews() {
		return reviews;
	}

	public void setReviews(Set<Review> reviews) {
		this.reviews = reviews;
	}

}

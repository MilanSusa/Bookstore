package rs.ac.bg.fon.ai.milansusa.bookstore.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Book {

	@Id
	@GeneratedValue
	private long id;
	private String title;
	private int releaseYear;
	@ManyToMany(mappedBy = "books")
	private Set<Author> authors;
	@OneToMany(mappedBy = "book")
	private Set<Review> reviews;

	public Book() {
		authors = new HashSet<>();
		reviews = new HashSet<>();
	}

	public Book(long id, String title, int releaseYear, String author) {
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

	public Set<Review> getReviews() {
		return reviews;
	}

	public void setReviews(Set<Review> reviews) {
		this.reviews = reviews;
	}

	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", releaseYear="
				+ releaseYear + "]";
	}

}

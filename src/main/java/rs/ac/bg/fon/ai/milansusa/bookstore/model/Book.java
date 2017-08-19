package rs.ac.bg.fon.ai.milansusa.bookstore.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "books")
public class Book {

	@Id
	@GeneratedValue
	private long id;
	private String title;
	private int releaseYear;
	private String author;
	@Transient
	private Set<Review> reviews = new HashSet<>();

	public Book() {

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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", releaseYear="
				+ releaseYear + ", author=" + author + "]";
	}

}

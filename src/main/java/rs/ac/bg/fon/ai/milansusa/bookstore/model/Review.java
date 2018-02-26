package rs.ac.bg.fon.ai.milansusa.bookstore.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Review {

	@Id
	@GeneratedValue
	private long id;
	private String reviewerFirstName;
	private String reviewerLastName;
	private double rank;
	private Date created;
	@ManyToOne
	@JoinColumn(name = "bookId")
	private Book book;

	public Review() {

	}

	public Review(long id, String reviewerFirstName, String reviewerLastName, double rank) {
		this.id = id;
		this.reviewerFirstName = reviewerFirstName;
		this.reviewerLastName = reviewerLastName;
		this.rank = rank;
		this.created = new Date();
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getReviewerFirstName() {
		return reviewerFirstName;
	}

	public void setReviewerFirstName(String reviewerFirstName) {
		this.reviewerFirstName = reviewerFirstName;
	}

	public String getReviewerLastName() {
		return reviewerLastName;
	}

	public void setReviewerLastName(String reviewerLastName) {
		this.reviewerLastName = reviewerLastName;
	}

	public double getRank() {
		return rank;
	}

	public void setRank(double rank) {
		this.rank = rank;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

}

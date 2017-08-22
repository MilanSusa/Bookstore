package rs.ac.bg.fon.ai.milansusa.bookstore.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "reviews")
public class Review {

	@Id
	@GeneratedValue
	private long id;
	@Column(name = "reviewersFirstName")
	private String reviewerFistName;
	@Column(name = "reviewersLastName")
	private String reviewerLastName;
	private double rank;
	private Date created;
	@Transient
	private Book book;

	public Review() {

	}

	public Review(long id, String reviewerFistName, String reviewerLastName,
			double rank, Date created) {
		this.id = id;
		this.reviewerFistName = reviewerFistName;
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

	public String getReviewerFistName() {
		return reviewerFistName;
	}

	public void setReviewerFistName(String reviewerFistName) {
		this.reviewerFistName = reviewerFistName;
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

	@Override
	public String toString() {
		return "Review [id=" + id + ", reviewerFistName=" + reviewerFistName
				+ ", reviewerLastName=" + reviewerLastName + ", rank=" + rank
				+ ", created=" + created + "]";
	}

}

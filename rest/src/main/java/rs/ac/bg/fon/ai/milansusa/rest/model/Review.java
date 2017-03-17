package rs.ac.bg.fon.ai.milansusa.rest.model;

import java.util.Date;

public class Review {

	private long id;
	private String reviewerFistName;
	private String reviewerLastName;
	private double rank;
	private Date created;

	public Review() {

	}

	public Review(long id, String reviewerFistName, String reviewerLastName, double rank, Date created) {
		this.id = id;
		this.reviewerFistName = reviewerFistName;
		this.reviewerLastName = reviewerLastName;
		this.rank = rank;
		this.created = new Date();
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

}

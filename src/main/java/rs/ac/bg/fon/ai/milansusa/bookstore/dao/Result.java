package rs.ac.bg.fon.ai.milansusa.bookstore.dao;

import java.util.Collection;

public class Result<T> {

	private Collection<T> data;
	private int maxResults;

	public Result(Collection<T> data, int maxResults) {
		this.data = data;
		this.maxResults = maxResults;
	}

	public Collection<T> getData() {
		return data;
	}

	public void setData(Collection<T> data) {
		this.data = data;
	}

	public int getMaxResults() {
		return maxResults;
	}

	public void setMaxResults(int maxResults) {
		this.maxResults = maxResults;
	}

}

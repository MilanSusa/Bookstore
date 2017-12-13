package rs.ac.bg.fon.ai.milansusa.bookstore.rest;

public enum Response {

	OK(200, "The request has succeeded."), 
	BAD_REQUEST(400, "The request could not be understood by the server due to malformed syntax.");

	private final int code;
	private final String body;

	private Response(int code, String body) {
		this.code = code;
		this.body = body;
	}

	public int getCode() {
		return code;
	}

	public String getBody() {
		return body;
	}

}

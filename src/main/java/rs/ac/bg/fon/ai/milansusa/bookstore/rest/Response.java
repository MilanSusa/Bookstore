package rs.ac.bg.fon.ai.milansusa.bookstore.rest;

public enum Response {

	OK(200, "The request has succeeded."),
	CREATED(201, "The request has been fulfilled and has resulted in one or more new resources being created."),
	BAD_REQUEST(400, "The request could not be understood by the server due to malformed syntax."),
	CONFLICT(409, "The request could not be completed due to a conflict with the current state of the target resource. ");

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

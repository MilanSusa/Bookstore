package rs.ac.bg.fon.ai.milansusa.rest.service;

public class AuthorService {

	public String getAllAuthors() {
		return "["
				+ "{"
				+ "\"id\": 1,"
				+ "\"firstName\": \"Napoleon\","
				+ "\"lasName\": \"Hill\","
				+ "\"gender\": \"MALE\""
				+ "},"
				+ "{"
				+ "\"id\": 2,"
				+ "\"firstName\": \"Ekhart\","
				+ "\"lasName\": \"Tole\","
				+ "\"gender\": \"MALE\""
				+ "}"
				+ "]";
	}
}

package rs.ac.bg.fon.ai.milansusa.bookstore.config;

public class Config {

	private boolean format;
	private DbConfig dbConfig;
	private EmailConfig emailConfig;

	public boolean isFormat() {
		return format;
	}

	public void setFormat(boolean format) {
		this.format = format;
	}

	public DbConfig getDatabase() {
		return dbConfig;
	}

	public void setDatabase(DbConfig database) {
		this.dbConfig = database;
	}

	public EmailConfig getEmail() {
		return emailConfig;
	}

	public void setEmail(EmailConfig email) {
		this.emailConfig = email;
	}

}

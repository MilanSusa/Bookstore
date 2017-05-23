package rs.ac.bg.fon.ai.milansusa.bookstore.config;

public class Config {
	
	public boolean format;

	public DbConfig database;

	public boolean isFormat() {
		return format;
	}

	public void setFormat(boolean format) {
		this.format = format;
	}

	public DbConfig getDatabase() {
		return database;
	}

	public void setDatabase(DbConfig database) {
		this.database = database;
	}

}

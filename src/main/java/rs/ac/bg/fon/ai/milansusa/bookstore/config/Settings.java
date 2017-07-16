package rs.ac.bg.fon.ai.milansusa.bookstore.config;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Settings {

	private static final Logger logger = LogManager.getLogger(Settings.class);
	private static final String configFileName = "config.json";
	private static final String defaultConfigFilePath = "config/";

	private static String absoluteConfigPath = System.getProperty("user.home")
			+ File.separator + ".bookstore" + File.separator;
	private static Settings INSTANCE;

	private Gson gson;

	public Config config;

	public static Settings getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new Settings();
		}
		return INSTANCE;
	}

	private Settings() {
		gson = new GsonBuilder().setPrettyPrinting().create();
		try {
			loadConfig();
		} catch (Exception e) {
			logger.error("Could not load settings: ", e);
		}
	}

	private void loadConfig() throws Exception {
		String homeConfigFile = absoluteConfigPath + configFileName;

		try {
			File homeConfig = new File(homeConfigFile);
			if (homeConfig.exists()) {
				FileReader reader = new FileReader(homeConfigFile);
				config = gson.fromJson(reader, Config.class);
			}
			// otherwise, load the default config file
			else {
				loadDefaultConfig();
				if (config != null) {
					// and save it to the <USER_HOME> folder
					saveConfig();
				} else {
					throw new Exception();
				}
			}
			logger.info("Settings loaded!");
		} catch (FileNotFoundException fnfe) {
			throw new FileNotFoundException(
					"Could not open the configuration file: " + configFileName
							+ " - " + fnfe.getMessage());
		} catch (Exception e) {
			logger.error(e);
			throw new Exception("Could not serialize the configuration file: "
					+ configFileName, e);
		}
	}

	private void loadDefaultConfig() throws Exception {
		FileReader reader = null;
		try {
			// get path to config file
			URL url = Thread.currentThread().getContextClassLoader()
					.getResource(defaultConfigFilePath + configFileName);
			String path = url.getFile();
			reader = new FileReader(path);
			config = gson.fromJson(reader, Config.class);
		} catch (Exception e) {
			logger.error(e);
			throw new Exception("Could not read the config file: "
					+ configFileName, e);
		} finally {
			if (null != reader) {
				try {
					reader.close();
				} catch (IOException e) {
					logger.error("Could not close InputStream!", e);
				}
			}
		}
	}

	private void saveConfig() {
		logger.info("Saving settings...");
		String homeConfigFile = absoluteConfigPath + configFileName;
		File source = new File(homeConfigFile);

		// create dir
		new File(absoluteConfigPath).mkdirs();

		try {
			source.createNewFile();
			FileWriter writer = new FileWriter(homeConfigFile);
			String configString = gson.toJson(config);

			writer.write(configString);
			writer.close();

			logger.info("Settings saved!");
		} catch (Exception e) {
			logger.error("Could not save the configuration file: "
					+ configFileName, e);
		}
	}

}
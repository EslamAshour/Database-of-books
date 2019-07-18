package goinginfinity.task.utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

public class PropertiesReader {

	private static HashMap<String, String> configurations = null;
	private static String pathOfConfiguration = System.getProperty("user.dir") + "/src/configuration.properties";

	private PropertiesReader() {

	}

	public static String getValue(String key) {
		return getConfiguration().get(key);

	}

	private static HashMap<String, String> getConfiguration() {

		if (configurations == null) {
			configurations = getPathOfProject();
		}

		return configurations;
	}

	private static HashMap<String, String> getPathOfProject() {

		try {
			Properties prop = new Properties();

			prop.load(new FileReader(new File(pathOfConfiguration)));
			Set<Object> keys = prop.keySet();

			if (configurations != null && !configurations.isEmpty())
				return configurations;

			if (!keys.isEmpty())
				configurations = new HashMap<>();

			for (Object object : keys) {
				String value = prop.getProperty((String) object);
				configurations.put((String) object, value);
			}

			return configurations;
		} catch (IOException e) {
			System.out.println(e.getMessage());
			return null;
		}

	}

}

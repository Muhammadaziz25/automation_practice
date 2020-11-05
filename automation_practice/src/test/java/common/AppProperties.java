package common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 5.11.2020
 * @author Aziz Tokhirov
 *
 */

public class AppProperties {
	
	private static Properties properties = getProperties();
	
	public static final String BASE_URL = properties.getProperty("base_url");
	public static final String BROWSE_TYPE = properties.getProperty("browser_type");
	public static void main(String[] args) {
		getProperties();
	}

	private static Properties getProperties() {
		Properties properties = new Properties();
		
		try {
			String filePath = System.getProperty("user.dir")+"/src/test/resources/properties/config.properties";
			InputStream inputStream = new FileInputStream(filePath);
			properties.load(inputStream);
			System.out.println(properties.getProperty("base_url"));
		} catch (Exception e) {
			System.out.println("File not found");
			e.printStackTrace();
		}
		return properties;
	}
}

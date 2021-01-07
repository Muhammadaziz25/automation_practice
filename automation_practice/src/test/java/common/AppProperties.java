package common;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * 5.11.2020
 * @author Aziz Tokhirov
 *
 */

public class AppProperties {
	
	private static Properties properties = getProperties();
	
	public static final String BROWSER_TYPE = properties.getProperty("browser_type");
	public static final String AUTOMATION_PRACTICE_BASE_URL = properties.getProperty("automation_practice_base_url");
	public static final String THE_INTERNET_BASE_URL = properties.getProperty("the_internet_base_url");
	public static final String TEST_LEAF_BASE_URL = properties.getProperty("tets_leaf_base-url");
	
	public static void main(String[] args) {
		getProperties();
	}
	
	
	
	
	private static Properties getProperties() {
		Properties properties = new Properties();
		
		
		try {
			String filePath =System.getProperty("user.dir") + "/src/test/resources/properties/config.properties";
			InputStream inputStream = new FileInputStream(filePath);
			properties.load(inputStream);
			
			
			System.out.println(properties.getProperty("browser_type"));
		} catch (Exception e) {
			System.out.println("File not found");
			e.printStackTrace();
		}
		return properties;
	}

	
}

/*
 *  private static Properties properties = getProperties();
	
	public static final String TEST_LEAF_BASE_URL = properties.getProperty("tes_leaf_base_url");
	public static final String AUTOMATION_PRACTICE_BASE_URL = properties.getProperty("automation_practice_base_url");
	public static final String THE_INTERNET_BASE_URL= properties.getProperty("the_internet_base_url");
	public static final String BROWSE_TYPE = properties.getProperty("browse_type");
	
	
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
 */

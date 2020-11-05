package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import common.AppProperties;
import io.github.bonigarcia.wdm.WebDriverManager;


public class Driver {
	
	protected static WebDriver driver;
	
	static {
		if(driver == null)
		driver = getDriver(AppProperties.BROWSE_TYPE);
	}
	
	protected Driver() {
	
	}
	
	protected static WebDriver getDriver(String browserType) {
		WebDriver driver = null;
		switch (browserType) {
		case "chrome":
			driver = getChromeDriver();
			break;
		case "firefox":
			driver = getFirefoxDriver();
			break;
		default:
			System.out.println("Browser type " + browserType + " is invalid");
		}
		return driver;
	}
	
	protected static ChromeDriver getChromeDriver() {
//		WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Aziz Tokhirov\\webDrivers\\chromedriver.exe");
		return new ChromeDriver();
	}
	
	protected static FirefoxDriver getFirefoxDriver() {
//		WebDriverManager.firefoxdriver().setup();
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Aziz Tokhirov\\webDrivers\\chromedriver.exe");
		return new  FirefoxDriver();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	public static WebDriver getDriver(String browserType) {
//		WebDriver driver = null;
//		switch (browserType) {
//		case "chrome":
//			driver =  getChromeDriver();
//			break;
//		case "firefox":
//			driver = getFirefoxDriver();
//			break;
//		default:
//			System.out.println("Browser type " + browserType + " is invalid");
//			break;
//		}
//		
//		return driver;
//	}
//	
//	private static ChromeDriver getChromeDriver() {
//	
////		WebDriverManager.chromedriver().setup();
//		System.setProperty("webdriver.chrome.driver",
//				"C:\\Users\\Aziz Tokhirov\\webDrivers\\chromedriver.exe");
//		
//		return new ChromeDriver();
//	}
//	
//	private static FirefoxDriver getFirefoxDriver() {
////		WebDriverManager.firefoxdriver().setup();
//		System.setProperty("webdriver.gecko.driver",
//				"C:\\Users\\Aziz Tokhirov\\webDrivers\\geckodriver.exe");
//		
//		return new FirefoxDriver();
//	}

}

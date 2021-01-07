package driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import common.AppProperties;

public class Driver {

	protected static WebDriver driver;

	static {
		if (driver == null)
			driver = getDriver(AppProperties.BROWSER_TYPE);
	}

	protected Driver() {

	}

	protected static WebDriver getDriver(String browserType) {
		WebDriver driver = null;
		switch (browserType) {
		case "chrome":
			driver = getChromeDriver();
			driver.manage().window().maximize();
			break;
		case "firefox":
			driver = getFirefoxDriver();
			driver.manage().window().maximize();
			break;
		default:
			System.out.println("Browser type " + browserType + " is invalid");
			break;
		}
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		return driver;
	}

	protected static ChromeDriver getChromeDriver() {
//		WebDriverManager.chromedriver().setup();

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Aziz Tokhirov\\webDrivers\\chromedriver.exe");

		return new ChromeDriver();
	}

	protected static FirefoxDriver getFirefoxDriver() {
//		WebDriverManager.firefoxdriver().setup();

		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Aziz Tokhirov\\webDrivers\\geckodriver.exe");
		return new FirefoxDriver();
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

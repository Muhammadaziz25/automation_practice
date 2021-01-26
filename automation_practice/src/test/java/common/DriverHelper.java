package common;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverHelper {
	private WebDriver driver;
	private String mainWindowhandle;
	

	public DriverHelper(WebDriver driver) {
		this.driver = driver;
	}
	
	public void openUrl(String url) {
		driver.get(url);
		mainWindowhandle = driver.getWindowHandle();
	}

	public void waitForElementVisibility(By by, int timeOutInSeconds) {

		new WebDriverWait(driver, timeOutInSeconds).
		
		until(ExpectedConditions.visibilityOfElementLocated(by));

	}

	public WebElement getElement(By by, int timeOutInSeconds) {
		waitForElementVisibility(by, timeOutInSeconds);
		return driver.findElement(by);
	}

	public void click(By by, int timeOutInSeconds) {
		getElement(by, timeOutInSeconds).click();
	}

	public void sendKeys(By by, int timeOutInSeconds, String text) {
		getElement(by, timeOutInSeconds).sendKeys(text);
	}

	public String getText(By by, int timeOutInSeconds) {
		return getElement(by, timeOutInSeconds).getText();
	}
	
	public void takeScreenshot() {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File file = screenshot.getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(file, new File(System.getProperty("user.dir") +  
					"/target/screenshot/FileName" + System.currentTimeMillis() + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void switchToNewWindow() {
		
		Set<String> handles = driver.getWindowHandles();
		
		for(String h : handles) {
			if(h.equals(mainWindowhandle)) {
				System.out.println("driver will not run");
			} else {
				driver.switchTo().window(h);
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

//	public void takeScreenshot() {
//
//		TakesScreenshot screenshot = (TakesScreenshot) driver;
//		File file = screenshot.getScreenshotAs(OutputType.FILE);
//
//		try {
//			FileUtils.copyFile(file, new File(System.getProperty("user.dir") + "/target/screenshot" + "/FileName"
//					+ System.currentTimeMillis() + ".png"));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

}

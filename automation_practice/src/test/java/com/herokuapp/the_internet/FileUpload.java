package com.herokuapp.the_internet;

import java.nio.file.Paths;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import common.AppProperties;
import common.Common;
import common.DriverHelper;
import driver.Driver;

/**
 * November 25.2020
 * @author Aziz Tokhirov
 *
 */
public class FileUpload extends Driver {
	DriverHelper driverHelper = new DriverHelper(driver);
	
	@Test
	public void fileUpload() {	
		
		driver.get("http://the-internet.herokuapp.com/");
		driverHelper.waitForElementVisibility(By.xpath("//a[text()='File Upload']"), 10);
		driverHelper.takeScreenshot();
		
		driver.findElement(By.xpath("//a[text()='File Upload']")).click();
		
		String filePath = System.getProperty("user.dir") + "/src/test/resources/files/mbe.jpg";
		String fileName = Paths.get(filePath).getFileName().toString();
		System.out.println(fileName);
		driver.findElement(By.id("file-upload")).sendKeys(filePath);
		driverHelper.takeScreenshot();
		
		
		String uploadedFile = driver.findElement(By.id("file-upload")).getAttribute("value");
		System.out.println(uploadedFile);
		
		driver.findElement(By.id("file-submit")).click();
		
		String actualText = driver.findElement(By.tagName("h3")).getText();
		String expectedText = "File Uploaded!";
		Assert.assertEquals(actualText, expectedText);
		
		String actualUploadedFile = driver.findElement(By.id("uploaded-files")).getText();
		String expectedUploadedFile = "mbe.jpg";
		Assert.assertEquals(actualUploadedFile, expectedUploadedFile);
		
		driverHelper.takeScreenshot();
		
		
		Common.sleep(3);
		driver.quit();
		
		
		
		
		
		
		
//		driver.get(AppProperties.THE_INTERNET_BASE_URL);
//		driverHelper.waitForElementVisibility(By.xpath("//a[text()='File Upload']"), 20);
//		Common.sleep(2);
//		driver.findElement(By.xpath("//a[text()='File Upload']")).click();
//		Common.sleep(2);
//		
//		String filPath = System.getProperty("user.dir") + "/src/test/resources/files/MB.jpeg";
//		String fileName = Paths.get(filPath).getFileName().toString();
//		System.out.println(fileName);
//		
//		driver.findElement(By.id("file-upload")).sendKeys(filPath);
//		String uploadedFile = driver.findElement(By.id("file-upload")).getAttribute("value");
//		System.out.println(uploadedFile);
//		
//		driver.findElement(By.id("file-submit")).click();
//		
//		Common.sleep(5);
//		driver.quit();
		
		
		
		
		
	}
	/*
	 * driver.get(AppProperties.THE_INTERNET_BASE_URL);
		driverHelper.waitForElementVisibility(By.xpath("//a[text()='File Upload']"), 20);
		driverHelper.takeScreenshot();
		Common.sleep(2);
		driver.findElement(By.xpath("//a[text()='File Upload']")).click();
		driverHelper.takeScreenshot();
		
		String filePath = System.getProperty("user.dir") + "/src/test/resources/files/MB.jpeg";
		String fileName = Paths.get(filePath).getFileName().toString();
		driver.findElement(By.id("file-upload")).sendKeys(filePath);
		driverHelper.takeScreenshot();
		String uploadedFile = driver.findElement(By.id("file-upload")).getAttribute("value");
		uploadedFile = Paths.get(uploadedFile).getFileName().toString();
		//uploadedFile.substring(uploadedFile.lastIndexOf("\\") + 1);
		driver.findElement(By.id("file-submit")).click();
		driverHelper.takeScreenshot();
		String actualHeader = driver.findElement(By.tagName("h3")).getText();
		String expectedHeader = "File Uploaded!";
		Assert.assertEquals(fileName, uploadedFile);
		Assert.assertEquals(actualHeader, expectedHeader);
		System.out.println(uploadedFile);
		
		Common.sleep(5);
		driver.quit();
	 */
	
}



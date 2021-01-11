package com.herokuapp.testleaf;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import common.Common;
import driver.Driver;
/**
 * 12.11.2020
 * @author Aziz Tokhirov
 *
 */
public class Alert extends Driver{
	
	@Test(priority = 2)
	public void alert1() {
		 driver.get("http://testleaf.herokuapp.com/pages/Alert.html");
		 WebDriverWait driverWait = new WebDriverWait(driver, 10);
		 WebElement headerElement = driver.findElement(By.tagName("h1"));
		 
		 driverWait.until(ExpectedConditions.visibilityOf(headerElement));
		 String header = headerElement.getText();
		 Assert.assertEquals(header, "Handle Alerts");
		 System.out.println(header);
		 
		 Common.sleep(1);
		 WebElement alertButton = driver.findElement(By.xpath("//button[text()='Alert Box']"));
		 driverWait.until(ExpectedConditions.elementToBeClickable(alertButton));
		 alertButton.click();
		 
		 String alertText = driver.switchTo().alert().getText();
		 System.out.println(alertText);
		 Assert.assertEquals(alertText, "I am an alert box!");
		 Common.sleep(1);
		 driver.switchTo().alert().accept();
		 
		 
		 Common.sleep(3);
//		 driver.quit();
		 
		 
	}
	
	@Test(priority = 1)
	public void alert2() {
		driver.get("http://testleaf.herokuapp.com/pages/Alert.html");
		
		WebDriverWait driverWait = new WebDriverWait(driver, 10);
		WebElement confirmBox = driver.findElement(By.xpath("//button[text()='Confirm Box']"));
		driverWait.until(ExpectedConditions.elementToBeClickable(confirmBox));
		confirmBox.click();
		Common.sleep(2);
		
		String alertText = driver.switchTo().alert().getText();
		Assert.assertEquals(alertText, "Press a button!");
		
		driver.switchTo().alert().dismiss();
		Common.sleep(2);
		String pressedText = driver.findElement(By.id("result")).getText();
		Assert.assertEquals(pressedText, "You pressed Cancel!");
		
//		driver.switchTo().alert().accept();
//		Common.sleep(2);
//		String pressedText = driver.findElement(By.id("result")).getText();
//		Assert.assertEquals(pressedText, "You pressed OK!");
		
		Common.sleep(3);
//		driver.quit();
	}
	
	@Test(priority = 3)
	public void alert3() {
		driver.get("http://testleaf.herokuapp.com/pages/Alert.html");
		
		WebDriverWait driverWait = new WebDriverWait(driver, 10);
		WebElement confirmBox = driver.findElement(By.xpath("//button[text()='Prompt Box']"));
		driverWait.until(ExpectedConditions.elementToBeClickable(confirmBox));
		confirmBox.click();
		Common.sleep(2);
		
		String alertText = driver.switchTo().alert().getText();
		Assert.assertEquals(alertText, "Please enter your training institute name");
		
		String inputText = "Tech Centure Academy";
		driver.switchTo().alert().sendKeys(inputText);
		Common.sleep(1);
		driver.switchTo().alert().accept();
		String text = driver.findElement(By.id("result1")).getText();
		Assert.assertEquals(text, "You should not have enjoyed learning at "+ inputText 
				+" as compared to TestLeaf! Right?");
		Common.sleep(3);
		driver.quit();
	}
}

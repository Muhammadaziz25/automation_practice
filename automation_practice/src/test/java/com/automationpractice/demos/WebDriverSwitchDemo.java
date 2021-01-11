package com.automationpractice.demos;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import common.Common;
import driver.Driver;
/**
 * 10.11.2020
 * @author Aziz Tokhirov
 *
 */

public class WebDriverSwitchDemo extends Driver{

	@Test
	public void switchToIFrame() {
		driver.get("http://testleaf.herokuapp.com/pages/frame.html");
		
		Common.sleep(1);
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//button[@id='Click']")).click();
		driver.switchTo().defaultContent(); // navigates back to main HTML
		
		Common.sleep(1);
		driver.switchTo().frame(1);
		driver.switchTo().frame("frame2");
		driver.findElement(By.id("Click1")).click();
		
		Common.sleep(3);
		driver.quit();
		
	}
	
	@Test
	public void switchToAlert() {
		driver.get("http://testleaf.herokuapp.com/pages/Alert.html");
		
		WebDriverWait driverWait = new WebDriverWait(driver, 10);
		WebElement header = driver.findElement(By.xpath("//h1"));
		driverWait.until(ExpectedConditions.visibilityOf(header));
		
		String headerText = header.getText();
		Assert.assertEquals(headerText, "Handle Alerts");
		
		driver.findElement(By.xpath("//button[preceding::label[text()='Click the button to display a alert box.']]")).click();
		Common.sleep(1);
		driver.switchTo().alert().accept();
		
//		driver.findElement(By.xpath("//button[text()='Confirm Box']")).click();
//		Common.sleep(1);
//		driver.switchTo().alert().dismiss();
//		
//		driver.findElement(By.xpath("//button[text()='Prompt Box']")).click();
//		Common.sleep(1);
//		driver.switchTo().alert().sendKeys("Don't be sad");
//		Common.sleep(2);
//		driver.switchTo().alert().accept();
//		
//		driver.findElement(By.xpath("//button[text()='Line Breaks?']")).click();
//		String alertText = driver.switchTo().alert().getText();
//		System.out.println(alertText);
//		Common.sleep(1);
//		driver.switchTo().alert().accept();
		Common.sleep(2);
		driver.quit();
		
	}
	
	@Test
	public void switchToWindow() { 
		driver.get("http://testleaf.herokuapp.com/pages/Window.html");
		String handle = driver.getWindowHandle();
		
		driver.findElement(By.xpath("//button[@id='home']")).click();
		
		Set<String> handles1 = driver.getWindowHandles();
		for (String handles : handles1) {
			System.out.println(handles);
			
			if(handles.equals(handle)) {
				System.out.println("First window");
			}else {
				driver.switchTo().window(handles);
			}
		}
		driver.findElement(By.xpath("//h5[text()='Image']")).click();
		
		Common.sleep(3);
		driver.quit();
		
		
		
		
		
		
		
		
		
	}
	
	/**
	 * driver.get("http://testleaf.herokuapp.com/pages/Window.html");
		String handle = driver.getWindowHandle();
		
		
		driver.findElement(By.id("home")).click();
		Common.sleep(1);
		
		
//		String handle2 = driver.getWindowHandle();
//		System.out.println(handle2);
		
		Set <String> handles = driver.getWindowHandles();
		for (String string : handles) {
			if(string.equals(handle)) {
				System.out.println("this is first window, so not switching...");
			}else {
				driver.switchTo().window(string);
			}
		}
		
		
		Common.sleep(1);
		driver.findElement(By.xpath("//a[child::h5[text()='Image']]")).click();
		
		Common.sleep(3);
		driver.quit();
	 */
}

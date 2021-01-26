package com.automationpractice.demos;

import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import common.Common;
import driver.Driver;

public class WebDriverSwitchWindow extends Driver{
	
	@Test
	public void switchToNewWindow() {
		driverHelper.openUrl("http://testleaf.herokuapp.com/pages/Window.html");
		String handle1 = driver.getWindowHandle();
		driver.findElement(By.id("home")).click();
		driverHelper.waitForElementVisibility(By.id("home"), 10);
		
		Set<String> handles = driver.getWindowHandles();
		for(String h : handles) {
			if(h.equals(handle1)) {
				System.out.println("driver will not change");
			}else {
				driver.switchTo().window(h);
			}
		}
		
		driver.findElement(By.xpath("//h5[text()='Table']")).click();
		
		Common.sleep(3);
		driver.quit();
	}

}

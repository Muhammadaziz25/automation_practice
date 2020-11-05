package com.automationpractice_userregis;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import common.AppProperties;
import common.Common;
import driver.Driver;

/**
 * 5.11.2020
 * @author Aziz Tokhirov
 *
 */
public class User_Registration extends Driver {

	public static void main(String[] args) {
//		WebDriver driver = getDriver(AppProperties.BROWSE_TYPE);
		driver.get("http://automationpractice.com/index.php");
		driver.findElement(By.cssSelector("[class='login']")).click();
		Common.sleep(1);
		driver.findElement(By.id("email_create")).sendKeys(Common.getRandomEmail("dell", "hewlett"));
		
		Common.sleep(2);
		driver.quit();

	}

}

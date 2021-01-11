package com.automationpractice_userregis;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import common.AppProperties;
import common.Common;
import common.DriverHelper;
import driver.Driver;

/**
 * 5.11.2020
 * @author Aziz Tokhirov
 *
 */
public class User_Registration extends Driver {
	
	DriverHelper driverHelper = new DriverHelper(driver);
	int timeOutInSeconds = 20;

	
	@Test
	public void userReg() {
//		WebDriver driver = getDriver(AppProperties.BROWSE_TYPE);
		driver.get(AppProperties.AUTOMATION_PRACTICE_BASE_URL);
//		driver.findElement(By.cssSelector("[class='login']")).click();
		driverHelper.click(By.cssSelector("[class='login']"), timeOutInSeconds);
		Common.sleep(1);
		String firstName = Common.getRandomFirstname();
		String lastName = Common.getRandomLastname();
		String email = Common.getRandomEmail(firstName,lastName );
		driver.findElement(By.id("email_create")).sendKeys(email);
		Common.sleep(2);
		driver.findElement(By.id("SubmitCreate")).click();
//		driverHelper.takeScreenshot();
			
		Common.sleep(2);
		String actualText = driver.findElement(By.xpath("//h1[text()='Create an account']")).getText();
		System.out.println(actualText);
		String expectedText = "CREATE AN ACCOUNT";
		Assert.assertEquals(actualText, expectedText, "Validation failed");
		
		Common.sleep(3);
		driver.quit();

	}

}

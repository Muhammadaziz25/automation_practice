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
 * 11.11.2020
 * @author Aziz Tokhirov
 *
 */
public class RadioButton extends Driver{

	@Test
	/**
	 * TestNG method cannot be static
	 */
	public void test1() {
		
		driver.get("http://testleaf.herokuapp.com/pages/radio.html");
		Common.sleep(1);
		WebDriverWait driverWait = new WebDriverWait(driver, 20);
		WebElement yesButton= driver.findElement(By.id("yes"));
		driverWait.until(ExpectedConditions.visibilityOf(yesButton));
		yesButton.click();
		
		boolean isYesButtonSelected = yesButton.isSelected();
		
		Assert.assertTrue(isYesButtonSelected, "Yes button is not selected");
//		if(isYesButtonSelected) {
//		}else {
//			System.out.println("Yes button is not selected");
//		}
		
		
		Common.sleep(3);
		driver.quit();
		
		
	}
}

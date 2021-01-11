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
 * 
 * @author Aziz Tokhirov
 *
 */
public class RadioButton extends Driver {

	@Test
	/**
	 * TestNG method cannot be static
	 */
	public static void test1() {

		driver.get("http://testleaf.herokuapp.com/pages/radio.html");
		Common.sleep(1);
		WebDriverWait driverWait = new WebDriverWait(driver, 15);

		WebElement yesButton = driver.findElement(By.id("yes"));
		WebElement noButton = driver.findElement(By.id("no"));

		driverWait.until(ExpectedConditions.visibilityOf(yesButton));
		yesButton.click();
		boolean isYesSelected = yesButton.isSelected();

		Assert.assertTrue(isYesSelected, "Unchecked button is not selected");

//		if( !isYesSelected) {
//			Assert.fail("Yes button is not selected");
//		}

		Common.sleep(3);
		driver.quit();
	}
	
	@Test
	public void test2() {
		driver.get("http://testleaf.herokuapp.com/pages/radio.html");
		WebDriverWait driverWait = new WebDriverWait(driver, 20);
		
		WebElement uncheckedButton = driver.findElement(By.xpath("(//input[@name='news'])[1]"));
		WebElement checkedButton = driver.findElement(By.xpath("(//input[@name='news'])[2]"));
		
		driverWait.until(ExpectedConditions.visibilityOf(uncheckedButton));
		boolean isUncheckedButtonSelected = uncheckedButton.isSelected();
//		Assert.assertTrue(isYesButtonSelected, "Yes button is not seleced");
		
		driverWait.until(ExpectedConditions.visibilityOf(checkedButton));
		boolean isCheckedButtonSelected = checkedButton.isSelected();
//		Assert.assertTrue(isNoButtonSelected, "No button is not seleced");
		System.out.println("Unchecked button is defaut selected? " + isUncheckedButtonSelected);
		System.out.println("Checked button is defaut selected? " + isCheckedButtonSelected);
		
		Common.sleep(3);
		driver.quit();
	}
}

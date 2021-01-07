package com.automationpractice.demos;

import org.openqa.selenium.By;

import common.Common;
import driver.Driver;

public class XPathDemo extends Driver {

	public static void main(String[] args) {

		driver.get("http://automationpractice.com/");
		driver.findElement(By.xpath("(//a[@title='T-shirts'])[2]")).click();
		Common.sleep(1);
		driver.findElement(By.xpath("(//a[contains(text(),'Terms and conditions of use')])")).click();
		
		Common.sleep(3);
		driver.quit();
	}

}

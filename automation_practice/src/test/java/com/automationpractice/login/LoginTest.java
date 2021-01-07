package com.automationpractice.login;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import common.Common;
import driver.Driver;

public class LoginTest extends Driver{
	
	@Test
	// https://dl.bintray.com/testng-team/testng-eclipse-release/
	public void login_invalid_email() {
		driver.get("http://automationpractice.com/index.php");
		driver.findElement(By.className("login")).click();
		Common.sleep(1);
		driver.findElement(By.id("email")).sendKeys("ejvneýnv@veonveo.com");
		Common.sleep(1);
		driver.findElement(By.id("SubmitLogin")).click();
		String erroMessage = driver.findElement(By.xpath("//p[text()='There is 1 error']")).getText();
		System.out.println(erroMessage);
		
		Assert.assertEquals(erroMessage, "There is 1 error");
		
		Common.sleep(3);
		driver.quit();
	}

}

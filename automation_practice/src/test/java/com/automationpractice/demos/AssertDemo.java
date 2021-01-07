package com.automationpractice.demos;

import org.testng.Assert;
import org.testng.annotations.Test;
/**
 * 10.11.2020
 * @author Aziz Tokhirov
 *
 */
public class AssertDemo {
	
	@Test
	public void test1(){
		String a = "asd";
		String s = "asd";
		
		boolean b = true;
		Assert.assertEquals(b, true);
		
		Assert.assertEquals(a, s);
	}
}

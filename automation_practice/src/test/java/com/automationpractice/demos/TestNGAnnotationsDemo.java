package com.automationpractice.demos;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestNGAnnotationsDemo {
	
	@Test
	public void test1() {
		System.err.println("Test1");
	}
	
	@Test
	public void test2() {
		System.err.println("Test2");
		
	}
	
	@BeforeMethod
	public void before() {
		System.out.println("Runs Before test");
	}
	
	@AfterMethod
	public void after() {
		System.out.println("Runs After test");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("Runs before class");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("Runs after class");
	}
	
	@BeforeSuite
	public void beforeSuit() {
		System.out.println("Runs before suit");
	}
	
	

}

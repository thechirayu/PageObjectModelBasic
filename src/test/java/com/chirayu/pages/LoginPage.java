package com.chirayu.pages;

import org.openqa.selenium.By;

import com.chirayu.base.Page;


public class LoginPage extends Page {
	
	
	public ZohoAppPage login(String username, String password) throws InterruptedException
	{
		driver.findElement(By.id(OR.getProperty("Email_Login"))).sendKeys(username);
		
		driver.findElement(By.id(OR.getProperty("NextButton"))).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.id(OR.getProperty("Password_Login"))).sendKeys(password);
		
		driver.findElement(By.id(OR.getProperty("NextButton"))).click();
		
		
		return new ZohoAppPage();
		
		
	}

}

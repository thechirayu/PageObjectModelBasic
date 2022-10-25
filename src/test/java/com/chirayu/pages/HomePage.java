package com.chirayu.pages;

import org.openqa.selenium.By;


import com.chirayu.base.Page;

public class HomePage extends Page {
	
	
	
	
	
	

	public LoginPage goToLogin() throws InterruptedException
	{
		System.out.println("In Login");
		driver.findElement(By.xpath(OR.getProperty("SignInLink"))).click();
		
		Thread.sleep(2000);
		
		return new LoginPage();
		
		
	}

}

package com.chirayu.crm.accounts;

import org.openqa.selenium.By;

import com.chirayu.base.Page;

public class AccountsPage extends Page {
	
	

	public void createAccount() throws InterruptedException
	{
		driver.findElement(By.xpath(OR.getProperty("CreateAccounButtom"))).click();
		
		driver.findElement(By.id(OR.getProperty("AccountName_Field"))).sendKeys("Demo");
		
		driver.findElement(By.id(OR.getProperty("PhoneNumber_Field"))).sendKeys("+919785420412");
		
		Thread.sleep(5000);
	}
	
	public void importAccount()
	{
		
	}

}

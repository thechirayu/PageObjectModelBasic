package com.chirayu.crm.accounts;

import org.openqa.selenium.By;

import com.chirayu.base.Page;

public class AccountsPage extends Page {
	
	public AccountsPage() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	public void createAccount()
	{
		driver.findElement(By.xpath(OR.getProperty("CreateAccounButtom"))).click();
		
		driver.findElement(By.id(OR.getProperty("AccountName_Field"))).sendKeys("Demo");
		
		driver.findElement(By.id(OR.getProperty("PhoneNumber_Field"))).sendKeys("+919785420412");;
	}
	
	public void importAccount()
	{
		
	}

}

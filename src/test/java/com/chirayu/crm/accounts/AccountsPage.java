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
	}
	
	public void importAccount()
	{
		
	}

}

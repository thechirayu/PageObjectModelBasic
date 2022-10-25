package com.chirayu.pages;

import org.openqa.selenium.By;

import com.chirayu.base.Page;

public class ZohoAppPage extends Page {
	
	public void goToCRM()
	{
		driver.findElement(By.xpath(OR.getProperty("CRM_App"))).click();
	}

}

package com.chirayu.base;

import org.openqa.selenium.By;

public class TopMenu extends Page {
	
	
	
	public static void gotoMenu(String menuName)
	{
		
		
		driver.findElement(By.xpath("//div/a[text()='"+menuName+"']")).click();
		
		
	}

}

package com.chirayu.rough;

import org.openqa.selenium.WebDriver;


import com.chirayu.base.TopMenu;
import com.chirayu.crm.accounts.AccountsPage;
import com.chirayu.pages.HomePage;
import com.chirayu.pages.LoginPage;
import com.chirayu.pages.ZohoAppPage;



public class LoginTest {
	
	static WebDriver driver;
	
	public static void main(String[] args) throws Exception {
		
		
		
		HomePage home = new HomePage();
		LoginPage log = home.goToLogin();
		
		Thread.sleep(3000);		
		
		ZohoAppPage app = log.login("chirayumaheshwari09@gmail.com", "Fastrack123.");
				
		app.goToCRM();
		
		Thread.sleep(5000);
		
		TopMenu.gotoMenu("Accounts");
		
		Thread.sleep(3000);
		
		AccountsPage account =  new AccountsPage();
		
		account.createAccount();
		
		
		
		
		
		
	}

}

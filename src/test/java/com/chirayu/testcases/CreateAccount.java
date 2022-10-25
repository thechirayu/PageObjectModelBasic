package com.chirayu.testcases;

import org.testng.annotations.Test;

import com.chirayu.base.TopMenu;
import com.chirayu.crm.accounts.AccountsPage;
import com.chirayu.pages.ZohoAppPage;

public class CreateAccount {
	
	@Test
	public void createAccountTest() throws Exception {

		Thread.sleep(3000);
		
		

		ZohoAppPage app = new ZohoAppPage();

		app.goToCRM();

		Thread.sleep(5000);

		TopMenu.gotoMenu("Accounts");

		Thread.sleep(3000);

		AccountsPage account = new AccountsPage();

		account.createAccount();
	}

}

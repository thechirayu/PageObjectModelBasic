package com.chirayu.testcases;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.chirayu.base.Page;
import com.chirayu.pages.HomePage;
import com.chirayu.pages.LoginPage;
import com.chirayu.utilities.TestUtil;


public class LoginTest extends Page {
	
	@Test(dataProviderClass= TestUtil.class, dataProvider="dp")
	public void doLogin(Hashtable<String, String> table) throws Exception
	{
		HomePage home = new HomePage();
		LoginPage log = home.goToLogin();
		
		log.login(table.get("username"), table.get("password"));
		
		Thread.sleep(3000);	
	}

}

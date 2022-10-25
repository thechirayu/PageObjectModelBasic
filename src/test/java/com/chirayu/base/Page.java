package com.chirayu.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.chirayu.utilities.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Page {

	public static WebDriver driver;
	public static Properties OR, config;

	public static FileInputStream fis;

	public static Logger log1 = Logger.getLogger("Bank Project");

	public static String sheetName;

	public static XSSFWorkbook worksheet;

	public static XSSFSheet sheet;

	public static Row row;

	public static Cell cell;

	public static Alert alert1;

	public static WebDriverWait wait;

	public static Date d = new Date();

	public static String dateFormatted = d.toString().replace(":", "_").replace(" ", "_").replace("IST", "");

	public static ExtentReports rep = ExtentManager.getInstanceReports();

	public static ExtentTest test;

	public Page() {
		if (driver == null) {

			WebDriverManager.chromedriver().setup();

			ChromeOptions opt = new ChromeOptions();

			opt.addArguments("--disable-notifications");

			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			opt.setExperimentalOption("prefs", prefs);

			opt.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
			opt.setExperimentalOption("useAutomationExtension", false);

			driver = new ChromeDriver(opt);

			driver.get("https://www.zoho.com/");

			driver.manage().window().maximize();

			driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
		}

	}

	@BeforeSuite
	public void setup() throws IOException {
		PropertyConfigurator
				.configure("D:\\Eclipse Workspace\\PageObjectModelBasics\\src\\test\\resources\\prop\\log4j.properties");
		OR = new Properties();
		/*config = new Properties();
		System.out.println("Hello");
		fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\prop\\config.properties");
		config.load(fis);
		log1.info("Config loaded");*/

		fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\prop\\OR.properties");
		OR.load(fis);
		log1.info("OR loaded");
		
		ExtentSparkReporter html =  ExtentManager.getInstanceHTML();
		wait= new WebDriverWait(driver, Duration.ofSeconds(20));
		
		rep.attachReporter(html);
	}
	
	@AfterSuite
	public void tearDown()
	{
		driver.quit();
		rep.flush();
	}

	public static void selectMethod(WebElement e, String value) {
		Select select = new Select(e);
		System.out.println("In select method");
		select.selectByVisibleText(value);
	}

}

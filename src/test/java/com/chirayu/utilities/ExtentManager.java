package com.chirayu.utilities;

import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	
	private static ExtentReports report;
	private static ExtentSparkReporter html;
	
	
	public static ExtentSparkReporter getInstanceHTML() throws IOException
	{
		html= new ExtentSparkReporter(new File("D:\\Eclipse Workspace\\PageObjectModelBasics\\src\\test\\resources\\extentreport\\extent.html"));
		html.loadXMLConfig("D:\\Eclipse Workspace\\PageObjectModelBasics\\src\\test\\resources\\extentconfig\\extentconfig.xml");
		
		System.out.println("Extent success");
		
		return html;
	}
	
	public static ExtentReports getInstanceReports()
	{
		report = new ExtentReports();
		
		
		return report;
	}

}

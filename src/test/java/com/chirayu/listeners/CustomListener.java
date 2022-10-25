package com.chirayu.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.chirayu.base.Page;
import com.chirayu.utilities.TestUtil;



public class CustomListener extends Page implements ITestListener {

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test = rep.createTest(result.getName());
		
		System.out.println("Test case executing is: "+result.getName());

		
		

	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub

		Markup m = MarkupHelper.createLabel("Test Case: " + result.getName(), ExtentColor.GREEN);

		test.pass(m);

		System.out.println("Hurray... Test Case Pass..!!!!!!!!!!!!!!!!!!!!");

	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test case failed");

		// test.log(Status.FAIL, "Failed with exception: "+result.getThrowable());
		try {
			TestUtil.screenshotUtil();
			System.out.println("I am in try");
			Markup m = MarkupHelper.createLabel("Test Case: " + result.getName(), ExtentColor.RED);

			test.fail(m);

			test.addScreenCaptureFromPath("C:\\Users\\chira\\Pictures\\" + TestUtil.dateFormatted + ".jpg");

			// test.log(Status.FAIL, (Markup)
			// test.addScreenCaptureFromPath("C:\\Users\\chira\\Pictures\\"+TestUtil.dateFormatted+".jpg"));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
		Markup m = MarkupHelper.createLabel("Test Case: "+result.getName(), ExtentColor.YELLOW);
		
		test.skip(m);
		
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

}

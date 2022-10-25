 package com.chirayu.utilities;

import java.io.File;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Hashtable;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;
import com.chirayu.base.Page;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class TestUtil extends Page {

	

	public static void screenshotUtil() throws IOException {

		File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(f, new File("C:\\Users\\chira\\Pictures\\" + dateFormatted + ".jpg"));

	}

	public static void ashotAPIScreenshot() throws IOException {

		Screenshot sc = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(2000)).takeScreenshot(driver);

		System.out.println(
				System.getProperty("user.dir") + "\\src\\test\\resources\\screenshots\\" + dateFormatted + ".jpg");

		ImageIO.write(sc.getImage(), ".jpg", new File("C:\\Users\\chira\\Pictures\\" + dateFormatted + ".jpg"));
	}

	public static boolean runMode(String testName) throws Exception {

		Hashtable<String, String> table = new Hashtable<String, String>();

		Object[][] data = ExcelReader.excelReader("runMode");

		for (int i = 1; i <= data.length; i++) {
			for (int j = 0; j < 1; j++) {
				table.put(data[i - 1][j].toString().toLowerCase(), data[i - 1][j + 1].toString().toLowerCase());

			}
		}

		System.out.println(table);
		System.out.println("In runMode method: "+testName);
		System.out.println(table.get(testName.toLowerCase()));

		if (table.get(testName.toLowerCase()).equalsIgnoreCase("y")) {
			return true;
		} else {
			return false;
		}

	}

	@DataProvider(name = "dp")
	public static Object[][] excelReader(Method m) throws Exception {

		String sheetValue = m.getName();

		Object[][] data = ExcelReader.excelReader(sheetValue);

		return data;
	}

}

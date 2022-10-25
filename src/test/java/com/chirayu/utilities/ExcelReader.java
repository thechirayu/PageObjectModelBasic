package com.chirayu.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Hashtable;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.chirayu.base.Page;

public class ExcelReader extends Page {
	public static File f;

	

	public static Object[][] excelReader(String sheetValue) throws Exception {

		f = new File("D:\\Eclipse Workspace\\PageObjectModelBasics\\src\\test\\resources\\excel\\Data.xlsx");

		System.out.println("This is sheet value: "+sheetValue);

		

		fis = new FileInputStream(f);

		worksheet = new XSSFWorkbook(fis);

		int sheetCount = worksheet.getNumberOfSheets();

		System.out.println(sheetCount);

		for (int i = 0; i < sheetCount; i++) {
			System.out.println(worksheet.getSheetName(i));
			if (worksheet.getSheetName(i).equalsIgnoreCase(sheetValue)) {
				sheet = worksheet.getSheetAt(i);
				sheetName = worksheet.getSheetName(i);
				break;
			}
		}

		int rowCount = sheet.getLastRowNum();
		row = sheet.getRow(0);

		int colCount = row.getLastCellNum();

		Object[][] data = new Object[rowCount][1];
		
		Hashtable<String , String> table;

		for (int i = 1; i <= rowCount; i++) {
			row = sheet.getRow(i);
			
			table =  new Hashtable<String, String>();

			for (int j = 0; j < colCount; j++) {
				
				//table.put(row.getCell(cellnum, value);
				table.put(getCellValue(sheetValue,0,j), getCellValue(sheetValue, i, j));
				
				data[i-1][0] = table;

			}
		}

		return data;
			
	}
	
	public static String getCellValue(String sheetValue, int rowNum, int colNum)
	{
		int sheetCount = worksheet.getNumberOfSheets();
		
		for(int i =0;i<sheetCount;i++)
		{
			if(worksheet.getSheetName(i).equalsIgnoreCase(sheetValue))
			{
				worksheet.getSheetAt(i);
				break;
			}
		}
		
		String cellValue = sheet.getRow(rowNum).getCell(colNum).toString();
		
		return cellValue;
		
	}

	/**/
}



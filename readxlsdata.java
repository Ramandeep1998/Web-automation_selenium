package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import jdk.internal.org.objectweb.asm.commons.Method;

public class readxlsdata {

//	public static void main(String[] args) throws IOException {
//		readxlsdata rr = new readxlsdata();
//		rr.getdata("login");
//	}
	
	@DataProvider(name = "logintestdata")
	
	public static String[][] getdata() throws IOException {
		try {	
		String excelsheetname="login";
		
			File f = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\Testdata.xlsx");
			FileInputStream fis = new FileInputStream(f); // obtaining bytes from the file
			// creating Workbook instance that refers to .xlsx file
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheet(excelsheetname);

			int totalrows = sheet.getLastRowNum();
			System.out.println(totalrows);
			Row rowcell = sheet.getRow(0);
			int totalcols = rowcell.getLastCellNum();
			System.out.println(totalcols);

			String testdata[][] = new String[totalrows][totalcols];

			DataFormatter format = new DataFormatter();
			for (int i = 1; i <= totalrows; i++) {
				for (int j = 0; j < totalcols; j++) {
					testdata[i - 1][j] = format.formatCellValue(sheet.getRow(i).getCell(j));
					System.out.println(testdata[i - 1][j]);
					
				}
				System.out.println("=================");
			}
			
			return testdata;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return null;
		
		
	}

}

package utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Hashtable;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

import base.Page;

public class TestUtil extends Page{
	public static String screenshotName;

	@DataProvider(name = "dp")
	public static Object[][] getData(Method m){
		String sheetName = m.getName();
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);
		Object[][] data = new Object[rows-1][1];
		
		Hashtable<String, String> table = null;
		
		for(int rowNum=2; rowNum<=rows; rowNum++) {
			
			table = new Hashtable<String, String>();
			
			for(int colNum=0; colNum<cols; colNum++) {
				table.put(excel.getCellData(sheetName, colNum, 1), excel.getCellData(sheetName, colNum, rowNum));
				data[rowNum-2][0] = table;
				
			}
		}
		return data;
	}
	
	public static boolean isTestCaseRunnable(String testName, ExcelReader excel) {
		// 通过修改excel中RUNMODE下的字符，来决定是否执行目标用例（Y为执行）
		String sheetName = "testcases";
		int rows = excel.getRowCount(sheetName);
		for(int rowNum=2; rowNum<=rows; rowNum++) {
			String testCase = excel.getCellData(sheetName, "TCID", rowNum);
			if (testCase.equalsIgnoreCase(testName)) {
				String mode = excel.getCellData(sheetName, "RUNMODE", rowNum);
				if (mode.equalsIgnoreCase("Y"))
					return true;
				return false;
			}
		}
		return false;
	}
	
	public static void captureScreenshot() throws IOException {
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Date date = new Date();
		screenshotName = date.toString().replace(":", "-").replace(" ", "-") + ".jpg";
		FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir") + "\\test-output\\html\\" + screenshotName));
	}
}














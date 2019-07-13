package base;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import javax.sound.midi.Track;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import utilities.ExcelReader;
import utilities.ExtentManager;

public class Page {
	public static WebDriver driver;
	public static Logger log = Logger.getLogger("pagefactory");
	public static ExtentReports rep = ExtentManager.getInstance();
	public static ExtentTest test;
	public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\testdata.xlsx");
	
	public static void initConfiguration() {
		
		PropertyConfigurator.configure(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\log4j.properties");
		
		if (Constants.browser.equals("chrome")) {
			driver = new ChromeDriver();
		}else if (Constants.browser.equals("firefox")) {
			driver = new FirefoxDriver();
		}else if (Constants.browser.equals("ie")) {
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.get(Constants.url);
		driver.manage().timeouts().implicitlyWait(Constants.TIMTOUT, TimeUnit.SECONDS);
		
		String info = "打开浏览器" + Constants.browser + ", 获取网址ַ" + Constants.url;
		log.info(info);
		Reporter.log(info);
	}
	public static void veryfyElementsLenghthEqual(int actual, int expected) {
		try {
			Assert.assertEquals(actual, expected);
		} catch (AssertionError e) {
			e.printStackTrace();
		}
	}
	public static boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			return false;
		}
	}
	public static void switchHandle(int num) {
		int handleNum = driver.getWindowHandles().size();
		if (handleNum>1) {
			if (num<handleNum) {
				String[] handles = new String[handleNum];
				driver.getWindowHandles().toArray(handles);
				driver.switchTo().window(handles[num]);
			}
		}
	}
	
	public static void quitBrowser() {
		if (driver!=null) {
			driver.quit();
			
			String info = "关闭浏览器。";
			log.info(info);
			Reporter.log(info);
		}
	}

}

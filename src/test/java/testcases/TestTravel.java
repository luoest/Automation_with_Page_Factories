package testcases;

import static org.testng.Assert.fail;

import java.util.Hashtable;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import base.Page;
import pages.actions.TopMenuActions;
import utilities.TestUtil;

public class TestTravel extends Page{

	@Test(dataProviderClass=TestUtil.class, dataProvider="dp")
	public void testTravel(Hashtable<String, String> data) {
		
		if (!TestUtil.isTestCaseRunnable("TestTravel", excel)) {
			throw new SkipException("忽略本用例：" + "TestTravel".toUpperCase());
		}
		
		String infoMethodStart = "进入TestTravel测试。";
		log.info(infoMethodStart);
		Reporter.log(infoMethodStart);
		
		initConfiguration();
		TopMenuActions menu = new TopMenuActions();
		menu.gotoTravel().gotoThemeTravel();
		switchHandle(1);
		isElementPresent(By.linkText(data.get("页面元素")));
		String infoMethodEnd = "TestTravel测试完成！";
		log.info(infoMethodEnd);
		Reporter.log(infoMethodEnd);
		
	}
	@AfterMethod
	public void tearDown() {
		quitBrowser();
	}
}

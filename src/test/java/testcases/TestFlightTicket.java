package testcases;

import java.util.Hashtable;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import base.Page;
import pages.actions.HomePageActions;
import utilities.TestUtil;

public class TestFlightTicket extends Page{

	@Test(dataProviderClass=TestUtil.class, dataProvider="dp")
	public void testFlightTicket(Hashtable<String, String> data) throws InterruptedException {
		
		if (!TestUtil.isTestCaseRunnable("TestFlightTicket", excel)) {
			throw new SkipException("忽略本用例：" + "TestFlightTicket".toUpperCase());
		}
		
		String infoMethodStart = "进入HomePage测试。";
		log.info(infoMethodStart);
		Reporter.log(infoMethodStart);
		
		initConfiguration();
		HomePageActions home = new HomePageActions();
		int actualChoices = home.homePageChoicesList();
		veryfyElementsLenghthEqual(actualChoices, 7);
		home.ClickFlightTicket().bookFlightTicket(data.get("出发地"), data.get("目的地"), data.get("出发日期"), data.get("返回日期"));
		isElementPresent(By.partialLinkText(data.get("页面元素")));
		
		String infoMethodEnd = "testHomePage测试完成！";
		log.info(infoMethodEnd);
		Reporter.log(infoMethodEnd);
	}
	
	@AfterMethod
	public void tearDown() {
		quitBrowser();
	}
}

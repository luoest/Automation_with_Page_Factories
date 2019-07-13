package pages.actions;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Reporter;

import com.mysql.cj.api.log.Log;
import com.relevantcodes.extentreports.LogStatus;

import base.Page;
import pages.locators.TopMenuLocators;

public class TopMenuActions {

	TopMenuLocators topMenuLocators = null;
	public TopMenuActions() {
		this.topMenuLocators = new TopMenuLocators();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(Page.driver, 10);
		PageFactory.initElements(factory, this.topMenuLocators);
	}
	
	public TravelActions gotoTravel() {
		// 点击导航条上的“旅游”选项
		topMenuLocators.travel.click();
		
		String gotoTravelInfo = "点击：" + topMenuLocators.travel;
		Page.test.log(LogStatus.INFO, gotoTravelInfo);
		Reporter.log(gotoTravelInfo);
		Page.log.info(gotoTravelInfo);
		
		return new TravelActions();
	}
}

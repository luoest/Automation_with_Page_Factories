package pages.actions;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Reporter;

import com.relevantcodes.extentreports.LogStatus;

import base.Page;
import pages.locators.TravelLocators;

public class TravelActions extends Page{

	TravelLocators travelLocators = null;
	public TravelActions() {
		this.travelLocators = new TravelLocators();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this.travelLocators);
	}
	
	public void gotoThemeTravel() {
		// 点选旅游页面中的“主题旅游”
		travelLocators.themetravel.click();
		
		String gotoThemeTravelInfo = "点击：" + travelLocators.themetravel;
		test.log(LogStatus.INFO, gotoThemeTravelInfo);
		Reporter.log(gotoThemeTravelInfo);
		log.info(gotoThemeTravelInfo);
	}
}

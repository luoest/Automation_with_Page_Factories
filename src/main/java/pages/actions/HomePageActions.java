package pages.actions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;

import com.relevantcodes.extentreports.LogStatus;

import base.Page;
import pages.locators.HomePageLocators;

public class HomePageActions extends Page{

	HomePageLocators homePageLocators = null;
	public HomePageActions() {
		this.homePageLocators = new HomePageLocators();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this.homePageLocators);
	}
	public int homePageChoicesList() {
		return homePageLocators.homePageChoices.size();
	}
	
	public HomePageActions ClickFlightTicket() {
		homePageLocators.flightTicket.click();
		return this;
	}
	
	
	public void bookFlightTicket(String startCity, String destCity, String startDate, String returnDate) throws InterruptedException {
		TimeUnit.SECONDS.sleep(1);
		homePageLocators.doubleFlight.click();
		String doubleFlightInfo = "点击元素：" + homePageLocators.doubleFlight;
		test.log(LogStatus.INFO, doubleFlightInfo);
		log.info(doubleFlightInfo);
		Reporter.log(doubleFlightInfo);
		
		TimeUnit.SECONDS.sleep(1);
		homePageLocators.startCity.sendKeys(startCity);
		String startCityInfo = "发送：" + startCity + ", 到元素：" + homePageLocators.startCity;
		test.log(LogStatus.INFO, startCityInfo);
		log.info(startCityInfo);
		Reporter.log(startCityInfo);
		
		TimeUnit.SECONDS.sleep(1);
		homePageLocators.destCity.sendKeys(destCity);
		String destCityInfo = "发送：" + destCity + ", 到元素：" + homePageLocators.destCity;
		test.log(LogStatus.INFO, destCityInfo);
		log.info(destCityInfo);
		Reporter.log(destCityInfo);
		
		TimeUnit.SECONDS.sleep(1);
		homePageLocators.startDate.sendKeys(startDate);
		String startDateInfo = "发送：" + startDate + ", 到元素：" + homePageLocators.startDate;
		test.log(LogStatus.INFO, startDateInfo);
		log.info(startDateInfo);
		Reporter.log(startDateInfo);
		
		TimeUnit.SECONDS.sleep(1);
		homePageLocators.returnDate.sendKeys(returnDate);
		String returnDateInfo = "发送：" + returnDate + ", 到元素：" + homePageLocators.returnDate;
		test.log(LogStatus.INFO, returnDateInfo);
		log.info(returnDateInfo);
		Reporter.log(returnDateInfo);
		
		TimeUnit.SECONDS.sleep(1);
		homePageLocators.hasBaby.click();
		String hasBabyInfo = "点击元素：" + homePageLocators.hasBaby;
		test.log(LogStatus.INFO, hasBabyInfo);
		log.info(hasBabyInfo);
		Reporter.log(hasBabyInfo);
		
		TimeUnit.SECONDS.sleep(1);
		homePageLocators.hasChild.click();
		String hasChildInfo = "点击元素：" + homePageLocators.hasChild;
		test.log(LogStatus.INFO, hasChildInfo);
		log.info(hasChildInfo);
		Reporter.log(hasChildInfo);
		
		TimeUnit.SECONDS.sleep(1);
		homePageLocators.startSearch.click();
		String startSearchInfo = "点击元素：" + homePageLocators.startSearch;
		test.log(LogStatus.INFO, startSearchInfo);
		log.info(startSearchInfo);
		Reporter.log(startSearchInfo);
	}
}

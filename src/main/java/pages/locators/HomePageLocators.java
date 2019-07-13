package pages.locators;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageLocators {
	// 所有按钮元素
	@FindBy(xpath="//ul[@id='searchBoxUl']/li")
	public List<WebElement> homePageChoices;

	// 酒店按钮
	@FindBy(css="li[styletag=\"hotel\"]")
	public WebElement hotel;
	
	// 机票按钮
	@FindBy(css="li[styletag=\"flight\"]")
	public WebElement flightTicket;
	
	// 旅游按钮
	@FindBy(css="li[styletag=\"vacation\"]")
	public WebElement vacation;
	
	// 双程
	@FindBy(css="input[mm='D']")
	public WebElement doubleFlight;
	
	@FindBy(css="#FD_StartCity")
	public WebElement startCity;
	
	@FindBy(css="#FD_DestCity")
	public WebElement destCity;
	
	@FindBy(css="#FD_StartDate")
	public WebElement startDate;
	
	@FindBy(css="#FD_ReturnDate")
	public WebElement returnDate;
	
	@FindBy(css="#FD_HasChild")
	public WebElement hasChild;
	
	@FindBy(css="#FD_HasBaby")
	public WebElement hasBaby;
	
	// ������Ʊ
	@FindBy(css="input[id='FD_StartSearch']")
	public WebElement startSearch;
	
	
	
}

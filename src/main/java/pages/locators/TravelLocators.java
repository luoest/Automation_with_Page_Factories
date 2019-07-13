package pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TravelLocators {

	@FindBy(xpath = "//a[contains(text(),'主题旅游')]")
	public WebElement themetravel;
	
	@FindBy(xpath = "//a[contains(text(),'欧洲')]")
	public WebElement europe;
	
	@FindBy(xpath = "//a[contains(text(),'美洲')]")
	public WebElement america;
}

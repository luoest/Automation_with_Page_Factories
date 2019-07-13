package pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class TopMenuLocators {

	// 导航条
	@FindBy(css = "c_ph_hp")
	public WebElement home;
	
	@FindBy(css = "nav_hotel")
	public WebElement hotel;
	
	@FindBy(how=How.ID, using="nav_vac")
	public WebElement travel;
	
	@FindBy(how=How.ID, using="nav_gentuan")
	public WebElement group;
}

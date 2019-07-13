package rough;

import base.Page;
import pages.actions.HomePageActions;

public class TestHomePage extends Page{

	public static void main(String[] args) throws InterruptedException {
		initConfiguration();
		HomePageActions home = new HomePageActions();
		int choices = home.homePageChoicesList();
		System.out.println("共有选项：" + choices);
		home.ClickFlightTicket().bookFlightTicket("北京", "上海", "2019-07-17", "2019-07-27");;
		
	}
}

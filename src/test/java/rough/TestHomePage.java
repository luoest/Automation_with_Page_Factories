package rough;

import base.Page;
import pages.actions.HomePageActions;

public class TestHomePage extends Page{

	public static void main(String[] args) throws InterruptedException {
		initConfiguration();
		HomePageActions home = new HomePageActions();
		int choices = home.homePageChoicesList();
		System.out.println("����ѡ�" + choices);
		home.ClickFlightTicket().bookFlightTicket("����", "�Ϻ�", "2019-07-17", "2019-07-27");;
		
	}
}

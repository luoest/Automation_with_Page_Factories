package rough;

import base.Page;
import pages.actions.TopMenuActions;

public class TestTravel extends Page{

	public static void main(String[] args) {
		initConfiguration();
		TopMenuActions menu = new TopMenuActions();
		menu.gotoTravel().gotoThemeTravel();
	}
}

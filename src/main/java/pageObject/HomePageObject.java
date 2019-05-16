package pageObject;

import org.openqa.selenium.WebDriver;


import PageUis.HomePageUI;

import PageUis.NewCustomerPageUI;
import commons.AbstractPage;

public class HomePageObject extends AbstractPage {
	WebDriver driver;
	public HomePageObject(WebDriver driverMaping) {
		driver= driverMaping;
}
	public boolean isHomePageDisplay() {
			waitForElementVisible(driver, HomePageUI.HOMEPAGE_WELCOME_MESAGE);
			return(isControlDisplayed(driver, HomePageUI.HOMEPAGE_WELCOME_MESAGE));
			 
		}
	public NewCustomerPageObject openCustomerPage() {
		waitForElementVisible(driver, HomePageUI.NEW_CUSTOM_PAGE_LINK);
		clickToElement(driver, HomePageUI.NEW_CUSTOM_PAGE_LINK);
		return PageFactoryManage.getNewCustomerPage(driver);
		 
	}
	public boolean isNewCustomerUnDisplay() {
		waitForElementInVisible(driver, NewCustomerPageUI.TITLE_CUSTOMER_PAGE);
		return(isControlUnDisplayed(driver, NewCustomerPageUI.TITLE_CUSTOMER_PAGE));
		 
	}
}

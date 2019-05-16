package pageObject;

import org.openqa.selenium.WebDriver;

import PageUis.AbstractPageUI;
import PageUis.DepositPageUI;
import PageUis.HomePageUI;
import PageUis.NewAccountPageUI;
import commons.AbstractPage;

public class BalanceEnquiryPageObject extends AbstractPage {
	WebDriver driver;
	public BalanceEnquiryPageObject(WebDriver driverMaping) {
		driver= driverMaping;
	}
	public boolean BalanceSuccess(String AccountID) {
		return isControlDisplayed_Dynamic(driver, "Balance Details for Account "+AccountID);	 
	 
	}
	
	public String getAmount(String value) {
		waitToElementVisible(driver, AbstractPageUI.DYNAMIC_TEXT, value);
		return (getTextElement_Dynamic(driver, AbstractPageUI.DYNAMIC_TEXT, value));
	}

}
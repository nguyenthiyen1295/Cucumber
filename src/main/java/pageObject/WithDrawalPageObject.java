package pageObject;

import org.openqa.selenium.WebDriver;

import PageUis.AbstractPageUI;
import PageUis.DepositPageUI;
import PageUis.HomePageUI;
import PageUis.NewAccountPageUI;
import commons.AbstractPage;

public class WithDrawalPageObject extends AbstractPage {
	WebDriver driver;
	public WithDrawalPageObject(WebDriver driverMaping) {
		driver= driverMaping;
		
	}
	
	public Boolean isWithdrawPageDisplayed() {
		waitForElementVisible(driver, DepositPageUI.TITLE_DEPOSIT);
		return(isControlDisplayed(driver, DepositPageUI.TITLE_DEPOSIT));
		 
	}
	
	public boolean withdrawSuccess(String AccountID) {
		return isControlDisplayed_Dynamic(driver, "Transaction details of Withdrawal for Account "+AccountID);	 
	 
	}
	
	public String getAmount(String value) {
		waitToElementVisible(driver, AbstractPageUI.DYNAMIC_TEXT, value);
		return (getTextElement_Dynamic(driver, AbstractPageUI.DYNAMIC_TEXT, value));
	}
	
}
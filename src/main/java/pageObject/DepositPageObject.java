package pageObject;

import org.openqa.selenium.WebDriver;

import PageUis.AbstractPageUI;
import PageUis.DepositPageUI;
import PageUis.HomePageUI;
import PageUis.NewAccountPageUI;
import commons.AbstractPage;

public class DepositPageObject extends AbstractPage {
	WebDriver driver;
	public DepositPageObject(WebDriver driverMaping) {
		driver= driverMaping;
		
	}
	public FundTransferPageObject openTransferpage() {
			waitForElementVisible(driver, DepositPageUI.FUND_PAGE_LINK);
			clickToElement(driver, DepositPageUI.FUND_PAGE_LINK);
			return PageFactoryManage.getFundsPage(driver);
			 
		}
	
	public Boolean isDepositPageDisplayed() {
		waitForElementVisible(driver, DepositPageUI.TITLE_DEPOSIT);
		return(isControlDisplayed(driver, DepositPageUI.TITLE_DEPOSIT));
		 
	}
	
	public boolean DepositSuccess(String AccountID) {
		System.out.println("Transaction details of Deposit for Account "+AccountID);
		return isControlDisplayed_Dynamic(driver, "Transaction details of Deposit for Account "+AccountID);	 
	 
	}
	
	public String getAmount(String value) {
		waitToElementVisible(driver, AbstractPageUI.DYNAMIC_TEXT, value);
		return (getTextElement_Dynamic(driver, AbstractPageUI.DYNAMIC_TEXT, value));
	}
	
	public void scrollMenu() {
		waitForElementVisible(driver, DepositPageUI.TITLE_DEPOSIT);
		scrollToBottomPage(driver);
		 
	}
}
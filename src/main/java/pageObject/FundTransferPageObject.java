package pageObject;

import org.openqa.selenium.WebDriver;

import PageUis.AbstractPageUI;
import PageUis.DepositPageUI;
import PageUis.FundTransferPageUI;
import PageUis.HomePageUI;
import commons.AbstractPage;

public class FundTransferPageObject extends AbstractPage {
	WebDriver driver;
	public FundTransferPageObject(WebDriver driverMaping) {
		driver= driverMaping;
	}
	
	public boolean TransferSuccess(String AccountID) {
		System.out.println("Fund Transafer Details for Account No: "+AccountID);
		return isControlDisplayed_Dynamic(driver, "Fund Transafer Details for Account No: "+AccountID);	 
	 
	}
	
	public String getAmount(String value) {
		waitToElementVisible(driver, AbstractPageUI.DYNAMIC_TEXT, value);
		return (getTextElement_Dynamic(driver, AbstractPageUI.DYNAMIC_TEXT, value));
	}
	
}
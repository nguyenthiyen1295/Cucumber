package pageObject;

import org.openqa.selenium.WebDriver;

import PageUis.AbstractPageUI;
import PageUis.HomePageUI;
import PageUis.NewAccountPageUI;
import PageUis.NewCustomerPageUI;
import commons.AbstractPage;

public class NewAccountPageObject extends AbstractPage {

	WebDriver driver;

	public NewAccountPageObject(WebDriver driverMaping) {
		driver = driverMaping;
		
	}

	public DepositPageObject openDepositpage() {
		waitForElementVisible(driver, NewAccountPageUI.DEPOSIT_LINK);
		clickToElement(driver, NewAccountPageUI.DEPOSIT_LINK);
		return PageFactoryManage.getDepositPage(driver);

	}

	public Boolean isNewAccountPageDisplayed() {
		waitForElementVisible(driver, NewAccountPageUI.TITLE_ACCOUNT_PAGE);
		return (isControlDisplayed(driver, NewAccountPageUI.TITLE_ACCOUNT_PAGE));

	}
	
	public String getAmount(String value) {
		waitToElementVisible(driver, AbstractPageUI.DYNAMIC_TEXT, value);
		return (getTextElement_Dynamic(driver, AbstractPageUI.DYNAMIC_TEXT, value));
	}

	public void isSelectedAccountType() {
		isControlSelected(driver, NewAccountPageUI.DYNAMIC_SELECT);
	}

	public boolean AddAccountSuccess() {
		return isControlDisplayed_Dynamic(driver, "Account Generated Successfully!!!");
	}

}
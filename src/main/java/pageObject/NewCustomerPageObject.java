package pageObject;

import org.openqa.selenium.WebDriver;

import PageUis.AbstractPageUI;
import PageUis.HomePageUI;
import PageUis.NewCustomerPageUI;
import PageUis.RegisterPageUI;
import commons.AbstractPage;

public class NewCustomerPageObject extends AbstractPage {
	WebDriver driver;
	public NewCustomerPageObject(WebDriver driverMaping) {
		driver= driverMaping;
		
	}
	public NewAccountPageObject openNewAccountpage() {
			waitForElementVisible(driver,NewCustomerPageUI.NEW_ACCOUNT_PAGE_LINK);
			clickToElement(driver, NewCustomerPageUI.NEW_ACCOUNT_PAGE_LINK);
			return PageFactoryManage.getNewAccountPage(driver);
			 
		}
	
	public Boolean isNewCustomerPageDisplayed() {
		waitForElementVisible(driver, NewCustomerPageUI.TITLE_CUSTOMER_PAGE);
		return(isControlDisplayed(driver, NewCustomerPageUI.TITLE_CUSTOMER_PAGE));
		 
	}
	
	public boolean isHomePageDisplay() {
		waitForElementVisible(driver, HomePageUI.HOMEPAGE_WELCOME_MESAGE);
		return(isControlDisplayed(driver, HomePageUI.HOMEPAGE_WELCOME_MESAGE));
		 
	}
	
	public boolean isAddCustomerFormDisplay() {
		waitForElementInVisible(driver,NewCustomerPageUI.CUSTOMER_FORM);
		return(isControlUnDisplayed(driver, NewCustomerPageUI.CUSTOMER_FORM));		
	}
	
	public boolean isAddCustomerSuccess() {
		waitForElementVisible(driver,NewCustomerPageUI.CUSTOMER_TITLE_SUCCESS);
		return(isControlDisplayed(driver, NewCustomerPageUI.CUSTOMER_TITLE_SUCCESS));		
	}
	
	public boolean isHomePageUnDisplay() {
		waitForElementInVisible(driver, HomePageUI.HOMEPAGE_WELCOME_MESAGE);
		return(isControlUnDisplayed(driver, HomePageUI.HOMEPAGE_WELCOME_MESAGE));
		 
	}
	
	public String getAccount_Created(String value) {
		waitToElementVisible(driver, AbstractPageUI.DYNAMIC_TEXT, value);
		return (getTextElement_Dynamic(driver, AbstractPageUI.DYNAMIC_TEXT, value));
	}
}
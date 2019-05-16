package pageObject;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import commons.AbstractPage;

public class DeleteAccountPageObject extends AbstractPage {
	WebDriver driver;
	public DeleteAccountPageObject(WebDriver driverMaping) {
		driver= driverMaping;
	}
	public boolean BalanceSuccess(String AccountID) {
		return isControlDisplayed_Dynamic(driver, "Balance Details for Account "+AccountID);	 
	 
	}
	
	public void DeleteAccountSuccess() {
		Assert.assertEquals(getTextAlert(driver), "Account Deleted Sucessfully");
		 acceptAlert(driver);
		 
	}
}
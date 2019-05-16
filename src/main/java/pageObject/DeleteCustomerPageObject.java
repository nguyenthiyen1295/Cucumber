package pageObject;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import commons.AbstractPage;

public class DeleteCustomerPageObject extends AbstractPage {
	WebDriver driver;
	public DeleteCustomerPageObject(WebDriver driverMaping) {
		driver= driverMaping;
	}
	public boolean BalanceSuccess(String AccountID) {
		return isControlDisplayed_Dynamic(driver, "Balance Details for Account "+AccountID);	 
	 
	}
	
	public void DeleteCustomerSuccess() throws InterruptedException {
		Thread.sleep(5000);
		Assert.assertEquals(getTextAlert(driver), "Customer deleted Successfully");
		 acceptAlert(driver);
	}
}
package pageObject;

import org.openqa.selenium.WebDriver;

import PageUis.AbstractPageUI;
import commons.AbstractPage;

public class EditCustomerPageObject extends AbstractPage {
	WebDriver driver;
	public EditCustomerPageObject(WebDriver driverMaping) {
		driver= driverMaping;
	}
	
	public boolean isEditCustomerPageDisplay() {
		return isControlDisplayed_Dynamic(driver, "Edit Customer Form");	 
	}
	public boolean EditCustomerSuccess() {
		return isControlDisplayed_Dynamic(driver, "Customer details updated Successfully!!!");	 
	}
}
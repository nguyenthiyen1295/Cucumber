package pageObject;

import org.openqa.selenium.WebDriver;

import PageUis.LoginPageUI;
import PageUis.RegisterPageUI;
import commons.AbstractPage;

public class RegisterPageObject extends AbstractPage {
	WebDriver driver;

	public RegisterPageObject(WebDriver driverMaping) {
		driver = driverMaping;
		
	}

	public void inputoEmailTextbox(String email) {

		waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, email);
	}

	public void clickOnButton() throws InterruptedException {
		waitForElementVisible(driver, RegisterPageUI.SUBMIT_BUTTON);
		if(driver.toString().toLowerCase().contains("internetExplorer")) {
			clickToElementByJS(driver, RegisterPageUI.SUBMIT_BUTTON);
			Thread.sleep(5000);
			}else
				clickToElement(driver, RegisterPageUI.SUBMIT_BUTTON);
		}
	public String getUserIDText() {
		waitForElementVisible(driver, RegisterPageUI.USER_ID_TEXT);
		return (getTextElement(driver, RegisterPageUI.USER_ID_TEXT));
	}

	public String getPassWordText() {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXT);
		return (getTextElement(driver, RegisterPageUI.PASSWORD_TEXT));
	}

	public LoginPagesObject openUrl(String url) {
		openUrl(driver, url);
		return PageFactoryManage.getLoginpage(driver);

	}

	public int randomNumberEmail() {
		return random();
	}
}

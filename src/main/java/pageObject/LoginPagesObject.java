package pageObject;

import org.openqa.selenium.WebDriver;

import PageUis.LoginPageUI;
import commons.AbstractPage;


public class LoginPagesObject extends AbstractPage {
	WebDriver driver;
	
	public String getCurrentUrl() {
		return getCurentUrl(driver);
		
	}
	public LoginPagesObject(WebDriver driverMaping) {
		driver= driverMaping;
		
		
	}
	
	public void inputToUserTextbox(String UserID) {
		waitForElementVisible(driver, LoginPageUI.USERID_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.USERID_TEXTBOX, UserID);
	}
	public void inputToPasswordTextbox(String passWord) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, passWord);
		
	}
	
	public HomePageObject clickToLoginButton() {
		waitForElementVisible(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageFactoryManage.getHomePage(driver);
		                         
		
	}
	public RegisterPageObject clickToHereLink() throws InterruptedException {
		waitForElementVisible(driver, LoginPageUI.HERE_LINK);
		if(driver.toString().toLowerCase().contains("internetExplorer")) {
		clickToElementByJS(driver, LoginPageUI.HERE_LINK);
		Thread.sleep(5000);
		}else {
			clickToElement(driver, LoginPageUI.HERE_LINK);
			}
			return PageFactoryManage.getRegisterpage(driver);	
	}
	
	public void scrollToBottomPage() {
		scrollToBottomPage(driver);
	}
	
}
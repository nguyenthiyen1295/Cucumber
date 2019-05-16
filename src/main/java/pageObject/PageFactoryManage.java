package pageObject;

import org.openqa.selenium.WebDriver;

public class PageFactoryManage {
	
	public static LoginPagesObject getLoginpage(WebDriver driver) {
		return new LoginPagesObject(driver);
	}
	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
		
	}
	
	public static RegisterPageObject getRegisterpage(WebDriver driver) {
		return new RegisterPageObject(driver);
	}
	
	public static NewCustomerPageObject getNewCustomerPage(WebDriver driver) {
		return new NewCustomerPageObject(driver);
	}
	
	public static NewAccountPageObject getNewAccountPage(WebDriver driver) {
		return new NewAccountPageObject(driver);
	}
	
	public static DepositPageObject getDepositPage(WebDriver driver) {
		return new DepositPageObject(driver);
	}
	
	public static FundTransferPageObject getFundsPage(WebDriver driver) {
		return new FundTransferPageObject(driver);
	}
	public static EditCustomerPageObject getEditCustomerPage(WebDriver driver) {
		return new EditCustomerPageObject(driver);
	}
	public static WithDrawalPageObject getWithdrawPage(WebDriver driver) {
		return new WithDrawalPageObject(driver);
	}
	public static BalanceEnquiryPageObject getBalancePage(WebDriver driver) {
		return new BalanceEnquiryPageObject(driver);
	}
	public static DeleteAccountPageObject getDeleteAccountPage(WebDriver driver) {
		return new DeleteAccountPageObject(driver);
	}
	public static DeleteCustomerPageObject getDeleteCustomerPage(WebDriver driver) {
		return new DeleteCustomerPageObject(driver);
	}
}

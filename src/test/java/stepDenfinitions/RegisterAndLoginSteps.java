package stepDenfinitions;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegisterAndLoginSteps {
	String url, userID, password, customer_ID;

	WebDriver driver;

	@Given("^I open application$")
	public void iOpenApplication() {
		driver = new FirefoxDriver();
		driver.get("http://demo.guru99.com/v3");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		url = driver.getCurrentUrl();

	}

	@Given("^I get Login page Url$")
	public void iGetLoginPageUrl() {
		driver.get(url);

	}

	@Given("^I click to here link$")
	public void iClickToHereLink() {
		driver.findElement(By.xpath("//a[text()='here']")).click();

	}

	@Given("^I input to email textbox with data \"([^\"]*)\"$")
	public void iInputToEmailTextboxWithData(String email) {
		email = "yent" + random() + "@gmail.com";
		driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys(email);

	}

	@Given("^I click to Submit button at Register page$")
	public void iClickToSubmitButtonAtRegisterPage() {
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
	}

	@Then("^I get UserID infor$")
	public void iGetUserIDInfor() {
		userID = driver.findElement(By.xpath("//td[contains(text(),'User ID :')]//following-sibling::td")).getText();
	}

	@Then("^I get Password infor$")
	public void iGetPasswordInfor() {
		password = driver.findElement(By.xpath("//td[contains(text(),'Password :')]//following-sibling::td")).getText();

	}

	@When("^I open login page again$")
	public void iOpenLoginPageAgain() {
		driver.get(url);

	}

	@When("^I input to Username textbox$")
	public void iInputToUsernameTextbox() {
		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(userID);

	}

	@When("^I input to Password textbox$")
	public void iInputToPasswordTextbox() {
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);

	}

	@When("^I click to Login button at Login page$")
	public void iClickToLoginButtonAtLoginPage() {
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();

	}

	@Then("^Verify Home page displayed with message \"([^\"]*)\"$")
	public void verifyHomePageDisplayedWithMessage(String message) {
		Assert.assertTrue(driver.findElement(By.xpath("//marquee[text()=\"" + message + "\"]")).isDisplayed());

	}

	@Given("^I open New Customer page$")
	public void iOpenNewCustomerPage() {
		driver.findElement(By.xpath("//a[text()='New Customer']")).click();

	}

	@When("^Input to New Customer form with data$")
	public void inputToNewCustomerFormWithData(DataTable newCustomerTable) {
		List<Map<String, String>> customer = newCustomerTable.asMaps(String.class, String.class);
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys(customer.get(0).get("Name"));
		driver.findElement(By.xpath("//input[@name='dob']")).sendKeys(customer.get(0).get("DateOfBirth"));
		driver.findElement(By.xpath("//textarea[@name='addr']")).sendKeys(customer.get(0).get("Address"));
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys(customer.get(0).get("City"));
		driver.findElement(By.xpath("//input[@name='state']")).sendKeys(customer.get(0).get("State"));
		driver.findElement(By.xpath("//input[@name='pinno']")).sendKeys(customer.get(0).get("Pin"));
		driver.findElement(By.xpath("//input[@name='telephoneno']")).sendKeys(customer.get(0).get("Phone"));
		driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys(customer.get(0).get("EMail")+random()+"@gmail.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(customer.get(0).get("Password"));

	}

	@When("^I click to Submit button at New Customer page$")
	public void iClickToSubmitButtonAtNewCustomerPage() {
		driver.findElement(By.xpath("//input[@name='sub']")).click();

	}

	@Then("^Verify message displayed with data \"([^\"]*)\"$")
	public void verifyMessageDisplayedWithData(String message) {
		Assert.assertTrue(driver.findElement(By.xpath("//p[text()='" + message + "']")).isDisplayed());

	}

	@Then("^I verify all above infomation created success$")
	public void iVerifyAllAboveInfomationCreatedSuccess(DataTable getCustomerTable) {
		List<Map<String, String>> getcustomer = getCustomerTable.asMaps(String.class, String.class);
		Assert.assertEquals(
				driver.findElement(By.xpath("//td[text()='Customer Name']//following-sibling::td")).getText(),
				getcustomer.get(0).get("Name"));
//		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Birthdate']//following-sibling::td")).getText(),
//				getcustomer.get(0).get("DateOfBirth"));
//		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Address']//following-sibling::td")).getText(),
//				getcustomer.get(0).get("Address"));
//		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='City']//following-sibling::td")).getText(),
//				getcustomer.get(0).get("City"));
//		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='State']//following-sibling::td")).getText(),
//				getcustomer.get(0).get("State"));
//		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Pin']//following-sibling::td")).getText(),
//				getcustomer.get(0).get("Pin"));
//		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Mobile No.']//following-sibling::td")).getText(),
//				getcustomer.get(0).get("Phone"));

	}

	@When("^I get Customer ID at New Customer page$")
	public void iGetCustomerIDAtNewCustomerPage() {
		customer_ID = driver.findElement(By.xpath("//td[text()='Customer ID']//following-sibling::td")).getText();

	}
	public int random() {
		Random random = new Random();
		return (random.nextInt(9999));
	}
}
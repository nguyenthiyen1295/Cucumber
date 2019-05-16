package stepDenfinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class Live_Guru_Login {
	WebDriver driver;
	@Given("^I want to open live app$")
	public void iWantToOpenLiveApp() {
		driver = new FirefoxDriver();
		driver.get("http://live.guru99.com/index.php/customer/account/login/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@When("^I input data to textbox \"([^\"]*)\"$")
	public void iInputDataToTextbox(String email) {
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(email);

	}
	@When("^Input password to textbox\"([^\"]*)\"$")
	public void inputPasswordToTextbox(String password) {
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(password);

	}

	@When("^Click on to button$")
	public void clickOnToButton() {
		driver.findElement(By.xpath("//button[@title='Login']")).click();

	}

}

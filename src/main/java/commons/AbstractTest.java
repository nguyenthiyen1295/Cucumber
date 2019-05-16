package commons;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AbstractTest {
	private WebDriver driver;
	protected final Log log;
	
	public AbstractTest() {
		log = LogFactory.getLog(getClass());
	}

	protected WebDriver openedMultiBrowser(String browserName) {
		if (browserName.equals("chrome")) {
			//System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
			WebDriverManager.chromedriver().version("2.46").setup();
			driver = new ChromeDriver();
		} 
		else if 
		 (browserName.equals("chromeheadless")) {
			WebDriverManager.chromedriver().version("2.46").setup();
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("headless");
			chromeOptions.addArguments("window-size=1920x1080");
			driver = new ChromeDriver(chromeOptions);
		}
		else if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().arch64().setup();
			driver = new FirefoxDriver();
		}
		else if (browserName.equals("firefoxheadless")) {
			WebDriverManager.firefoxdriver().arch64().setup();
			driver = new FirefoxDriver();
		}
		else if (browserName.equals("ie")) {
			WebDriverManager.iedriver().arch32().setup();
			driver = new InternetExplorerDriver();
		}
		
		driver.get(Constants.DEV_URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}

	protected int random() {
		Random a = new Random();
		int number = a.nextInt(999999);
		return number;
	}

	private boolean checkPassed(boolean condition) {
		boolean pass = true;
		try {
			if (condition == true)
				log.info("===PASSED===");
			else 
				log.info("===FAILED===");
			Assert.assertTrue(condition);
			
		} catch (Throwable e) {
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}
	
    protected boolean verifyTrue(boolean condition) {
    	return checkPassed(condition);
    }
    
    private boolean checkFailed(boolean condition) {
    	boolean pass = true;
    	try {
    		if( condition == true)
    			Assert.assertFalse(condition);
    	}catch(Throwable e) {
    		pass = false;
    		VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
	
    	}
    	return pass;
    }
    
    protected boolean verifyFalse(boolean condition) {
    	return checkFailed(condition);
    }
    
    private boolean checkEquals(Object actual, Object expected) {
    	boolean pass = true;
    	boolean status;
		
		try {
			if(actual instanceof String && expected instanceof String){
				actual = actual.toString().trim();
				expected = expected.toString().trim();
		         status = (actual.equals(expected));
			}else {
				status = (actual == expected);
			}
			if (status) {
				log.info("===PASSED===");
			} else {
				log.info("===FAILED===");
				Assert.assertEquals(actual, expected);
			}
			Assert.assertEquals(actual, expected, "Value is not matching!");
		} catch (Throwable e) {
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}
    protected boolean verifyEquals(Object actual, Object expected) {
    	return checkEquals(actual, expected);
    }  
    
    protected void closeBrowserAndDriver(WebDriver driver) {
    	try {
			String osName = System.getProperty("os.name").toLowerCase();
			log.info("OS name = " + osName);
			driver.manage().deleteAllCookies();

			String cmd = "";
			if (driver != null) {
				driver.quit();
			}

			if (driver.toString().toLowerCase().contains("chrome")) {
				if (osName.toLowerCase().contains("mac")) {
					cmd = "pkill chromedriver";
				} else if (osName.toLowerCase().contains("windows")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq chromedriver*\"";
				}
				Process process = Runtime.getRuntime().exec(cmd);
				process.waitFor();
			}
			if (driver.toString().toLowerCase().contains("internetexplorer")) {
				if (osName.toLowerCase().contains("window")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq IEDriverServer*\"";
					Process process = Runtime.getRuntime().exec(cmd);
					process.waitFor();
				}
			}
			log.info("---------- QUIT BROWSER SUCCESS ----------");
		} catch (Exception e) {
			log.info(e.getMessage());
		}
	}
}
package commons;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import PageUis.AbstractPageUI;
import PageUis.HomePageUI;
import pageObject.PageFactoryManage;

public class AbstractPage {

	// Web browser//
	public void openUrl(WebDriver driver, String url) {
		driver.get(url);
	}

	public String getCurentUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}

	public void backPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void forWardPage(WebDriver driver) {
		driver.navigate().forward();
	}

	public void reFreshPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();

	}

	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();

	}

	public String getTextAlert(WebDriver driver) {
		return driver.switchTo().alert().getText();

	}

	public void sendTextAlert(WebDriver driver, String value) {
		driver.switchTo().alert().sendKeys(value);

	}

	// WebElement
	public void clickToElement(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.click();
	}

	public void clickToButton_Dynamic(WebDriver driver, String locator, String... DynamicValue) {
		locator = String.format(locator, (Object[]) DynamicValue);
		By byLocator = By.xpath(locator);
		System.out.println(byLocator);
		WebDriverWait waitExplicit;
		waitExplicit = new WebDriverWait(driver, 10);
		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(byLocator));
		WebElement element = driver.findElement(byLocator);
		element.click();
	}

	// Function này cover được case có trong DOM và khong visible.
	public boolean isControlUnDisplayed(WebDriver driver, String locator) {
		Date date = new Date();
		System.out.println("Started time= " + date.toString());
		overrideGlobalTimeOut(driver, shortTimeOut);
		List<WebElement> elements = driver.findElements(By.xpath(locator));
		if (elements.size() > 0 && elements.get(0).isDisplayed()) {
			date = new Date();
			System.out.println("End time = " + date.toString());
			overrideGlobalTimeOut(driver, longTimeOut);
			return false;
		} else {
			date = new Date();
			System.out.println("End time = " + date.toString());
			overrideGlobalTimeOut(driver, longTimeOut);
			return true;
		}

	}

	// Function này cover được case có trong DOM và khong visible.
	public boolean isControlUnDisplayed_Dynamic(WebDriver driver, String locator, String... value) {
		Date date = new Date();
		System.out.println("Started time= " + date.toString());
		overrideGlobalTimeOut(driver, shortTimeOut);
		locator = String.format(locator, (Object[]) value);
		List<WebElement> elements = driver.findElements(By.xpath(locator));
		if (elements.size() > 0 && elements.get(0).isDisplayed()) {
			date = new Date();
			System.out.println("End time = " + date.toString());
			overrideGlobalTimeOut(driver, longTimeOut);
			return false;
		} else {
			date = new Date();
			System.out.println("End time = " + date.toString());
			overrideGlobalTimeOut(driver, longTimeOut);
			return true;
		}

	}

//	Funtion nàu chỉ cover được case element khong  có trong DOM.
	// public boolean isControlUnDisplayed(WebDriver driver, String locator,
	// String...value) {
//		Date date = new Date();
//		System.out.println("Started time= "+date.toString());
//		overrideGlobalTimeOut(driver,shortTimeOut);
//		locator = String.format(locator, (Object[])value);
//		List<WebElement> elements = driver.findElements(By.xpath(locator));
//		if(elements.size() == 0) {
//			date = new Date();
//			System.out.println("End time = "+date.toString());
//			overrideGlobalTimeOut(driver, longTimeOut);
//			return true;
//		} else {
//			date = new Date();
//			System.out.println("End time = "+date.toString());
//			overrideGlobalTimeOut(driver, longTimeOut);
//			return false;
//		}
//		 
//	}
	public void overrideGlobalTimeOut(WebDriver driver, int timeOut) {
		driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);

	}

	public void clickToLink(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.click();
	}

	public void clickToCheckbox(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.click();
	}

	public void sendKeyToElement_Dynamic(WebDriver driver, String locator, String valueToElement, String... value) {		
		locator = String.format(locator, (Object[]) value);
		By byLocator = By.xpath(locator);
		WebDriverWait waitExplicit;
		waitExplicit = new WebDriverWait(driver, 30);
		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(byLocator));
		WebElement element = driver.findElement(byLocator);
		element.clear();
		element.sendKeys(valueToElement);
	}
	public void sendKeyToElement(WebDriver driver, String locator, String value) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.sendKeys(value);
	}

	public void selectItemInHtmlDropdown(WebDriver driver, String locator, String textDropdown) {
		WebElement element = driver.findElement(By.xpath(locator));
		Select select = new Select(element);
		select.selectByVisibleText(textDropdown);
	}

	public void clickButtonByJavaScript(WebDriver driver, WebElement element) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].click();", element);
	}

	public void scrollByJavaScript(WebDriver driver, WebElement element) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public static void highlightElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='6px groove red'", element);
	}

	public static Object executeForBrowser(WebDriver driver, String javaSript) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			return js.executeScript(javaSript);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

	public static Object clickToElementByJS(WebDriver driver, String locator) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			return js.executeScript("arguments[0].click();", locator);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}
	public static Object clickToElementByJS_Dynamic(WebDriver driver, String locator, String...value) {
		try {
			locator = String.format(locator, (Object[]) value);
			By byLocator = By.xpath(locator);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			return js.executeScript("arguments[0].click();", byLocator);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

	public static Object sendkeyToElementByJS(WebDriver driver, WebElement element, String value) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			return js.executeScript("arguments[0].setAttribute('value', '" + value + "')", element);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

	public static Object removeAttributeInDOM(WebDriver driver, WebElement element, String attribute) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			return js.executeScript("arguments[0].removeAttribute('" + attribute + "');", element);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

	public static Object scrollToBottomPage(WebDriver driver) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			return js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

	public static Object navigateToUrlByJS(WebDriver driver, String url) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			return js.executeScript("window.location = '" + url + "'");
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

	public void getAttribute(WebDriver driver, String locator, String attributeName) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.getAttribute(attributeName);

	}

	public String getTextElement_select(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		Select select = new Select(element);
		return select.getFirstSelectedOption().getText();

	}

	public String getTextElement(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.getText().trim();

	}
	public String getTextElement_Dynamic(WebDriver driver, String locator, String...DynamicValue) {
		locator = String.format(locator, (Object[]) DynamicValue);
		By byLocator = By.xpath(locator);
		WebElement element = driver.findElement(byLocator);
		return element.getText().trim();
		
	}

	public int countElement(WebDriver driver, String locator, String value) {
		List<WebElement> elements = driver.findElements(By.xpath(locator));
		return elements.size();

	}

	public void checkTheCheckBox(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		if (!element.isSelected()) {
			element.click();

		}
	}

	public void unCheckTheCheckBox(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		if (element.isSelected()) {
			element.click();

		}
	}

	public boolean isControlDisplayed(WebDriver driver, String locator) {
		try {
		WebElement element = driver.findElement(By.xpath(locator));
		boolean status = element.isDisplayed();
		return status;
	}catch(Exception e) {
		System.out.println(e.getMessage());
		return false;
	}
	}

	public boolean isControlDisplayed(WebDriver driver, String locator, String... DynamicValue) {
		locator = String.format(locator, (Object[]) DynamicValue);
		By byLocator = By.xpath(locator);
		WebElement element = driver.findElement(byLocator);
		return element.isDisplayed();
	}
	
	public boolean isControlDisplayed_Dynamic(WebDriver driver, String textboxNameID) {
			waitToElementVisible(driver, AbstractPageUI.DYNAMIC_TITEL_PAGE, textboxNameID);
			return isControlDisplayed(driver, AbstractPageUI.DYNAMIC_TITEL_PAGE,textboxNameID);
		
	}

	public void isControlSelected(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
	     element.click();
	}
	
	public boolean isControlSelected_DynamicLocator(WebDriver driver, String locator, String... DynamicValue) {
		locator = String.format(locator, (Object[]) DynamicValue);
		By byLocator = By.xpath(locator);
		WebElement element = driver.findElement(byLocator);
		return element.isSelected();
	}

	public boolean isControlEnable(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isEnabled();
	}

	public void swithToWindowID(WebDriver driver, int number) {
		driver.switchTo().frame(number);
	}

	public void swithToChildWindow(WebDriver driver, String parent) {
		Set<String> allwindow = driver.getWindowHandles();
		for (String runWindowID : allwindow) {
			if (!runWindowID.equals(parent)) {
				driver.switchTo().window(runWindowID);
				break;
			}
		}
	}

	public void swithToWindowByTitle(WebDriver driver, String title, String parentWindow) {
		Set<String> allwindow = driver.getWindowHandles();
		for (String runWindowTitle : allwindow) {
			driver.switchTo().window(runWindowTitle);
			String currentWin = driver.getTitle();
			if (!currentWin.equals(title)) {
				break;
			}
		}
	}

	public boolean closeAllWithoutParentWindows(WebDriver driver, String parentWindow) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindowsTitle : allWindows) {
			if (!runWindowsTitle.equals(parentWindow)) {
				driver.switchTo().window(runWindowsTitle);
				driver.close();
			}
		}
		driver.switchTo().window(parentWindow);
		if (driver.getWindowHandles().size() == 1)
			return true;
		else
			return false;
	}

	public void swithToiframe(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		driver.switchTo().frame(element);

	}

	public void doubleClickElement(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		Actions actions = new Actions(driver);
		actions.doubleClick(element);

	}

	public void hoverElement(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		Actions actions = new Actions(driver);
		actions.moveToElement(element);

	}

	public void clickRighElement(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		Actions actions = new Actions(driver);
		actions.contextClick(element).build().perform();

	}

	public void drapAndDropElement(WebDriver driver, String sourceLocator, String targetLocator) {
		WebElement source = driver.findElement(By.xpath(sourceLocator));
		WebElement target = driver.findElement(By.xpath(targetLocator));
		Actions actions = new Actions(driver);
		actions.dragAndDrop(source, target).perform();

	}

	public void keyPressElement(WebDriver driver, String locator) {
		List<WebElement> element = driver.findElements(By.xpath(locator));
		Actions action = new Actions(driver);
		action.keyDown(Keys.CONTROL).build().perform();
		element.get(0).click();
		element.get(3).click();
		element.get(2).click();
		action.keyUp(Keys.CONTROL).build().perform();

	}

	public void keyPressElement2(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.sendKeys(Keys.ENTER);

	}

	public String ranDomString_UUID() {
		// Creating a random UUID (Universally unique identifier).
		UUID uuid = UUID.randomUUID();
		String randomUUIDString = uuid.toString().replaceAll("-", "");
		return randomUUIDString;
	}

	public String ranDomEmaiByDate() {
		Date date = new Date();
		String a = date.toString().replaceAll(" ", "").replaceAll(":", "");
		return a;

	}

	public int random() {
		Random a = new Random();
		int number = a.nextInt(999999);
		return number;
	}

	public void sendKeyAFile(WebDriver driver, String locator, String value) {
		WebElement upload = driver.findElement(By.xpath(locator));
		upload.sendKeys(value);

	}

	public void mulitiFile(WebDriver driver, String locator, String value, String value1) {
		WebElement upload = driver.findElement(By.xpath(locator));
		upload.sendKeys(value + "\n" + value1);
	}

	public void AutoIT(WebDriver driver, String locator, String value, String value1) throws IOException {
		// click to add file button.
		if (driver.toString().toLowerCase().contains("chrome")) {
			driver.findElement(By.cssSelector(".fileinput-button")).click();
		} else if (driver.toString().toLowerCase().contains("firefox")) {
			//clickToElementByJS(driver, driver.findElement(By.xpath("//input[@name='files[]']")));
		} else {
			driver.findElement(By.xpath("//span[contains(text(),'Add files')]")).click();
		}

		// executor file exe
		if (driver.toString().toLowerCase().contains("chrome")) {
			Runtime.getRuntime().exec(new String[] { locator, value });
		} else if (driver.toString().toLowerCase().contains("firefox")) {
			Runtime.getRuntime().exec(new String[] { locator, value });
		} else {
			Runtime.getRuntime().exec(new String[] { locator, value });
		}
		;
	}

	public void rebot(WebDriver driver, String locator, String value) throws InterruptedException, Exception {
		// Specify the file location with extension
		StringSelection select = new StringSelection(value);

		// Copy to clipboard
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(select, null);

		// Click
		if (driver.toString().toLowerCase().contains("chrome")) {
			driver.findElement(By.cssSelector(locator)).click();
		} else if (driver.toString().toLowerCase().contains("firefox")) {
			//clickToElementByJS(driver, driver.findElement(By.xpath(locator)));
		} else {
			driver.findElement(By.xpath(locator)).click();
		}

		Thread.sleep(5000);

		Robot robot = new Robot();
		Thread.sleep(1000);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);

		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		Thread.sleep(1000);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	public void explicit_Wait_Presend(WebDriver driver, String locator) {
		WebDriverWait waitExplicit;
		waitExplicit = new WebDriverWait(driver, 30);
		waitExplicit.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
	}

	public void waitForElementVisible(WebDriver driver, String locator) {
		WebDriverWait waitExplicit;
		waitExplicit = new WebDriverWait(driver, 10);
		try {
			waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));

		} catch (Exception e) {
			System.out.println("mesage: " + e.getMessage());

		}
	}

	public void waitForElementInVisible(WebDriver driver, String locator) {
		WebDriverWait waitExplicit;
		waitExplicit = new WebDriverWait(driver, 30);
		waitExplicit.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locator)));
	}

	public void waitForElementClickable(WebDriver driver, String locator) {
		WebDriverWait waitExplicit;
		waitExplicit = new WebDriverWait(driver, 30);
		waitExplicit.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
	}

	public void waitForAlertPresence(WebDriver driver, String locator) {
		WebDriverWait waitExplicit;
		waitExplicit = new WebDriverWait(driver, 30);
		waitExplicit.until(ExpectedConditions.alertIsPresent());
	}

	public void waitToElementVisible(WebDriver driver, String locator, String... dynamicValue) {
		locator = String.format(locator, (Object[]) dynamicValue);
		By byLocator = By.xpath(locator);
		WebDriverWait waitExplicit;
		waitExplicit = new WebDriverWait(driver, 30);
		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(byLocator));

	}

	public void openMorePageDynamic(WebDriver driver, String pageName) {
		waitToElementVisible(driver, HomePageUI.DYNAMIC_LINK, pageName);
		clickToButton_Dynamic(driver, HomePageUI.DYNAMIC_LINK, pageName);
	}

	public AbstractPage openPageDynamic(WebDriver driver, String pageName) {
		waitToElementVisible(driver, AbstractPageUI.DYNAMIC_LINK, pageName);
		clickToButton_Dynamic(driver, AbstractPageUI.DYNAMIC_LINK, pageName);

		switch (pageName) {
		case "New Customer":
			return PageFactoryManage.getNewCustomerPage(driver);
		case "New Account":
			return PageFactoryManage.getNewAccountPage(driver);
		case "Deposit":
			return PageFactoryManage.getDepositPage(driver);
		case "Fund Transfer":
			return PageFactoryManage.getFundsPage(driver);
		default:
			return PageFactoryManage.getHomePage(driver);

		}
	}

	public void clickonButton_Link_Dynamic(WebDriver driver, String locator, String textboxNameID) {
		waitToElementVisible(driver, locator, textboxNameID);
		clickToButton_Dynamic(driver,locator,textboxNameID);
	}	

	// user for Bank GURU
	public void clickonLink(WebDriver driver, String textboxNameID) {
		waitToElementVisible(driver, AbstractPageUI.DYNAMIC_LINK, textboxNameID);
		clickToButton_Dynamic(driver, AbstractPageUI.DYNAMIC_LINK,textboxNameID);
	}	
	public void inputDynamicTextbox(WebDriver driver, String textboxNameID, String valueToSendkey) {
		waitToElementVisible(driver, AbstractPageUI.DYNAMIC_TEXTBOX_BUTTON, textboxNameID);
		sendKeyToElement_Dynamic(driver, AbstractPageUI.DYNAMIC_TEXTBOX_BUTTON,valueToSendkey, textboxNameID);
	}
	public void clickonButton(WebDriver driver, String textboxNameID) {
		waitToElementVisible(driver, AbstractPageUI.DYNAMIC_TEXTBOX_BUTTON, textboxNameID);
		clickToButton_Dynamic(driver, AbstractPageUI.DYNAMIC_TEXTBOX_BUTTON,textboxNameID);
	}
	public void inputDynamicTextArea(WebDriver driver, String textboxNameID, String valueToSendkey) {
		waitToElementVisible(driver, AbstractPageUI.DYNAMIC_TEXT_EREA, textboxNameID);
		sendKeyToElement_Dynamic(driver, AbstractPageUI.DYNAMIC_TEXT_EREA, valueToSendkey,textboxNameID);
	}
	public void ClicDynamicTextbox(WebDriver driver, String textboxNameID) {
		waitToElementVisible(driver, AbstractPageUI.DYNAMIC_TEXTBOX_BUTTON, textboxNameID);
		clickToButton_Dynamic(driver, AbstractPageUI.DYNAMIC_TEXTBOX_BUTTON,textboxNameID);
	}
	int shortTimeOut = 5;
	int longTimeOut = 30;
}

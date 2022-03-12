package pageFactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BasePage {

	private static final int TIMEOUT = 20;
	private static final int POLLING = 100;

	protected WebDriver driver;
	private WebDriverWait wait;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, TIMEOUT, POLLING);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT), this);
	}

	protected void waitForElementToAppear(WebElement locator) {
		wait.until(ExpectedConditions.visibilityOf(locator));
	}

	protected void waitForElementToDisappear(WebElement locator) {
		wait.until(ExpectedConditions.invisibilityOf(locator));
	}
	
	protected void waitForElementToClickble(WebElement locator) {
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	protected void waitForTextToDisappear(WebElement locator, String text) {
		wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(locator, text)));
	}
	
	protected boolean waitForTextToAppear(WebElement locator, String text) {
		return wait.until((ExpectedConditions.textToBePresentInElement(locator, text)));
	}

	public void setImplicitWait() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	protected void addDataInInputBox(WebElement locator, String textToEnter) {
		waitForElementToAppear(locator);
		locator.sendKeys(textToEnter);
	}

	public void clickButton(WebElement element) {

		try {
			element.click();

		} catch (Exception e) {

			Assert.fail("Failed to click on the button: " + e.getMessage());
		}
	}

}

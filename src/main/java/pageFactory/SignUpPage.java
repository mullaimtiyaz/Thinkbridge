package pageFactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class SignUpPage extends BasePage {

	public SignUpPage(WebDriver driver) {
		super(driver);
	}
	
	// -- Xpath --
	
	@FindBy(xpath = "//*[contains(@id,'language')]")
	public static WebElement dropDownBox;
	
	@FindBy(xpath = "//div[contains(@*,'language')]")
	public static List<WebElement> dropDownOptions;
	
	@FindBy(xpath = "//*[contains(text(),'Dutch')]")
	public static WebElement dutchDropDownOption;
	
	@FindBy(xpath = "//input[contains(@id,'name')]")
	public static WebElement nameInputBox;
	
	@FindBy(xpath = "//input[contains(@id,'orgName')]")
	public static WebElement orgNameInputBox;
	
	@FindBy(xpath = "//input[contains(@id,'singUpEmail')]")
	public static WebElement emailInputBox;
	
	@FindBy(xpath = "//span[contains(.,'I agree to the')]")
	public static WebElement agreeCheckBox;
	
	@FindBy(xpath = "//button[contains(.,'Get Started')]")
	public static WebElement getStartedButton;
	
	@FindBy(xpath = "//span[contains(.,' A welcome email has been sent. Please check your email. ')]")
	public static WebElement alertMessage;
		
	
	//-- Methods --
	public void openDropdown() throws InterruptedException {
		
		waitForElementToAppear(dropDownBox);
		clickButton(dropDownBox);	
		waitForElementToAppear(dropDownOptions.get(dropDownOptions.size()-1));
	}
	
	public void verifyDropDownOption(String optionToVerify) {
		
		for(WebElement element: dropDownOptions) {
			if(element.getText().equalsIgnoreCase(optionToVerify)) {
				Assert.assertTrue(true, "Option not display");
			}
		}		
	}
	
	public void addDataInInoutBox(String user_name, String user_OrgName, String user_email) {
		
		addDataInInputBox(nameInputBox, user_name);
		addDataInInputBox(orgNameInputBox, user_OrgName);
		addDataInInputBox(emailInputBox, user_email);
			
	}
	
	public void acceptTermsAndCondition() {
		clickButton(agreeCheckBox);
	}
	
	public void sumbitSignUpDetails() {
		waitForElementToClickble(getStartedButton);
		clickButton(getStartedButton);	
	}
	
	public void verifyAlertMessage(String alertMessageText) {		
		Assert.assertTrue(waitForTextToAppear(alertMessage,alertMessageText), "Invalid Message Showing");
	}

}

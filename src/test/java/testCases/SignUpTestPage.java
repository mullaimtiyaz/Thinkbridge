package testCases;

import org.testng.annotations.Test;

import pageFactory.SignUpPage;
import testBase.TestBase;
import testData.TestData;

public class SignUpTestPage extends TestBase {

	TestData testData = new TestData();
	
	@Test(description ="Verify Sign up page")
	public void validateThatUserReceivedAnEmailAfterSignUp() throws InterruptedException {
		
		SignUpPage signUpPage = new SignUpPage(getDriver());
		
		signUpPage.openDropdown();
		
		signUpPage.verifyDropDownOption(testData.englishOption);
		
		signUpPage.verifyDropDownOption(testData.dutchOption);
		
		signUpPage.addDataInInoutBox(testData.userName, testData.userOrganizatioName, testData.userEmail);
		
		signUpPage.acceptTermsAndCondition();
		
		signUpPage.sumbitSignUpDetails();
		
		signUpPage.verifyAlertMessage(testData.alertMessage);
		
	}
	
}

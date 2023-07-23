package PageEvents;

import org.testng.Assert;

import PageObjects.LoginPageElements;
import TestBasePackage.TestBase;
//import TesPackage.TestBase;
import Utils.ElementFetch;

public class LoginPageEvents {

	public void verifyLoginPage() {
		// LoginPageElements
		ElementFetch fetch = new ElementFetch();
		TestBase.logger.info("Verifying login Page");
		Assert.assertTrue(fetch.getListOfWebElement("CSS", LoginPageElements.verifyTextSignIn).size() > 0,
				"Number Elements does not matched");

	}

	public void enterEmailId() {
		ElementFetch fetch = new ElementFetch();
		TestBase.logger.info("Entering the email address");
		fetch.getWebElement("CSS", LoginPageElements.emailField).sendKeys("shrinivasmahabole@gmail.com");

	}

	public void clickContinueButton() {
		ElementFetch fetch = new ElementFetch();
		TestBase.logger.info("Click on the continue button");
		fetch.getWebElement("CSS", LoginPageElements.continueButton).click();
	}

}

package PageEvents;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;

import PageObjects.HomePageElements;
import TestBasePackage.TestBase;
//import TesPackage.TestBase;
import Utils.ElementFetch;

public class HomePageEvents {
	
	//public ElementFetch fetch;
	
	public void verifyHomePage() {
		ElementFetch fetch = new ElementFetch();
		TestBase.logger.info("verifying the Home Page");
		Assert.assertTrue(fetch.getListOfWebElement("CSS", HomePageElements.verifyHomePage).size()>0, "Login Page did not Open");
		
	}
	//check it will work with Xpath
	public void clickOnSignInButton() {
		ElementFetch fetch = new ElementFetch();
		TestBase.logger.info("Click on sign in button");
		String str = HomePageElements.SignInButton;
		fetch.getWebElement("XPATH", HomePageElements.SignInButton).click();
		//fetch.getWebElement("CSS", HomePageElements.SignInButton).click();
	}

}

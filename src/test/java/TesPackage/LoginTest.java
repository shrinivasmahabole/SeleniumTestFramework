package TesPackage;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import PageEvents.HomePageEvents;
import PageEvents.LoginPageEvents;
import TestBasePackage.TestBase;
import TestListnersPackage.RetryAnalyzer;

@Listeners(TestListnersPackage.SuiteListners.class)
public class LoginTest extends TestBase{
	
	@Test
	public void loginTests() {
		HomePageEvents homePage = new HomePageEvents();
		LoginPageEvents loginPage = new LoginPageEvents();
		
		homePage.verifyHomePage();
		homePage.clickOnSignInButton();
		loginPage.verifyLoginPage();
		loginPage.enterEmailId();
		loginPage.clickContinueButton();
	}
	
	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void retryTest()
	{
		HomePageEvents homePage = new HomePageEvents();
		LoginPageEvents loginPage = new LoginPageEvents();
		
		homePage.verifyHomePage();
		homePage.clickOnSignInButton();
		loginPage.verifyLoginPage();
		loginPage.enterEmailId();
		loginPage.clickContinueButton();
	}

}

package Utils;

import java.lang.runtime.SwitchBootstraps;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import TestBasePackage.TestBase;

//import TesPackage.TestBase;

public class ElementFetch {

	public WebElement getWebElement(String identifierType, String identifierValue) {
		switch (identifierType) {
		case "ID":
			return TestBase.driver.findElement(By.id(identifierValue));
		case "CSS":
			return TestBase.driver.findElement(By.cssSelector(identifierValue));
		case "XPATH":
			return TestBase.driver.findElement(By.xpath(identifierValue));
		case "TAGNAME":
			return TestBase.driver.findElement(By.tagName(identifierValue));
		default:
			return null;
		}
	}

	public List<WebElement> getListOfWebElement(String identifierType, String identifierValue) {
		switch (identifierType) {
		case "ID":
			return TestBase.driver.findElements(By.id(identifierValue));
		case "CSS":
			return TestBase.driver.findElements(By.cssSelector(identifierValue));
		case "XPATH":
			return TestBase.driver.findElements(By.xpath(identifierValue));
		case "TAGNAME":
			return TestBase.driver.findElements(By.tagName(identifierValue));
		default:
			return null;
		}
	}

}

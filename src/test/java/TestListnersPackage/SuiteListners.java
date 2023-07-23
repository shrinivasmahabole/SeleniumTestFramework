package TestListnersPackage;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.IAnnotationTransformer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import TestBasePackage.TestBase;



public class SuiteListners implements ITestListener, IAnnotationTransformer {
	
    public void onTestStart(ITestResult result) {

		
	}

	public void onTestSuccess(ITestResult result) {

		

	}

	public void onTestFailure(ITestResult result) {

		String screenName = System.getProperty("user.dir")+File.separator+"screenshots"+File.separator+ result.getMethod().getMethodName();
		File file = ((TakesScreenshot)TestBase.driver).getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(file, new File(screenName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onStart(ITestContext context) {
		

	}

	public void onFinish(ITestContext context) {
		

	}
	
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {

		annotation.setRetryAnalyzer(RetryAnalyzer.class);
	}
	

}

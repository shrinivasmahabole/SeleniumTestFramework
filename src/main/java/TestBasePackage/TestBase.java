package TestBasePackage;

import java.io.File;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
import Utils.Constants;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class TestBase {
	 public static WebDriver driver;
	    public ExtentHtmlReporter htmlReporter;
	    public static ExtentReports extent;
	    public static ExtentTest logger;
	    @BeforeTest
	    public void beforeTest(){

	        htmlReporter =  new ExtentHtmlReporter(System.getProperty("user.dir")+File.separator+"reports"+File.separator+"testAutomationReport.html");
	        htmlReporter.config().setTheme(Theme.STANDARD);
	        htmlReporter.config().setEncoding("UTF-8");
	        htmlReporter.config().setReportName("TestAutomationReport");
	        htmlReporter.config().setDocumentTitle("TestResultsReport");
	        extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
	        extent.setSystemInfo("Automation Tester", "Rahul Arora");
	        extent.setSystemInfo("Organization", "Way2Automation");
	        extent.setSystemInfo("Build no", "W2A-1234");

	    }

	    @BeforeMethod
	    @Parameters(value={"browserName"})
	    public void beforeMethod(String browserName, Method testMethod){
	        logger = extent.createTest(testMethod.getName());
	        setUpDriver(browserName);

	        driver.manage().window().maximize();
	        driver.get(Constants.url);
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	    }

	    @AfterMethod
	    public void afterMethod(ITestResult result){
	        if(result.getStatus()==ITestResult.SUCCESS){
	            String methodBName = result.getMethod().getMethodName();
	            String logText = "TestCase: "+methodBName+" Pass";
	            Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
	            logger.log(Status.PASS, m);
	            
	        } else if (result.getStatus()==ITestResult.FAILURE) {
	            String methodBName = result.getMethod().getMethodName();
	            String logText = "TestCase: "+methodBName+" Failed";
	            Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
	            logger.log(Status.FAIL, m);	            
	        }
	        else if (result.getStatus()==ITestResult.SKIP) {
	            String methodBName = result.getMethod().getMethodName();
	            String logText = "TestCase: "+methodBName+" Skipped";
	            Markup m = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
	            logger.log(Status.SKIP, m);	            
	        }

	        driver.quit();

	    }

	    @AfterTest
	    public void afterTest(){
	        extent.flush();

	    }

	    public void setUpDriver(String driverName){
	        if(driverName.equalsIgnoreCase("chrome")){
	            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ File.separator+"drivers"+File.separator+"chromedriver.exe");
	            driver = new ChromeDriver();

	        }else if(driverName.equalsIgnoreCase("edge")){
	            System.setProperty("webdriver.edge.driver",
	                    System.getProperty("user.dir")+ File.separator+"drivers"+File.separator+"msedgedriver.exe");
	            driver = new EdgeDriver();

	        }else{
	            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ File.separator+"drivers"+File.separator+"chromedriver.exe");
	            driver = new ChromeDriver();

	        }

	    }

}

package TestListnersPackage;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
	int count =0;
	int retrycount =2;

	@Override
	public boolean retry(ITestResult result) {
		while(count<retrycount) {
			count++;
			return true;
		}


		return false;
	}

}

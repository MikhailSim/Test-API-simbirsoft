package simbirsoft.com.helpers;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

// this is used for run the methods that failed
public class RetryAnalyzer implements IRetryAnalyzer {

    int counter = 0;
    int retryLimit = 2;

    @Override
    public boolean retry(ITestResult result) {

        if (counter < retryLimit) {
            counter++;
            return true;
        }
        return false;
    }
}
package seleniumAdvanced;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * Created by Sharif on 10/18/2017.
 */
public class RetryClass implements IRetryAnalyzer{
    private int retryCount = 0;
    private int maxReturnCount = 3;

    public boolean retry(ITestResult result){
        if(retryCount<maxReturnCount) {
            System.out.println("Retrying test " + result.getName() + " with status " + getResultStatusName(result.getStatus()) + " for the " + (retryCount + 1) + " time(s).");
            retryCount++;
            return true;
        }
        return  false;
    }
    public String getResultStatusName(int status){
        String resultName = null;
        if (status == 1)
            resultName = "SUCCESS";
        if (status == 2)
            resultName = "FAILURE";
        if (status == 3)
            resultName = "SKIP";
        return resultName;
    }
}

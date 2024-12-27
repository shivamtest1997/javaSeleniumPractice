package selenium_practice_set;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListeners implements ITestListener {

   public void onStart(ITestContext context) {
       System.out.println("Test execution is started and it will execute only once");
    }
    public void onTestStart(ITestResult result) {
        System.out.println("execute before starting every test");
    }
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test case is passed");
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("Test case is failed");
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("Test is skipped");
    }
    public void onFinish(ITestContext context) {
        System.out.println("Test execution is completed");
    }

}

package selenium_practice_set;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
/**
 * Extent Report : A Third party report
 * 1.To implement extent report we need to add dependency to pom.xml file
 * 2.Create ExtentReportManager Class which implements ITestListener interface
 * 3.Important classes which is used:
 *  ExtentSparkReporter(c) --> deals with look and feel i.e. UI of the report like theme structure
 *  ExtentReports(C) --> responsible to populate common info on the report like browser name environment details
 *  ExtentTest(c) -->responsible for updating status in report like passed failed or skipped
 */
public class ExtentReportManager implements ITestListener {

    public ExtentSparkReporter sparkReporter;
    public ExtentReports extent;
    public ExtentTest test;

    //Before staring execution execute only once
    public void onStart(ITestContext context) {
        //Specify location of report in project
        sparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/testReport.html");
        sparkReporter.config().setDocumentTitle("Automation Test Report"); // title of the report
        sparkReporter.config().setReportName("Functional Testing"); // name of the report
        sparkReporter.config().setTheme(Theme.DARK);

        extent=new ExtentReports();
        extent.attachReporter(sparkReporter);

        //set some common info later we can call it dynamically from config.properties file
        extent.setSystemInfo("Computer Name","localhost");
        extent.setSystemInfo("Environment","QA");
        extent.setSystemInfo("Executor name","Shivam");
        extent.setSystemInfo("Browser","Edge");

    }
    //execute before every test
    public void onTestStart(ITestResult result) {

    }
    public void onTestSuccess(ITestResult result) {
        test=extent.createTest(result.getName()); //create a new entry in the report
        test.log(Status.PASS, "Test case Passed :"+result.getName()); //update status i.e pass/fail/skip
    }

    public void onTestFailure(ITestResult result) {
        test=extent.createTest(result.getName()); //create a new entry in the report
        test.log(Status.FAIL, "Test case Failed :"+result.getName());
        test.log(Status.FAIL, "Test case Failed due to:"+result.getThrowable());
    }

    public void onTestSkipped(ITestResult result) {
        test=extent.createTest(result.getName()); //create a new entry in the report
        test.log(Status.SKIP, "Test case Skipped :"+result.getName());
    }
    public void onFinish(ITestContext context) {
       extent.flush();  // it will update all above information in report
    }

}

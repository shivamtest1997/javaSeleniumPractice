package selenium_practice_set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.Duration;
@Listeners(TestListeners.class)
public class TestNGTest_4_Listeners {
    /**
     * TestNG Listeners : used to listen events related to test case i.e. post actions
     * status: passed failed skipped
     * post actions:once test cases get executed then perform certain actions
     * ex : passed : update result in report
     *      failed : capture screenshot and attached in report
     *      skipped : update status as skipped in report
     *
     * 1.create test cases
     * 2.create Listeners class :which implements ITestListener interface
     *                           implement certain methods from this interface
     *                           ex. onTestStart(), onTestSuccess(),onTestFailure()
     *    Two ways to create Listeners class :
     *              1)class MyListener implements ITestListener {
     *
     *              }
     *              ITestListener already implemented by TestListenerAdapter
     *              2)class MyListener extends TestListenerAdapter{
     *
     *              }
     * 3.create xml file to include test cases and listeners class.
     *
     * 4.If we do not want to execute test cases through xml file then add @listeners annotation above class name
     *      @Listeners(TestListeners.class)
     *      public class TestNGTest_4 { }
     */
    WebDriver driver;
    WebDriverWait wait;
    @BeforeClass
    void setup() throws InterruptedException {

        driver=new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(5);    // to see execution live
    }

    @Test(priority = 1)
    public void  testLogo()
    {
        wait=new WebDriverWait(driver,Duration.ofSeconds(30));
        WebElement logo =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[contains(@alt,'branding')]")));
        Assert.assertTrue(logo.isDisplayed());
    }
    @Test(priority = 2)
    void testUrl()
    {
        Assert.assertEquals(driver.getCurrentUrl(), "https:invalidUrl.com");
    }
    @Test(priority = 3,dependsOnMethods = {"testUrl"})
    public void testTitle()
    {
        Assert.assertEquals(driver.getTitle(), "OrangeHRM");
    }
    @AfterClass
    void tearDown()
    {
        driver.quit();
    }
    // xml file for listeners
    /*
        <suite name="All Test Suite" thread-count="5">
            <listeners>
                <listener class-name="selenium_practice_set.TestListeners"></listener>
            </listeners>
            <test verbose="2"  name="Test Listeners">
                <parameter name="browser" value="edge"></parameter>
                <classes>
                    <class name="selenium_practice_set.TestNGTest_4"/>
                </classes>
            </test>
        </suite>
    */


}

package selenium_practice_set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;
//Note this class is executed by xml file
/**
 *  Parallel Testing using xml file :
 *     1. created test case
 *     2. created xml file to run test case
 *     3. passed browser name parameter from xml file and received in setup method
 *  @Parameters({"browser"}) annotation is used to read value in xml file
 */
public class TestNGTest_3_ParallelTesting {
    WebDriver driver;
    WebDriverWait wait;
    @BeforeClass
    @Parameters({"browser"})
    void setup(String br) throws InterruptedException {
        switch (br.toLowerCase())
        {
            case "edge": driver=new EdgeDriver(); break;
            case "firefox": driver=new FirefoxDriver(); break;
            case "chrome": driver=new ChromeDriver(); break;
            default:
                System.out.println("invalid browser");return; // here return will exit from method and will not run rest of code
        }


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
    public void testTitle()
    {
        Assert.assertEquals(driver.getTitle(), "OrangeHRM");
    }
    @Test(priority = 3)
    void testUrl()
    {
        Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }
    @AfterClass
    void tearDown()
    {
        driver.close();
    }
    //xml file :
    /*
        <suite name="All Test Suite"  parallel="tests" thread-count="5">
            <test verbose="2"  name="edge test">
                 <parameter name="browser" value="edge"></parameter>
             <classes>
                <class name="selenium_practice_set.TestNGTest_3"/>
             </classes>
            </test>
            <test verbose="2"  name="firefox test">
                 <parameter name="browser" value="edge"></parameter>
                     <classes>
                         <class name="selenium_practice_set.TestNGTest_3"/>
                    </classes>
            </test>
         </suite>

    */

}

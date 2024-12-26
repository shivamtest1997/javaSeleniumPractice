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
import org.testng.annotations.*;

import java.time.Duration;

public class TestNGTestParameterization {

    /**
     * Parameterization :
     * 1) @DataProvider ---used for data driven testing
     * dataProvider is basically a method which create some test data and pass that data to test case
     * 2) using xml file---used for parallel testing
     */
    WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test(dataProvider = "dp")
    public void testLogin(String email,String password) {
        driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
        driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@value='Login']")).click();

        boolean status = driver.findElement(By.xpath("//h2[text()='My Account']")).isDisplayed();
        if (status == true) {
            driver.findElement(By.partialLinkText("Logout")).click();
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }

    }
    @AfterClass
    public void tearDown() {
        driver.close();
    }

    /**
     *  I want to logged in using multiple data.
     *  creation and returning data.
     *  data provider method always return object type of 2D array.
     *  Syntax:
     *  1.create data creation method
     *  @DataProvider(name="name")
     *  Object[][] methodName(){
     *       {"email1","password1"},
     *       {"email2","password2"},
     *       {"email3","password3"},
     *  }
     *  2.use
     *  @Test(dataProvider="dp")
     *  public void testCase(String email,String password)
     *  {
     *         driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(email);
     *         driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(password);
     *  }
     *  Note:
     *  1.test cased will run x no of times,where x no of data rows present in data provider method
     *              ex dp contains 5 input test case will run 5 times
     *  2.if we want to pass selected data then we can control by 'indices'
     *      @Test(dataProvider="dp",indices={1,3})
     *      public void testCase(String email,String password){
     *          driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(email);
     *          driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(password);
     *      }
     */
    @DataProvider(name ="dp",indices = {0,2,4})
    Object[][] loginData() {
        //created 2D array which contains data
        // created Object type of array to store data irrespective of its data type
        Object data[][] =
                {
                        {"abc@yopmail.com", "Abc@123"},
                        {"shubhamk@yopmail.com", "Shubham@123"},
                        {"pratik@yopmail.com", "Pratik@123"},
                        {"dakshayani@yopmail.com", "Dakshu@123"},
                        {"akshata@yopmail.com", "Akshata@123"},
                };
        return data;
    }
}
//Note this class is executed by xml file

/**
 *  Parallel Testing using xml file
 *     1. created test case
 *     2. created xml file to run test case
 *     3. passed browser name parameter from xml file and received in setup method
 *  @Parameters({"browser"}) annotation is used to read value in xml file
 */
class ParamTest{
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

}


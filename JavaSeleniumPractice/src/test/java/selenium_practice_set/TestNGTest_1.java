package selenium_practice_set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class TestNGTest_1 {
    /**
     * TestNG-Test new Generation
     * java based unit testing tool
     *
     * Advantage:
     * 1.Test cases & test suites
     * 2.Grouping of test cases
     * 3.prioritize
     * 4.Parameterization
     * 5.Parallel Testing
     * 6.Reports
     *
     * Annotations :
     *   TestNG execute test cases only if it have @Test annotation
     *   By default testNG execute test cases based on alphabetical order.
     *   @Test(priority=number) controls order of execution.
     *   After providing priority order of execution is not considered
     *   if we don't provide priority then default priority is 0
     *   if test cases have same priority then test cases will execute based on alphabetical order
     *   we can provide negative numbers in priority
     * */

    WebDriver driver;
    /**
     *  1.open application
     *  2.Login to application
     *  3.Logout from application
     */
    @Test(priority = 1)
    public void openApplication()
    {
        driver=new EdgeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test(priority = 2,dependsOnMethods = {"openApplication"})
    public void  testLogo()
    {
        driver.findElement(By.xpath("//img[contains(@alt,'branding')]")).isDisplayed();
        System.out.println("Logo displayed ...!");
    }

    @Test(priority = 3,dependsOnMethods = {"testLogo"})
    public void testLogin()
    {
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
    @Test(priority = 4,dependsOnMethods = {"testLogo","testLogin"})
    public void logout()
    {
        driver.findElement(By.xpath("//span[@class='oxd-userdropdown-tab']//p")).click();
        driver.findElement(By.xpath("//*[text()='Logout']")).click();
    }

    /*
        TestNG Annotations:
        @BeforeMethod  -->execute Before calling test case
        @AfterMethod   -->execute after test case get called

        @BeforeClass  -->Execute only once before calling class
        @AfterClass   -->Execute only once all test cases in class are executed
                Annotations applied on xml level : in xml Test is collections of classes
        @BeforeTest  -->execute before execution of any test in xml
        we can create this method in any classes which included in test tag
        @AfterTest  -->execute after executing of test in xml
        @BeforeSuite  -->this will execute before execution of suite
        @AfterSuite   -->this will execute after execution of suite
    */
    /**
     * Annotations Hierarchy
     * @BeforeSuite
     *      @BeforeTest
     *          @BeforeClass
     *                  @BeforeMethod
     *                       @Test
     *                  @AfterMethod
     *                  @BeforeMethod
     *                       @Test
     *                  @AfterMethod
     *          @AfterClass
     *      @AfterTest
     * @AfterSuite
     */

    // Assertions

    /**
     *  1)Hard Assertions
     *  2)Soft Assertions
     */
    @Test(priority = -1)
    public void assertionsTest()
    {
        String exp_title="Opencart";
        String act_title="Opencart";
        /**
         *      if (exp_title.equals(act_title)) {
         *             System.out.println("test passed");
         *         } else {
         *             System.out.println(" Test failed ");
         *         }
         *   This test cases will still pass because test case will not look conditions statement
         */

        Assert.assertEquals(act_title, exp_title); // test cased will mark as failed if titles are not match
        // Assert.assertEquals("Shivam","Shivam"); passed
        // Assert.assertEquals(100, 100);  passed
        // Assert.assertEquals(String, int); failed
        // Assert.assertNotEquals(123,455); passed
        // Assert.assertTrue(true); passed
        // Assert.assertTrue(false); failed
        // Assert.assertTrue(1==2); failed
        // Assert.assertTrue(1==1); passed
        // Assert.assertFalse(1=2); passed
        // Assert.assertFalse(1=1); Failed
        // Assert.fail() // this will failed test cases without checking validations
    }

    /**
     * Hard Assert :
     *  if assertion is failed then below lines of code will not execute.
     *  test case will mark as failed immediately
     *  generally we used hard assertion as last statement so that code test cases will failed if assertion is failed
     */
    @Test(enabled = false)
    public void hardAssertions()
    {
        System.out.println("Hi..");
        System.out.println("Hi..");

        Assert.assertEquals(1, 2); // if assertion is failed below statement will not execute

        System.out.println("Bye...");
        System.out.println("Bye...");
    }

    /**
     * Soft Assert:
     *  Even if assertion is failed below lines of code will execute
     *  To use soft assert we need to create object of SoftAssert class
     *  SoftAssert sa=new SoftAssert();
     *  sa.assertEquals(act,exp);
     *
     *  sa.assertAll(); we need to declare this line at the end of test case
     *  if we not declare this line then test case will always pass even if assertion is failed
     */
    @Test(enabled = false)
    public void softAssertions()
    {
        System.out.println("Hi..");
        System.out.println("Hi..");

        SoftAssert sa=new SoftAssert();
        sa.assertEquals(1, 2); // if assertion is failed below statement will execute

        System.out.println("Bye...");
        System.out.println("Bye...");

        sa.assertAll(); // mandatory line to failed test case if assertion is failed otherwise test case will mark as passed
    }
  /*
     Dependency Methods
     1.dependsOnMethods : @Test(dependsOnMethod={"testCaseName1","testCaseName2"})
                          if test case is failed then all dependent test cases get skipped
 */
/*  grouping:
    class 1: tc1,tc2,tc3
    class 2: tc4,tc5,tc6
    class 3: tc7,tc8,tc9

    sanity:
    regression:
    function:
    @Test(groups={"sanity"})
    void tc1(){};
    @Test(groups={"regression"})
    void tc2(){};
    @Test(groups={"regression"})
    void tc4(){};
    @Test(groups={"sanity","regression})
    void tc8(){};

    To run test cases in groups use xml file and modify as follows:-

    <suite name="Grouping suite">
    <test name="Grouping Test">
       <groups>
            <run>
                <include name="sanity"/>      ---> all test cases having sanity tag will execute tc1,tc8
                <exclude name="regression" /> --->if we want to exclude test cases belong to regression i.e only tc1 will execute
            </run>
       </groups>
        <classes>
            <class name="selenium_practice_set.Class1"/>
            <class name="selenium_practice_set.Class2"/>
            <class name="selenium_practice_set.Class3"/>
        </classes>
    </test>
    </suite>
    */

}

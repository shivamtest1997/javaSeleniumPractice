package selenium_practice_set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;
import pages.LoginPage2;

import java.time.Duration;
@Listeners(ExtentReportManager.class)
public class LoginTest {
    private static final Logger log = LoggerFactory.getLogger(LoginTest.class);
    WebDriver driver;
    @BeforeClass
    public void setup()
    {
        driver=new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
    }
    @Test
    public void testLogin()
    {
        LoginPage loginPage=new LoginPage(driver);
        loginPage.setUsername("Admin");
        loginPage.setPassword("admin123");
        loginPage.clickLogin();

        Assert.assertEquals(driver.getTitle(), "OrangeHRM");
    }
    @AfterMethod
    public void logout()
    {
        LoginPage2 loginPage2=new LoginPage2(driver);
        loginPage2.logout();
    }
    @Test
    public void testLoginApproach2()
    {
        LoginPage2 loginPage2=new LoginPage2(driver);
        loginPage2.setUsername("Admin");
        loginPage2.setPassword("admin123");
        loginPage2.clickLogin();
    }
    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }
}

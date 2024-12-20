package selenium_practice_set;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.function.Function;

public class Waits_Chapter3 {
    WebDriver driver = new EdgeDriver();

    /**
     * Synchronization : element is not available when script is running and webpage is not available or loaded
     * Thread.sleep(milliseconds) -->it is provided by java this is static wait
     * 1) implicit wait
     * 2) explicit wait/fluent wait
     * <p>
     * NoSuchElementException --> synchronization problem i.e element not present but locator is correct
     * ElementNotFoundException -->locator is incorrect
     */
    @Test
    public void sleep() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        /**
         * No such Element Exception --locator is correct and element is not present on webpage due to synchronization
         * Element Not found Exception -->locator is incorrect.
         *
         * Advantage:    1) Easy to use
         * Disadvantage: 1)if element is available early then also it will wait for given time
         *               2)if time is not sufficient then it will throw exception
         *               3)need to use multiple times wherever required
         */

        Thread.sleep(4000);
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
    }

    /**
     *  implicit wait -->need to specify only one time, and it will be applicable for all
     *  below lines of code and active till driver is closed
     *  default time of implicit wait is 0
     *  it will not wait till maximum time if element is visible
     *  syntax:  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
     *
     *  DisAdvantage--? If time is not sufficient then you will get exception
     *  @throws InterruptedException
     */
    @Test
    public void implicitWAitTest() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
    }

    /**
     *  Explicit wait -->Need to specify condition
     *  It will wait till element meets condition and it will maximum given time
     *  finding element is inclusive
     *  we need to write multiple statements for multiple elements
     *  Syntax: create object of  WebDriverWait class
     *  1) WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
     *  2) wait.until(ExpectedConditions.visibilityOfElementLocated(WebElement));
     */
    @Test
    public void explicitWaitTest()
    {
        // 1. Declare explicit wait
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));


        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // 2. use
        WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']")));
        username.sendKeys("Admin");

        WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password']")));
        password.sendKeys("admin123");

        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[ normalize-space()='Login']")));
        loginBtn.click();

    }

    /**
     * Syntax
     *  1) Wait<WebDriver> wait=new FluentWait<WebDriver>(driver)
     *          .withTimeout(Duration.ofSeconds(10)
     *          .poolingEvery(Duration.ofSeconds(5)
     *          .ignoring(NoSuchElementException.class)
     */
    @Test
    public void fluentWaitTest() {
        // 1.Declaration
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(3))
                .ignoring(NoSuchElementException.class);

        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // 2. use

        WebElement textUsername=wait.until(new Function<WebDriver, WebElement>() {

            @Override
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.xpath("//input[@name='username']"));
            }
        });

        textUsername.sendKeys("Admin");
    }
    @AfterClass
    public void closeBrowser() {
        //driver.close();
    }

}
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

public class Waits {
    WebDriver driver = new EdgeDriver();

    /**
     * Synchronization
     * Thread.sleep() -->it is provided by java
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

        Thread.sleep(4000);
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
    }

    /**
     *  implicit wait -->need to specify only one time, and it will be applicable for all
     *  below lines of code and active till drive is closed
     *  default time of implicit wait is 0
     *  it will not wait till maximum time if element is visible
     *
     *  DisAdvantage--? If time is not sufficient then you will get exception
     * @throws InterruptedException
     */
    @Test
    public void implicitWAitTest() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
    }

    /**
     *  Explicit wait -->Need to specify condition
     *  It will wait till element meets condition
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
     *
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
        driver.close();
    }

}
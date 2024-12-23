package selenium_practice_set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class CheckboxesAndAlerts_Chapter4 {

    WebDriver driver=new EdgeDriver();
    /**
     * checkboxes by click method
     */
    @Test
    public void checkboxes() throws InterruptedException {

        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));

        // 1.select specific checkbox
        WebElement sundayCheckbox = driver.findElement(By.xpath("//input[@id='sunday']"));
        sundayCheckbox.click();
        sundayCheckbox.isSelected();
        driver.findElement(By.xpath("//input[@id='sunday']")).click();

        //2.selecting all checkboxes
        List<WebElement> checkboxes=driver.findElements(By.xpath("//label[text()='Days:']/parent::div//input[@class='form-check-input' and @type='checkbox']"));
        for (WebElement box:checkboxes)
        {
            wait.until(ExpectedConditions.elementToBeClickable(box)).click();
        }

        Thread.sleep(4); // to visible actions on UI otherwise no need here

        //3. Un select last two checkboxes (last two =total(7)-how many deselect from last 2=5)
        for(int i=checkboxes.size()-1;i>=2;i--)
        {
            wait.until(ExpectedConditions.elementToBeClickable(checkboxes.get(i))).click();
        }
        //4. select first three checkboxes
        for (int i=0;i<3;i++)
        {
            wait.until(ExpectedConditions.elementToBeClickable(checkboxes.get(i))).click();
        }

        //5. unselected selected checkboxes
        for (WebElement b:checkboxes)
        {
            if (b.isSelected())
            {
                wait.until(ExpectedConditions.elementToBeClickable(b)).click();
            }
        }
    }

    /**
     * alerts/popups
     * To handle alert we have two approaches :
     * 1)using switchTo()
     *          driver.switchTo().alert().accept(); --close alert using OK button
     *          driver.switchTo().alert().dismiss() -->close alert using cancel button
     *          driver.switchTo().alert().getText() -->to get text of alert pop up
     *          driver.switchTo().alert().sendKeys(String); --> to enter text in input box
     * 2)using explicit wait :
     *         wait.until(ExpectedConditions.alertIsPresent().accept());
     *         wait.until(ExpectedConditions.alertIsPresent().dismiss());
     *         wait.until(ExpectedConditions.alertIsPresent().sendKeys(String));
     *         wait.until(ExpectedConditions.alertIsPresent().getText();
     */
    @Test
    public void alerts() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();

        // Approach 1 using switchTo()
        // 1. normal jsAlert
        driver.findElement(By.xpath("//button[contains(@onclick,'jsAlert')]")).click();

        Alert jsAlert = driver.switchTo().alert();
        String alertText=jsAlert.getText();
        System.out.println(alertText);
        jsAlert.accept();

        Thread.sleep(4000);
        // 2.JS confirm Alert
        WebElement jsConfirm = driver.findElement(By.xpath("//button[contains(@onclick,'jsConfirm')]"));
        jsConfirm.click();
        Alert conirmationAlert = driver.switchTo().alert();

        System.out.println(conirmationAlert.getText());
        conirmationAlert.accept(); //close using OK button

        jsConfirm.click();
        conirmationAlert.dismiss(); //close using CANCEL button

        Thread.sleep(4000);
        // 3.prompt Alert
        driver.findElement(By.xpath("//button[contains(@onclick,'jsPrompt')]")).click();
        Alert promtAlert = driver.switchTo().alert();
        promtAlert.sendKeys("welcome");
        promtAlert.accept();
        Thread.sleep(4000);

        //Approach 2 using explicit wait
        WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement jsConfirm2 = driver.findElement(By.xpath("//button[contains(@onclick,'jsConfirm')]"));
        jsConfirm2.click();
        Thread.sleep(5000);
        wait.until(ExpectedConditions.alertIsPresent()).accept();

//         4. Authentication alert
//         https://the-internet.herokuapp.com/basic_auth
//         http://username:password@the-internet.herokuapp.com/basic_auth  --Syntax
//         http://admin:admin@the-internet.herokuapp.com/basic_auth

       // driver.get("https://the-internet.herokuapp.com/basic_auth"); // you will get authentication pop up
        driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[normalize-space()='Congratulations! You must have the proper credentials.']")));
    }

    @AfterClass
    public void closeBrowser()
    {
        driver.close();
    }
}

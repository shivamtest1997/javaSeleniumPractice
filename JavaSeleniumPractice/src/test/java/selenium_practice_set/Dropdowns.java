package selenium_practice_set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Dropdowns {
    WebDriver driver =new EdgeDriver();
    /**
     *  1.Select dropdown (Select tag)
     *  2.Bootstrap dropdown
     *  3.Hidden dropdown
     */
    @Test
    public void selectDropdown() throws InterruptedException {
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        WebElement country=driver.findElement(By.id("country"));
        Select sel=new Select(country);
        //  select value from dropdown
        //  sel.selectByValue("uk");
        //  sel.selectByIndex(5);
        //  sel.selectByVisibleText("United Kingdom");

        // find total no of options -->getOptions() returns every option as webElement

        List<WebElement> options = sel.getOptions();
        System.out.println("No of option in dropdown :"+options.size());
        for (WebElement w:options)
        {
            System.out.println(w.getText());

        }
    }

    /**
     *  dropdown options can be located in HTML DOM and in this example tag is button for dropdown
     */
    @Test
    public void bootstrapDropdown()
    {
        driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
        driver.manage().window().maximize();

        WebElement bootStrap=driver.findElement(By.xpath("//button[contains(@class,'multiselect')]"));
        bootStrap.click();
        // select single option from dropdown
        WebElement java=driver.findElement(By.xpath("//input[@value='Java']"));
        java.click();
        java.isSelected();

        // capture all options and find size
        List<WebElement> allOptions = driver.findElements(By.xpath("//ul[contains(@class,'multiselect')]//label"));
        System.out.println("all options count :"+allOptions.size()); //14

        // print all options
        for (WebElement option:allOptions)
        {
            System.out.println(option.getText());
        }
        // select multiple options
        for (WebElement op:allOptions)
        {
            String s=op.getText();
           if (s.equals("C#")|| s.equals("Python")||s.equals("MySQL"))
           {
                op.click();
           }
        }
        bootStrap.click();
        driver.findElement(By.xpath("//span[text()='6 selected']")).isDisplayed();

    }
    /**
     *
     * Elements of hidden dropdown are not visible inside html DOM and dropdown tag is div
     *
     */
    @Test
    public void hiddenDropdown() throws InterruptedException {
        driver.manage().window().maximize();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // 2. use
        WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']")));
        username.sendKeys("Admin");

        WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password']")));
        password.sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='PIM']"))).click();
        Thread.sleep(4);
        driver.findElement(By.xpath("//label[normalize-space()='Job Title']")).click();

    }



}

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

public class Dropdowns_Chapter6 {
    WebDriver driver =new EdgeDriver();
    /**
     *  1.Select dropdown (Select tag)
     *  2.Bootstrap dropdown
     *  3.Hidden dropdown
     *
     *  for select dropdown it will have select tag
     *  1)create select class object and pass WebElement
     *  Select sel=new Select(WebElement);
     *  sel.selectByValue("Value"); -->value is attribute of element
     *  sel.selectByVisibleText("Text");
     *  sel.selectByIndex(5);
     *
     *  2)another way is using getOptions() method which return List<WebElement>
     *    List<WebElement> allOptions=sel.getOptions();
     */
    @Test
    public void selectDropdown() throws InterruptedException {
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        WebElement country=driver.findElement(By.id("country"));
        Select sel=new Select(country);
        //  select value from dropdown
        //  sel.selectByValue("uk");
        //  sel.selectByIndex(5);
        //  sel.selectByVisibleText("United Kingdom");

        // find total no of options -->getOptions() returns every option as webElement
        List<WebElement> options = sel.getOptions();
        System.out.println("No of option in dropdown :"+options.size()); //10
        for (WebElement w:options)
        {
            System.out.println(w.getText());
            if (w.getText().equals("India"))
            {
                w.click();
            }
        }
    }

    /**
     *  Bootstrap Dropdown: dropdown options can be located in HTML DOM and in this example tag is button for dropdown
     */
    @Test
    public void bootstrapDropdown()
    {
        driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        WebElement bootStrap=driver.findElement(By.cssSelector("button.multiselect"));
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

        /**
         *    scenario create reusable method to select values from dropdown by passing different arguments everytime
         *     public void selectValueFromDropdown(WebDriver driver,By dropdownLocator,By optionsLocator,String... valuesToSelect) {
         *        driver.findElement(dropdownLocator).click();
         *         for (String value : valuesToSelect) {
         *             for (WebElement option : driver.findElements(optionsLocator)) {
         *                 if (option.getText().equalsIgnoreCase(value)) {
         *                     option.click();
         *                     break;
         *                 }
         *             }
         *         }
         *     }
         */
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
        //click on PIM
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='PIM']"))).click();
        //click on dropdown
        driver.switchTo().defaultContent();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//label[text()='Job Title']/parent::div/following-sibling::div//i")).click();
        driver.findElement(By.xpath("//span[text()='Chief Financial Officer']")).click();

        //no of options
        Thread.sleep(4000);
        driver.findElement(By.xpath("//label[text()='Job Title']/parent::div/following-sibling::div//i")).click();
        List<WebElement> allJobTitles=driver.findElements(By.xpath("//label[text()='Job Title']/parent::div/following::div[@role='listbox']//span"));
        System.out.println(allJobTitles.size());

        //print all options
        for (WebElement jobTitle:allJobTitles)
        {
            System.out.println(jobTitle.getText());
        }
    }



}

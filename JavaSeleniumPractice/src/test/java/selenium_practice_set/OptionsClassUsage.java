package selenium_practice_set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class OptionsClassUsage {



    /**
     * Execute below test in headless
     * ChromeOptions -->Control settings of browser
     * Headless Testing is possible
     */
    @Test
    public void headlessBrowser()
    {
        EdgeOptions options=new EdgeOptions();
        options.addArguments("--headless=new"); // this argument sets  headless browser

        WebDriver driver=new EdgeDriver(options);

        driver.manage().window().maximize();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();
        Set<String> windowIds = driver.getWindowHandles();  // Set Collection doesn't follow index so it doesn't contains get method to extract values

        //Approach 2 -->When having multiple window ids more than 2
        for(String id:windowIds)
        {
            String title=driver.switchTo().window(id).getTitle();
            if (title.contains("Human Resources"))
            {
                System.out.println(driver.getCurrentUrl());
                driver.close();
            }
        }
    }

    /**
     * Handle SSL certificate using Options class.
     */
    @Test
    public void sslHandling()
    {
        EdgeOptions options=new EdgeOptions();
        options.setAcceptInsecureCerts(true); // this argument is used to handle ssl certificate

        WebDriver driver=new EdgeDriver(options);
        driver.get("https://expired.badssl.com/");  // it will give privacy error if ssl is not handled

    }
    /**
     * chrome is being controlled by automated software.
     */
    @Test
    public void disableAutomatedMessageOnScreen()
    {
        EdgeOptions options=new EdgeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        WebDriver driver=new EdgeDriver(options);
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @Test
    public void incognitoMode()
    {
        EdgeOptions options=new EdgeOptions();
        options.addArguments("--incognito");
        WebDriver driver=new EdgeDriver(options);
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }
  
}

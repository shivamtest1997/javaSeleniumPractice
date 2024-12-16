package selenium_practice_set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class TestClassA {

    /**
     *  Launch Browser
     *  open url https://demo.opencart.com/
     *  validate title should be "Your Store"
     *  close browser
     */
    @Test
    public void m1()
    {
        WebDriver driver=new EdgeDriver();
        driver.get("https://demo.opencart.com/");

        String actualTitle = driver.getTitle();

        if (actualTitle.equals("Your Store"))
        {
            System.out.println("Test case passed");
        }
        else
        {
            System.out.println("Test case failed");
        }

        driver.close();

        // driver.quit();
    }

}

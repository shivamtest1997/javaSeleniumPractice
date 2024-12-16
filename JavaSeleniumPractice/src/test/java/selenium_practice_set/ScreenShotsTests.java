package selenium_practice_set;

import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.io.File;

public class ScreenShotsTests {
    WebDriver driver=new EdgeDriver();
    /**
     * full page screenShot -->TakesScreenShot
     * specific Area -->Selenium 4
     * web Element --->selenium 4
     */
    @Test
    public void m1()
    {
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();

        // capture full page screenshot

        TakesScreenshot sc=(TakesScreenshot)driver;
        File sourceFile = sc.getScreenshotAs(OutputType.FILE);// getScreenShotAs calling from TakesScreenShot interface

        // here System.getProperty("user.dir") returns current dir
        String targetFilePath=System.getProperty("user.dir")+"\\ScreenShots\\fullPage.png";

        File targetFile=new File(targetFilePath);
        sourceFile.renameTo(targetFile); // copy source file to target file

        // capture specific area screenshot
        // find locator which highlights specific area
        WebElement featureProductSection= driver.findElement(By.cssSelector(".home-page-product-grid"));
        File sourceFile1 = featureProductSection.getScreenshotAs(OutputType.FILE);  // getScreenShotAs calling from WebElement interface
        File targetFile1=new File(System.getProperty("user.dir")+"\\ScreenShots\\specificArea.png");
        sourceFile1.renameTo(targetFile1);

        // WebElement Screenshot
        WebElement logo= driver.findElement(By.xpath("//div[@class='header-logo']"));
        File sourceFile3=logo.getScreenshotAs(OutputType.FILE);
        File targetFile3=new File(System.getProperty("user.dir")+"\\ScreenShots\\webElement.png");
        sourceFile3.renameTo(targetFile3);

    }


}

package selenium_practice_set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class FrameAndIframes_Chapter5 {

    WebDriver driver=new EdgeDriver();
    /**
     * driver.switchTo().frame(argument);
     * argument -->index ,name ,WebElement
     * driver.switchTo().defaultContent() -->switching to main tab
     */
    @Test
    public void frames()
    {
        driver.manage().window().maximize();
        driver.get("https://ui.vision/demo/webtest/frames/");

        //locate frame first then switch to frame to locate require WebElement
        WebElement frame1=driver.findElement(By.xpath("//frame[contains(@src,'frame_1')]"));
        driver.switchTo().frame(frame1);
        driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("Hello Frame 1....!");


        driver.switchTo().defaultContent(); //after doing work on frame we should switch to main page

        WebElement frame2=driver.findElement(By.xpath("//frame[contains(@src,'frame_2')]"));
        driver.switchTo().frame(frame2);
        driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("Hello Frame 2....!");
        driver.switchTo().defaultContent();

        WebElement frame3=driver.findElement(By.xpath("//frame[contains(@src,'frame_3')]"));
        driver.switchTo().frame(frame3);
        driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("Hello Frame 3....!");


        driver.switchTo().frame(0); //switching to frame using index
        driver.findElement(By.xpath("//div[@jsmodel='CP1oW']/descendant::div[@id='i5']")).click();

        WebElement checkbox = driver.findElement(By.xpath("//div[@jscontroller='sWGJ4b']/descendant::div[@id='i19']"));
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", checkbox);
        driver.switchTo().defaultContent();

    }

}

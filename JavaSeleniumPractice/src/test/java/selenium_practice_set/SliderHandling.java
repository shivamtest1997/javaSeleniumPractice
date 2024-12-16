package selenium_practice_set;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SliderHandling {
    WebDriver driver=new EdgeDriver();

    @Test
    public void sliderTest()
    {
        driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
        driver.manage().window().maximize();

        WebElement minSliderBox=driver.findElement(By.xpath("(//span[contains(@class,'ui-slider-handle')])[1]"));

        // find location of element(x,y)
        System.out.println("position before movement"+minSliderBox.getLocation());

        Actions act=new Actions(driver);
        act.dragAndDropBy(minSliderBox, 150, 0).perform();
        System.out.println("position after movement"+minSliderBox.getLocation());

        WebElement maxSlider = driver.findElement(By.xpath("(//span[contains(@class,'ui-slider-handle')])[2]"));
        System.out.println(maxSlider.getLocation());

        act.dragAndDropBy(maxSlider, 50, 251);
        System.out.println("After moving max slider "+maxSlider.getLocation());
    }
}

package selenium_practice_set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class JavaScriptExecutorTest {
    WebDriver driver=new EdgeDriver();
    /**
     * JavascriptExecutor -->it is an interface
     * executeScript() method--->Is used to execute javascript statement
     * To avoid--> ElementInterceptedException
     * click and sendKeys
     * scrolling
     */
    @Test
    public void m1() {
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // alternative of sendKeys method
        WebElement nameElement = driver.findElement(By.xpath("//div[@class='form-group']/input[@id='name']"));
        js.executeScript("arguments[0].setAttribute('value','shivam')", nameElement);

        // alternative of click method
        WebElement maleRadioBtn = driver.findElement(By.xpath("//input[@id='male']"));
        js.executeScript("arguments[0].click();", maleRadioBtn);

        // scrolling the page
        //scroll by pixel value
        js.executeScript("window.scrollBy(0,800);");
        System.out.println(js.executeScript("return window.pageYOffset;"));

        // scroll page till element
        WebElement tableTitleElement = driver.findElement(By.xpath("//h2[text()='Web Table']"));
        js.executeScript("arguments[0].scrollIntoView();", tableTitleElement);
        System.out.println(js.executeScript("return window.pageYOffset;"));

        // scroll page till end of page
        js.executeScript("window.scrollBy(0,document.body.scrollHeight);", "");
        System.out.println(js.executeScript("return window.pageYOffset;"));

        // scroll till top of the page
        js.executeScript("window.scrollBy(0,-document.body.scrollHeight);", "");

        // Horizontal scroll
        js.executeScript("window.scrollBy(0,-document.body.scrollWidth);", "");

        // Zooming page
        js.executeScript("document.body.style.zoom='60%'"); // set zoom to 50%
    }

}

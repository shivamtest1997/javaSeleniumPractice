package selenium_practice_set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class JavaScriptExecutorTest {
    WebDriver driver=new EdgeDriver();
    /**
     * JavascriptExecutor -->it is an interface which is implemented by RemoteWebDriver class
     * executeScript() method--->Is used to execute javascript statement
     * Necessity of executing javaScript To avoid--> ElementInterceptedException
     *
     * JavascriptExecutor js=(JavascriptExecutor)driver;  //upcasting
     * sendKeys--> js.executeScript("arguments[0].setAttribute('value','shivam')",WebElement);
     *             WebElement is stored in argument[0]
     * click -->js.executeScript("arguments[0].click();",WebElement);
     * scrollingBy pixel-->js.executeScript("window.scrollBy(0,120);");
     * scrollingTillWebElement-->js.executeScript("argument[0].scrollIntoView();",WebElement);
     * bottomOfPage-->js.executeScript("window.scrollBy(0,document.body.scrollHeight","");
     * topOfPage-->js.executeScript("window.scrollBy(0,-document.body.scrollHeight","");
     * scrollWidth-->js.executeScript("window.scrollBy(120,0);");
     * zoom page -->js.executeScript("document.body.style.zoom='60%'");
     */
    @Test
    public void m1() {
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // alternative of sendKeys method
        WebElement nameElement = driver.findElement(By.xpath("//div[@class='form-group']/input[@id='name']"));
        js.executeScript("arguments[0].setAttribute('value','shivam')", nameElement);
        //clear text from WebElement
        js.executeScript("arguments[0].setAttribute('value','')", nameElement);

        // alternative of click method
        WebElement maleRadioBtn = driver.findElement(By.xpath("//input[@id='male']"));
        js.executeScript("arguments[0].click();", maleRadioBtn);

        // scrolling the page
        //scroll by pixel value
        js.executeScript("window.scrollBy(0,800);");
        System.out.println(js.executeScript("return window.pageYOffset;"));

        // scroll page till element
        WebElement tableTitleElement = driver.findElement(By.xpath("//h2[text()='Static Web Table']"));
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

    /**
     *
     */
    @Test
    public void uploadFiles()
    {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");

        String file1= "D:\\download (1).jpg";
        String file2= "D:\\images1.jpg";
        driver.findElement(By.id("filesToUpload")).sendKeys(file1+"\n"+file2);  // "\n" is next line

        List<WebElement> files=driver.findElements(By.xpath("//ul[@id='fileList']/li"));
        System.out.println("No of files uploaded : "+files.size());

    }

}

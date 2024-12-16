package selenium_practice_set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WebDriverMethods {
    WebDriver driver =new EdgeDriver();

    /** Get Methods
     *  get(url)
     *  getTitle()
     *  getCurrentUrl()
     *  getPageSource()
     *  getWindowHandle() --- returns id of single browser window
     *  getWindowHandles()--- returns ids of multiple browsers
     *
     * */
    @Test
    public void getMethods() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        String pageTitle=driver.getTitle();
        System.out.println(pageTitle);

        String currentUrl= driver.getCurrentUrl();
        System.out.println(currentUrl);

        String pageSource = driver.getPageSource();

        String singleBrowserId=driver.getWindowHandle();
        System.out.println(singleBrowserId);

        Thread.sleep(4000);
        driver.findElement(By.linkText("OrangeHRM, Inc")).click(); //this will open new window
        Set<String> multipleWindowIds = driver.getWindowHandles(); // return set of string
        System.out.println(multipleWindowIds);

    }

    /** conditional methods
     *  isDisplayed()
     *  isEnabled()
     *  isSelected() -->checkboxes radio buttons and dropdown
     */
    @Test
    public void conditionalMethods()
    {
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();

        WebElement logo =driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
        System.out.println("Displayed status : "+logo.isDisplayed());

        driver.findElement(By.linkText("Register")).click();

        boolean status=driver.findElement(By.xpath("//input[@id='FirstName']")).isEnabled();
        System.out.println("Text box is enabled: "+status);

        WebElement maleBtn=driver.findElement(By.xpath("//input[@id='gender-male']"));
        WebElement femaleBtn=driver.findElement(By.xpath("//input[@id='gender-female']"));

        System.out.println("before selecting status : "+maleBtn.isSelected());   //false
        System.out.println("before selecting status : "+femaleBtn.isSelected()); //false

        maleBtn.click();
        System.out.println("after selecting button status:"+maleBtn.isSelected()); //true
        femaleBtn.click();
        System.out.println("after selecting button status:"+femaleBtn.isSelected());//true

    }

    /**
     * get() --->Accept url only in String format
     * navigate().to(url) -->Accept url in String As well as url as Object form (URL muUrl=new URL("https://demo.nopcommerce.com/");)
     * navigate().forward()
     * navigate().back()
     * navigate().refresh()
     */
    @Test
    public void navigationalMethods()
    {
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Assert.assertEquals(driver.getTitle(), "OrangeHRM");

        driver.navigate().to("https://demo.nopcommerce.com/");
        Assert.assertEquals(driver.getTitle(), "nopCommerce demo store");

        driver.navigate().back();
        Assert.assertEquals(driver.getTitle(), "OrangeHRM");

        driver.navigate().forward();
        Assert.assertEquals(driver.getTitle(), "nopCommerce demo store");

        driver.navigate().refresh();
    }

    /**
     *
     *
     */
    @Test
    public void windowHandles()
    {
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();
        Set<String> windowIds = driver.getWindowHandles();  // Set Collection doesn't follow index so it doesn't contains get method to extract values

        //Approach 1 converting set to list
        List<String> windowList=new ArrayList<String>(windowIds);

        String parentId=windowList.get(0);
        String childId= windowList.get(1);

        //switch to child window
        driver.switchTo().window(childId);
        System.out.println("child window title:"+driver.getTitle());

        //switch to parent window
        driver.switchTo().window(parentId);
        System.out.println("Parent window title :"+driver.getTitle());

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



    @AfterClass
    public void closeBrowser()
    {
        driver.quit();
    }
}

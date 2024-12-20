package selenium_practice_set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WebDriverMethods_Chapter2 {
    WebDriver driver =new EdgeDriver();

    /** Get Methods
     *  get(url) -->opens url on browser
     *  getTitle()--> return title of webpage in string
     *  getCurrentUrl()-->return url of current page
     *  getPageSource()-->return source code of web page
     *  getWindowHandle() --- returns id of single browser window
     *  getWindowHandles()--- returns id's of multiple browsers windows
     *
     * */
    @Test
    public void getMethods() throws InterruptedException {
        driver.manage().window().maximize();
        //get()
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        //getTitle()
        String pageTitle=driver.getTitle();
        System.out.println(pageTitle);

        //getCurrentUrl()
        String currentUrl= driver.getCurrentUrl();
        System.out.println(currentUrl);

        //getPageSource() -->sometime to validate content security policy is present or not
        String pageSource = driver.getPageSource();

        //getWindowHandle()
        String singleBrowserId=driver.getWindowHandle();
        System.out.println(singleBrowserId); // window id is dynamic it will keep changing everytime when page load

        Thread.sleep(4000);
        driver.findElement(By.linkText("OrangeHRM, Inc")).click(); //this will open new window
        Set<String> multipleWindowIds = driver.getWindowHandles(); // return set of string
        System.out.println(multipleWindowIds);

    }
    /**
     * Browser methods
     * close() -->close single browser window
     * quit()  -->close all browser window
     */
     @Test
     public void browserMethods() throws InterruptedException {
         driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
         Thread.sleep(4000);
         driver.findElement(By.linkText("OrangeHRM, Inc")).click(); //this will open new window
         Thread.sleep(4000);
         driver.close();
         driver.quit();
     }
    /** conditional methods apply on WebElement
     *  isDisplayed()  -->check element visibility on web page
     *  isEnabled()    -->check webElement is enabled or disabled
     *  isSelected()   -->checkboxes radio buttons and dropdown is selected or not
     */
    @Test
    public void conditionalMethods()
    {
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();

        WebElement logo =driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
        System.out.println("Displayed status : "+logo.isDisplayed()); // true

        driver.findElement(By.linkText("Register")).click();

        boolean status=driver.findElement(By.xpath("//input[@id='FirstName']")).isEnabled(); // true
        System.out.println("Text box is enabled: "+status);

        WebElement maleBtn=driver.findElement(By.xpath("//input[@id='gender-male']"));
        WebElement femaleBtn=driver.findElement(By.xpath("//input[@id='gender-female']"));

        System.out.println("before selecting status : "+maleBtn.isSelected());   //false
        System.out.println("before selecting status : "+femaleBtn.isSelected()); //false

        maleBtn.click();
        System.out.println("after selecting button status:"+maleBtn.isSelected()); //true
        femaleBtn.click();
        System.out.println("after selecting button status:"+femaleBtn.isSelected());//true

        driver.findElement(By.xpath("//input[@id='Newsletter']")).isSelected();
    }

    /**
     * get() --->Accept url only in String format
     * navigate().to(url) -->Accept url in String as well as url as Object format (URL myUrl=new URL("https://demo.nopcommerce.com/");)
     * navigate().forward()
     * navigate().back()
     * navigate().refresh()
     */
    @Test
    public void navigationalMethods() throws MalformedURLException {
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Assert.assertEquals(driver.getTitle(), "OrangeHRM");

       // driver.navigate().to("https://demo.nopcommerce.com/");
        //or
        URL myURL=new URL("https://demo.nopcommerce.com");
        driver.navigate().to(myURL);
        Assert.assertEquals(driver.getTitle(), "nopCommerce demo store");

        driver.navigate().back();
        Assert.assertEquals(driver.getTitle(), "OrangeHRM");

        driver.navigate().forward();
        Assert.assertEquals(driver.getTitle(), "nopCommerce demo store");

        driver.navigate().refresh();
    }

    /**
     * window handles methods
     *
     */
    @Test
    public void windowHandles()
    {
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();
        Set<String> windowIds = driver.getWindowHandles();
        // Set Collection doesn't follow index so it doesn't contains get method to extract values

        //Approach 1 converting set to list
        ArrayList<String> windowList=new ArrayList<String>(windowIds);

        String parentId=windowList.get(0);
        String childId= windowList.get(1);

        //switch to child window
        // syntax :  driver.switchTo().window(winId);
        driver.switchTo().window(childId);
        System.out.println("child window title:"+driver.getTitle());

        //switch to parent window
        driver.switchTo().window(parentId);
        System.out.println("Parent window title :"+driver.getTitle());

        //Approach 2 -->When having multiple window ids more than 2
        for(String id:windowIds)
        {
            String title=driver.switchTo().window(id).getTitle();
            if (title.equals("Human Resources")|| title.equals("some other window title"))
            {
                System.out.println(driver.getCurrentUrl());
                driver.close();
            }
        }

    }



    @AfterClass
    public void closeBrowser()
    {
       // driver.quit();
    }
}

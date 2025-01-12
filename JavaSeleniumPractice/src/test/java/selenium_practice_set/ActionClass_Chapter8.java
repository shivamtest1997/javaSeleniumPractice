package selenium_practice_set;

import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Set;

public class ActionClass_Chapter8 {

    WebDriver driver=new EdgeDriver();
    /**
     * right click -->contextClick(element).perform();
     * double click
     * mouse hover  --->moveToElement(element).perform();
     * drag and drop
     * Actions -->predefined class provided by selenium
     *
     * build() -->create an action
     * perform() --> build and complete action
     * when ever we came to know scenario where we need to build actions first then perform after certain operation we have
     * use both build() and perform()
     */
    @Test
    public void mouseHover()
    {
        driver.get("https://demo-opencart.com/");
        driver.manage().window().maximize();

        WebElement desktop = driver.findElement(By.xpath("//a[normalize-space()='Desktops']"));
        WebElement mac=driver.findElement(By.xpath("//a[normalize-space()='Mac (0)']"));

        Actions act=new Actions(driver);
       // act.moveToElement(desktop).moveToElement(mac).click().build().perform();
        act.moveToElement(desktop).moveToElement(mac).click().perform();   //here click() method called from actions class
        driver.findElement(By.xpath("//h2[text()='Desktops']")).isDisplayed();
    }

    /**
     * Actions act=new Actions(driver);
     * act.contextClick(WebElement).build().perform()-->is used to Right Click on WebElement
     */
    @Test
    public void rightClick()
    {
        driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
        driver.manage().window().maximize();

        WebElement button=driver.findElement(By.cssSelector("span.context-menu-one"));
        Actions act=new Actions(driver);

        act.contextClick(button).build().perform();

        // click on copy
        driver.findElement(By.xpath("//span[normalize-space()='Copy']")).click();
        //close alert
        String alertText=driver.switchTo().alert().getText();
        Assert.assertEquals(alertText, "clicked: copy");
        driver.switchTo().alert().accept(); // close alert pop up

    }

    /**
     * Actions act=new Actions(driver);
     * act.doubleClick(WebElement).build().perform();
     */
    @Test
    public void doubleClick()
    {
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick3");
        driver.manage().window().maximize();

        //switch to iframe use id or name or locator
        driver.switchTo().frame("iframeResult");

        WebElement field1 = driver.findElement(By.xpath("//input[@id='field1']"));
        WebElement field2 = driver.findElement(By.xpath("//input[@id='field2']"));
        WebElement btn=driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));

        field1.clear();
        field1.sendKeys("Hi Shivam");
        Actions act=new Actions(driver);
        Action doubleClick = act.doubleClick(btn).build();
        doubleClick.perform();
        String field2Text = field2.getAttribute("value"); //getText() method is not used here because getText()always capture inner text
        Assert.assertEquals(field2Text, "Hi Shivam");

    }

    /**
     * Actions act=new Actions(driver);
     * act.dragAndDrop(source WebElement,destination WebElement).build().perform();
     * act.dragAndDropBy(WebElement,xOffset,yOffset).build().perform(); -->to move the slider
     */
    @Test
    public void dragAndDrop()
    {
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();
        WebElement source=driver.findElement(By.id("draggable"));
        WebElement target= driver.findElement(By.id("droppable"));

        Actions act=new Actions(driver);
        act.dragAndDrop(source, target).perform();
        //slider
        WebElement sliderRightPoint=driver.findElement(By.xpath("//div[@id='slider-range']/span[2]"));
        Point locationOfSliderPoint = sliderRightPoint.getLocation(); //(x,y)
        System.out.println("current position is :"+locationOfSliderPoint);
        act.dragAndDropBy(sliderRightPoint, 100, 0).perform();
        System.out.println("Location after movement"+sliderRightPoint.getLocation());
    }
    /**
     * Action vs Actions
     * Actions --> class ,will be used to perform mouse actions
     * Action -->Interface, will be used to store created actions.
     * Example :
     *         Actions act=new Actions(driver);
     *         Action doubleClick = act.doubleClick(btn).build();
     *         doubleClick.perform();
     */

    /**
     * keyboard actions using Actions Class.
     */
    @Test
    public void keyboardActions()
    {
        driver.get("https://text-compare.com/");
        driver.manage().window().maximize();

        WebElement textArea1 = driver.findElement(By.id("inputText1"));
        textArea1.sendKeys("Hi Shivam How Are you?");

        Actions act=new Actions(driver);

        // ctr+A  -->select text
        act.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();

        // ctrl+C --->copy
        act.keyDown(Keys.CONTROL).sendKeys("C").keyUp(Keys.CONTROL).perform();

        // Tab    -->move to next text area

        act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();

        // ctrl+V --->paste text
        act.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).perform();
        //clear text in second area
        act.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).keyDown(Keys.BACK_SPACE).keyUp(Keys.BACK_SPACE).build().perform();
        //clear text in first area
        act.keyDown(Keys.SHIFT).keyDown(Keys.TAB)
                .keyDown(Keys.BACK_SPACE).keyUp(Keys.BACK_SPACE)
                .keyUp(Keys.TAB)
                .keyUp(Keys.SHIFT)
                .build().perform();

    }

    /**
     * This Can be achieved using Keyboard actions
     */
    @Test
    public void openLinkInNewTab()
    {
        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
        driver.manage().window().maximize();

        WebElement register = driver.findElement(By.xpath("//a[@class='ico-register']"));
        //register.click(); //it will open in same tab

        Actions act=new Actions(driver);
        act.keyDown(Keys.CONTROL).click(register).keyUp(Keys.CONTROL).perform(); // open in new tab

        //switching to child tab
        Set<String> ids = driver.getWindowHandles();
        ArrayList<String> al=new ArrayList<>(ids);
        String childTabId = al.get(1);

        driver.switchTo().window(childTabId);
        driver.findElement(By.id("gender-male")).click();

        //switching back to home page
        driver.switchTo().window(al.get(0));

    }

    /**
     * Tabs and Windows
     * driver.switchTo.newWindow(WindowType.TAB); -->This will open new tab in same window
     * driver.switchTo.newWindow(WindowType.WINDOW);
     */
    @Test
    public void tabsAndWindows()
    {
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
        driver.switchTo().newWindow(WindowType.TAB);  // available on selenium 4 onwards to open new tab
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.switchTo().newWindow(WindowType.WINDOW); // to open new window
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"); // driver focus on second window

        Set<String> ids = driver.getWindowHandles();
        System.out.println(ids);
        for (String id:ids)
        {
            driver.switchTo().window(id); // switch to current window
            if (driver.getTitle().contains("nopCommerce"))
            {
                driver.findElement(By.id("gender-male")).click();
                break;
            }
        }
    }
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

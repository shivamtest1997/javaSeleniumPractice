package selenium_practice_set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Locators {
    WebDriver driver;
    // All locators are present inside By class

    /**
     * id
     * name
     * linkText
     * partialLinkText
     * className
     * tagName
     */
    @Test
    public void basicLocators() throws InterruptedException {
        driver = new EdgeDriver();
        driver.get("https://magento.softwaretestingboard.com/");
        driver.manage().window().maximize();    // to maximize window

        //name
        driver.findElement(By.name("q")).sendKeys("shirt for men");
        //id
        WebElement whatsNewLink = driver.findElement(By.id("ui-id-3"));
        whatsNewLink.isDisplayed();


        //linkText  -> when tag is <a and attribute is href='link'
        WebElement tablet = driver.findElement(By.linkText("What's New"));
        tablet.click();
        // partialLinkText
        // driver.findElement(By.partialLinkText("Desktop")).click();

        //Note---> PartialLinkText is not prefer as it may match in multiple links

        //tag name
        List<WebElement> allImages = driver.findElements(By.tagName("img"));
        System.out.println("total number of images are: " + allImages.size());


        //class name
        driver.findElement(By.className("not-logged-in")).click();
    }

    /**
     * CSS Selector (Cascading style sheet)
     * tag#id --> tag#id
     * tag.class --> tag.className                    tag is optional
     * tag[attribute]---> tag[attribute=value]
     * tag class attribute -->tag.className[attribute='value']
     *
     */
    @Test
    public void cssSelector()
    {
        driver = new EdgeDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();

        //tag#id
        driver.findElement(By.cssSelector("input#small-searchterms")).sendKeys("T-shirts");

        //tag.className

        driver.findElement(By.cssSelector("input.search-box-text")).sendKeys("Shirts");

        //tag[attribute='value']
        driver.findElement(By.cssSelector("input[name='q']")).sendKeys(" tagAttributeValue");

        //tag.className[Attribute='value']
        driver.findElement(By.cssSelector("input.search-box-text[placeholder='Search store']")).clear();

    }
    /**
     * xpath methods
     */
    @Test
    public void xPaths()
    {
        driver=new EdgeDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();

        // x path with single attribute
        driver.findElement(By.xpath("//*[@id='small-searchterms']"));

        // xpath with multiple attribute
        driver.findElement(By.xpath("//*[@id='small-searchterms'][@name='q']")).sendKeys("T shirts");

        // xpath with operators
        // 'and'
        driver.findElement(By.xpath("//*[@id='small-searchterms' and @name='q']")).clear();

        // 'or'
        driver.findElement(By.xpath("//*[@id='small-searchterms' or @name='q5122']")).isDisplayed();

        // xpath with inner text
        driver.findElement(By.xpath("//a[text()='Search']")).click();

        // normalize-space() -->if there is space before and after inner text use
        String text=driver.findElement(By.xpath("//li[normalize-space()='Computers'] ")).getText();
        System.out.println(text);

        // xpath with 'contains()' -->sometimes we have to locate element with partial value
        driver.findElement(By.xpath("//input[contains(@placeholder,'Search')]")).sendKeys("T shirt");

        // xpath with 'starts-with()' -->prefer for locating dynamic web element
        driver.findElement(By.xpath("//input[starts-with(@placeholder,'Sea')]")).clear();

        /*
         there is button "START" which changed to "STOP" after clicking
         we can write x path for such button

              //*[@id='start' or @id='stop']
              //*[contains(@id , 'st')]
              //*[starts-with(@id ,'s')]
              //*[contains(text(),'st')]

         */

        //chained xpath -->combination of relative and absolute xpath
        driver.findElement(By.xpath("//div[@class='header-logo']/a/img")).isDisplayed();

        // if tag is like this and there is no inner text <div><div>
        // [contains(text(),'']
        // [contains(.,'']

    }
    /**
     *Ancestor
     * Parent
     * Self
     * Child
     * Descendant
     *
     */
    @Test
    public void xpathAxes()
    {
        driver = new EdgeDriver();
        driver.get("https://money.rediff.com/gainers");
        driver.manage().window().maximize();

        //self
        String text=driver.findElement(By.xpath("//a[contains(text(),'Indian Railway Fin')]/self::a")).getText();
        System.out.println(text);

        //parent
        String text1 = driver.findElement(By.xpath("//a[contains(text(),'Indian Railway Fin')]/parent::td")).getText();
        System.out.println(text1);

        //ancestor
        WebElement text2 = driver.findElement(By.xpath("//a[contains(text(),'Indian Railway Fin')]/ancestor::tr"));
        System.out.println(text2);

        //child
        List<WebElement> childs = driver.findElements(By.xpath("//a[contains(text(),'Indian Railway Fin')]/ancestor ::tr/child::td"));
        System.out.println(childs.size());

        //descendant (selects all descendants children ,grandchildren's of current node
        List<WebElement> descendants = driver.findElements(By.xpath("//a[contains(text(),'Indian Railway Fin')]/ancestor ::tr/descendant::*"));
        System.out.println(descendants.size());

        //following (selects everything in dom after closing tag of current node)
        List<WebElement> followingNodes = driver.findElements(By.xpath("//a[contains(text(),'Indian Railway Fin')]/ancestor ::tr/following::tr"));
        System.out.println("no of following nodes : "+followingNodes.size());

        //preceding (selects everything in dom before closing tag of current node)
        List<WebElement> precedingNodes = driver.findElements(By.xpath("//a[contains(text(),'Indian Railway Fin')]/ancestor ::tr/preceding::tr"));
        System.out.println("No of preceding elements : "+precedingNodes.size());


    }


//    @AfterClass
//    public void closeBrowser() {
//        driver.close();
//    }
}

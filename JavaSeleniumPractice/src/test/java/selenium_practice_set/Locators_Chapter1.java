package selenium_practice_set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.util.List;

public class Locators_Chapter1 {
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


        // scenario : locator is matching with singleWebElement
        // findElement()-->single WebElement return Single WebElement
        // findElements()-->single WebElement return List<WebElement>

        //scenario : locator is matching with multiple web elements
        //findElement() -->Single element return first WebElement
        //findElements() --> multiple elements return List<WebElement>

        //scenario :locator is not matching with any webElement
        //findElement() -->return No Such Element Exception
        //findElements() -->return 0 will not throw any exception

    }

    /**
     * CSS Selector (Cascading style sheet)
     * tag#id --> tag#id
     * tag.class --> tag.className                    tag is optional
     * tag[attribute]---> tag[attribute=value]
     * tag class attribute -->tag.className[attribute='value']
     * tag:nth-child(index)--locate element based on index.
     */
    @Test
    public void cssSelector() {
        driver = new EdgeDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();

        //tag#id
        driver.findElement(By.cssSelector("input#small-searchterms")).sendKeys("T-shirts");

        //tag.className
        driver.findElement(By.cssSelector("input.search-box-text")).sendKeys("Shirts");

        //tag[attribute='value']
        driver.findElement(By.cssSelector("input[name='q']")).clear();

        //tag.className[Attribute='value']
        driver.findElement(By.cssSelector("input.search-box-text[placeholder='Search store']")).clear();

        String text=driver.findElement(By.cssSelector("ul label:nth-child(2)")).getText();
        System.out.println(text);

    }

    /**
     * 1)Absolute x path(full xpath) /html/body/div[1]/div[2]/div[2]/div/div/main/div[2]/wm-tab-panel\
     * it will navigate from root node and cover each node till it reaches required address
     * when developer introduce new element in between then absolute xpath will break and unable to find locator
     * always starts with /--> represent root node
     * do not use attributes
     *
     * 2)Relative xpath (partial xpath)//*[@id="abc"]
     * it will directly jump to required element using attributes
     * this is xpath will not impact due to changes in web page
     * starts with //
     * works on attribute
     *
     * xpath methods
     */
    @Test
    public void xPaths() {
        driver = new EdgeDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();

        // x path with single attribute syntax: //tagName[@attribute='value'] or //*[@attribute='value']
        driver.findElement(By.xpath("//*[@id='small-searchterms']"));

        // xpath with multiple attribute syntax: //*[@attribute1='value'][@attribute2='value']
        driver.findElement(By.xpath("//*[@id='small-searchterms'][@name='q']")).sendKeys("T shirts");

        // xpath with operators
        // 'and'
        driver.findElement(By.xpath("//*[@id='small-searchterms' and @name='q']")).clear();

        // 'or'
        driver.findElement(By.xpath("//*[@id='small-searchterms' or @name='q5122']")).isDisplayed();

        // xpath with inner text syntax: //*[text()='innerText']
        driver.findElement(By.xpath("//a[text()='Search']")).click();

        // normalize-space() -->if there is space before and after inner text use syntax: //*[normalize-space()='innerText']
        String text = driver.findElement(By.xpath("//li[normalize-space()='Computers'] ")).getText();
        System.out.println(text);

        // xpath with 'contains()' -->sometimes we have to locate element with partial value syntax: //*[contains(@attribute,'value')]
        driver.findElement(By.xpath("//input[contains(@placeholder,'Search')]")).sendKeys("T shirt");

        // xpath with 'starts-with()' syntax://tagName[starts-with(@attribute,'value')] -->prefer for locating dynamic web element
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
        // [contains(.,''] .represents text()

    }

    /**
     * Xpath Axes:
     * Ancestor
     * Parent
     * Self
     * Child
     * Descendant
     * following
     * preceding
     * following-sibling
     * preceding-sibling
     */
    @Test
    public void xpathAxes() {
        driver = new EdgeDriver();
        driver.get("https://money.rediff.com/gainers");
        driver.manage().window().maximize();

        /** Example:
         * <form id="frmlogin" method="post" action="index.php"
         *   <div id="divUsername" class="txtInputContainer">
         *       <input name='textusername' id='textusername' type="text">
         *       <span class="form-hint" style="display">Username</span>
         *   <div id="divPassword" class="txtInputcontainer">
         *       <input name='textpassword' id='textpassword' type="text">
         *       <span class="form-hint" style="display">Password</span>
         */
        //self
        String text = driver.findElement(By.xpath("//a[contains(text(),'Suraj Industries')]/self::a")).getText();
        System.out.println(text);

        /**
         * Parent
         * ex: //input[@id='txtUsername']/parent::div -->tagname
         * ex: //input[@id='txtusername']/parent::*    -->locate parent available
         * ex: //input[@id='txtusername']/..           --->locate parent of selfNode
         */
        String text1 = driver.findElement(By.xpath("//a[contains(text(),'Indian Railway Fin')]/parent::td")).getText();
        System.out.println(text1);

        /**
         * ancestor
         * ex:  //input[@id='username']/ancestor::form
         * ex:  //input[@id='username']/ancestor::*
         */
        WebElement text2 = driver.findElement(By.xpath("//a[contains(text(),'Indian Railway Fin')]/ancestor::tr"));
        System.out.println(text2);

        /**
         * Child
         * ex: //input[@id='username']/child::span
         * ex: //input[@id='username']/span
         */
        List<WebElement> childs = driver.findElements(By.xpath("//a[contains(text(),'Indian Railway Fin')]/ancestor ::tr/child::td"));
        System.out.println(childs.size());

        /**
         * descendant (selects all descendants children ,grandchildren's of current node)
         * ex //form[@id='frmlogin']/descendant::input
         * ex //form[@id='frmlogin']//input
         */
        List<WebElement> descendants = driver.findElements(By.xpath("//a[contains(text(),'Indian Railway Fin')]/ancestor ::tr/descendant::*"));
        System.out.println(descendants.size());

        /**
         * following (selects everything in dom after closing tag of current node)
         * ex //input[@id='txtusername']/following::input[@id='textpassword']
         * ex //input[@id='txtusername']/following::input[last()] -->to locate last input tag element
         * ex //input[@id='txtusername']/following::input[first()] -->to locate first input tag element
         */
        List<WebElement> followingNodes = driver.findElements(By.xpath("//a[contains(text(),'Indian Railway Fin')]/ancestor ::tr/following::tr"));
        System.out.println("no of following nodes : " + followingNodes.size());

        /**
         *    preceding (selects everything in dom before closing tag of current node)
         *    ex  //input[@id='textPassword']/preceding::input[@id='textUsername']
         */
        List<WebElement> precedingNodes = driver.findElements(By.xpath("//a[contains(text(),'Indian Railway Fin')]/ancestor ::tr/preceding::tr"));
        System.out.println("No of preceding elements : " + precedingNodes.size());

        /**
         * following-sibling
         * ex //input[@id='textPassword']/following-sibling::span
         * preceding-sibling
         * ex //span[text()='Password']/preceding-sibling::input
         */

    }
    @AfterClass
    public void closeBrowser() {
        driver.close();
    }
}

package selenium_practice_set;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class ShadowDomElements {
    WebDriver driver=new EdgeDriver();
    /**
     *
     * Document >> Shadow host>> shadow root >>Elements (div which holds shadow root is called as shadow host)
     * We can't locate element using xpath we need to locate
     * using css selector
     * Shadow Host-->Element holding shadow root
     *
     */
    @Test
    public void m1() {
        driver.manage().window().maximize();
        driver.get("https://dev.automationtesting.in/shadow-dom");

        //shadowElement
        SearchContext shadowRoot = driver.findElement(By.cssSelector("#shadow-root")).getShadowRoot(); //shadowHost.getShadowRoot

        WebElement element1 = shadowRoot.findElement(By.cssSelector("#shadow-element"));
        System.out.println(element1.getText());

        // nested shadow element
        SearchContext shadowRoot00 = driver.findElement(By.cssSelector("#shadow-root")).getShadowRoot();
        SearchContext shadowRoot11 = shadowRoot00.findElement(By.cssSelector("#inner-shadow-dom")).getShadowRoot();

        WebElement nestedElement =shadowRoot11.findElement(By.cssSelector("#nested-shadow-element"));
        System.out.println(nestedElement.getText());

        // multi-nested shadow element
        SearchContext shadowRoot0 = driver.findElement(By.cssSelector("#shadow-root")).getShadowRoot();
        SearchContext shadowRoot1 = shadowRoot0.findElement(By.cssSelector("#inner-shadow-dom")).getShadowRoot();

        SearchContext shadowRoot3 = shadowRoot1.findElement(By.cssSelector("#nested-shadow-dom")).getShadowRoot();

        WebElement multiNestedElement = shadowRoot3.findElement(By.cssSelector("#multi-nested-shadow-element"));
        System.out.println(multiNestedElement.getText());

    }

    @Test
    public void shadowExample()
    {
        driver.manage().window().maximize();
        driver.get("https://books-pwakit.appspot.com/");

        WebElement host1 = driver.findElement(By.cssSelector("book-app[apptitle='BOOKS']"));
        SearchContext shadowRootBook1 = host1.getShadowRoot();

        shadowRootBook1.findElement(By.cssSelector("#input")).sendKeys("Shivam");
    }


}

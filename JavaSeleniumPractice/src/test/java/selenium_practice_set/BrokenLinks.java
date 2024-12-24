package selenium_practice_set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.List;

public class BrokenLinks {

    WebDriver driver=new EdgeDriver();

    /**
     * Broken links --->Links doesn't have any resource in server also respond with status code >=400.
     * @throws IOException
     */
    @Test
    public void m1() throws IOException {
        driver.get("http://www.deadlinkcity.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 1. status code >=400 its broken link
        // 2. Links should have href="https://xyz.com" attribute
        // 3. Links hit Url--->server-->response code

        List<WebElement> allPresentLinks = driver.findElements(By.tagName("a"));
        System.out.println("Total No of links : "+allPresentLinks.size());
       int noBrokenLinks=0;
        for (WebElement link:allPresentLinks)
        {
            String attributeValue = link.getAttribute("href");
            if (attributeValue==null||attributeValue.isEmpty()){
                System.out.println("href attribute values is null not possible to check");
                continue; // it will skip current value and check next value
            }
            try {
                // hit url to server <-- covert string to url
                URL linkUrl=new URL(attributeValue);
                HttpURLConnection connection = (HttpURLConnection) linkUrl.openConnection();// this method will open connection to server
                connection.connect(); // connect to server and sent request to server
                if (connection.getResponseCode()>=400)
                {
                    System.out.println(attributeValue+" : is Broken Link");
                    noBrokenLinks++;
                }
                else
                {
                    System.out.println(attributeValue+": Its not broken lin");
                }
            }catch (Exception e)
            {}
        }
        System.out.println("Total broken link count : "+noBrokenLinks);
    }

}

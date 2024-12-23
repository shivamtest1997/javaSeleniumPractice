package selenium_practice_set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class AutoSuggestDropDownAndStaticTable {
    WebDriver driver=new EdgeDriver();

    /**
     * find out list of all element
     * then get text of element where matches then click operation
     */
    @Test
    public void autoSuggestedDropdown()
    {
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.xpath("//textarea[@name='q']")).sendKeys("Selenium");

        List<WebElement> suggestionList = driver.findElements(By.xpath("//ul[@role='listbox']/descendant::div[@role='option']"));
        System.out.println("No of Suggested options are :"+suggestionList.size());
        for (WebElement s:suggestionList)
        {
            if (s.getText().equals("selenium webdriver"))
            {
                s.click();
                break;
            }
        }
        driver.getCurrentUrl().contains("selenium+webdriver");
    }

    /**
     *
     * 1)Static Web Tables (fixed no of rows and fixed no of column)
     * 2)Dynamic Web Tables (Columns are fixed but rows will change)
     * 3)pagination Table (contains elements distributed in multiple pages)
     *
     */
    @Test
    public void staticWebTable()
    {
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // 1) find total number of rows in table

        int rowsNo=driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
        System.out.println(rowsNo); //7

        // 2) find total no of columns
        int columnNo=driver.findElements(By.xpath("//table[@name='BookTable']//th")).size();
        System.out.println(columnNo); //4

        // 3) Read specific row and column
        String data=driver.findElement(By.xpath("//table[@name='BookTable']//tr[5]/td[1]")).getText();
        System.out.println("Cell data: "+data);

        // 4)Read all rows and column
        //print header
        for (int i=1;i<=columnNo;i++)
        {
            String header = driver.findElement(By.xpath("//table[@name='BookTable']/descendant::tr/th["+i+"]")).getText();
            System.out.print(header+"\t"+"\t");
        }
        System.out.println();
        for (int r=2;r<=rowsNo;r++)
        {
            for (int c=1;c<=columnNo;c++) {
                String s = driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + r + "]/td[" + c + "]")).getText();
                System.out.print(s+"\t");
            }
            System.out.println();
        }

        // print book names whose author is mukesh
        for (int r=2;r<rowsNo;r++)
        {
            String authorName = driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + r + "]/td[2]")).getText();
            if (authorName.contains("Mukesh"))
            {
                String bookName = driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + r + "]/td[1]")).getText();
                System.out.println(bookName);
            }
        }
        // capture all prices and find total prices
        int sum=0;
        for (int r=2;r<+rowsNo;r++)
        {
            String prices=driver.findElement(By.xpath("//table[@name='BookTable']/descendant::tr["+r+"]/td[4]")).getText();
            System.out.println(prices);
            sum+=Integer.parseInt(prices);
        }
        System.out.println("total prices of all books is "+sum);
    }

    @Test
    public void dynamicTable() throws InterruptedException {
        driver.get("https://demo-opencart.com/admin/index.php?route=common/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

       // 1.login
       WebElement username=driver.findElement(By.id("input-username"));
       username.clear();
       username.sendKeys("demo");
       WebElement password = driver.findElement(By.id("input-password"));
       password.clear();
       password.sendKeys("demo");
       driver.findElement(By.xpath("//button[@type='submit']")).click();

        // 2.close window if appear on screen
        if (driver.findElement(By.cssSelector(".btn-close")).isDisplayed())
        {
            driver.findElement(By.cssSelector(".btn-close")).click();
        }
        // 3.click on customers>customers
        driver.findElement(By.xpath("//li[@id='menu-customer']")).click();
        driver.findElement(By.xpath("//li[normalize-space()='Customers']")).click();
        // 4.check page header Customers is displayed
        driver.findElement(By.xpath("//h1[normalize-space()='Customers']")).isDisplayed();

        // 5.find total number of pages
        String pagesText=driver.findElement(By.xpath("//div[@class='col-sm-6 text-end']")).getText();
        int indexOfBracket = pagesText.indexOf("(");
        int indexOfPagesText=pagesText.indexOf("Pages");
        String totalPageCount = pagesText.substring(indexOfBracket + 1, indexOfPagesText - 1);
        System.out.println(totalPageCount);
        Thread.sleep(4000);
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        // 6.click on each page
        for (int p=1;p<Integer.parseInt(totalPageCount);p++)
        {
            js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
             if (p>1) // if page is >1 then click on page which means we don't need to click on first page
            {
                WebElement activePage=driver.findElement(By.xpath("//ul[@class='pagination']//a[normalize-space()='"+p+"']"));
                wait.until(ExpectedConditions.elementToBeClickable(activePage)).click();
                Thread.sleep(2000);
            }

          // 7.reading data from page

            int noOfRows = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr")).size();
             for (int i=1;i<=noOfRows;i++)
             {
                  String customerName = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr["+i+"]/td[2]")).getText();
                  String customerEmail = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr["+i+"]/td[3]")).getText();
                  String status = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr["+i+"]/td[4]")).getText();

                 System.out.println(customerName+"\t"+customerEmail+"\t"+status);
             }

        }

    }



}

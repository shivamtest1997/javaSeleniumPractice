package selenium_practice_set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.time.Month;
import java.util.HashMap;
import java.util.List;

public class DatePickersCalenders {

    WebDriver driver = new EdgeDriver();


    /**
     * This method will select future date.
     *
     * @param driver
     * @param month
     * @param year
     * @param date
     */
    public void selectFutureDate(WebDriver driver, String month, String year, String date) {
        while (true) {
            // Actual Data
            String currentMonth = driver.findElement(By.cssSelector(".ui-datepicker-month")).getText();
            String currentYear = driver.findElement(By.cssSelector(".ui-datepicker-year")).getText();

            if (currentMonth.equals(month) && currentYear.equals(year)) {
                break;
            }
            driver.findElement(By.xpath("//span[text()='Next']")).click(); //Next
        }
        List<WebElement> dates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a"));
        for (WebElement d : dates) {
            if (d.getText().equals(date)) {
                d.click();
                break;
            }
        }

    }

    /**
     * This method will select future date.
     *
     * @param driver
     * @param month
     * @param year
     * @param date
     */
    public void selectPastDate(WebDriver driver, String month, String year, String date) {
        while (true) {
            // Actual Data
            String currentMonth = driver.findElement(By.cssSelector(".ui-datepicker-month")).getText();
            String currentYear = driver.findElement(By.cssSelector(".ui-datepicker-year")).getText();

            if (currentMonth.equals(month) && currentYear.equals(year)) {
                break;
            }
            driver.findElement(By.xpath("//span[text()='Previous']")).click(); //Next
        }
        List<WebElement> dates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a"));
        for (WebElement d : dates) {
            if (d.getText().equals(date)) {
                d.click();
                break;
            }
        }
    }

    @Test
    public void datePicker1() {
        driver.get("https://jqueryui.com/datepicker/");
        driver.manage().window().maximize();
        WebElement frame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
        driver.switchTo().frame(frame);

        // Method 1 : using sendKeys()
        driver.findElement(By.id("datepicker")).sendKeys("02/15/2024");

        // expected
        String month = "May";
        String year = "2025";
        String date = "15";

        selectFutureDate(driver, month, year, date);
    }

    /**
     * This method is used to concert string month to month object.
     *
     * @param month
     * @return
     */
    public Month convertMonth(String month) {
        HashMap<String, Month> hm = new HashMap<>();

        hm.put("January", Month.JANUARY);
        hm.put("February", Month.FEBRUARY);
        hm.put("March", Month.MARCH);
        hm.put("April", Month.APRIL);
        hm.put("May", Month.MAY);
        hm.put("June", Month.JUNE);
        hm.put("July", Month.JULY);
        hm.put("August", Month.AUGUST);
        hm.put("September", Month.SEPTEMBER);
        hm.put("October", Month.OCTOBER);
        hm.put("November", Month.NOVEMBER);
        hm.put("December", Month.DECEMBER);

        Month vmonth = hm.get(month);
        if (vmonth == null) {
            System.out.println("Invalid month....!");
        }
        return vmonth;
    }

    /**
     * This method will select date for date picker 2.
     *
     * @param driver
     * @param year
     * @param requiredMonth
     * @param requireDate
     */
    public void selectDate(WebDriver driver, String year, String requiredMonth, String requireDate) {
        //select Year
        WebElement yearDropdown = driver.findElement(By.xpath("//select[@aria-label='Select year']"));
        Select sel = new Select(yearDropdown);
        sel.selectByVisibleText(year);

        // select month
        while (true) {

            String displayedMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();

            // convert require month and displayed month into object
            Month expectedMonth = convertMonth(requiredMonth);
            Month currentMonth = convertMonth(displayedMonth);

            // compare
            int result = expectedMonth.compareTo(currentMonth);

            // 0 months are equal
            // >0 future month
            // <0 past month

            if (result < 0) {
                // past month
                driver.findElement(By.xpath("//a[@data-handler='prev']")).click();
            } else if (result > 0) {
                //future month
                driver.findElement(By.xpath("//a[@data-handler='next']")).click();
            } else {
                break;
            }
        }
        // date selection
        List<WebElement> dates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a"));
        for (WebElement d : dates) {
            if (d.getText().equals(requireDate)) {
                d.click();
                break;
            }
        }
    }

    // Another type of date picker
    @Test
    public void datePicker2() throws InterruptedException {
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();
        WebElement frame = driver.findElement(By.xpath("//iframe[contains(@id,'frame-one')]"));
        driver.switchTo().frame(frame);

        // expected
        String requiredMonth = "November";
        String year = "1997";
        String requireDate = "10";
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement datePickerIcon = driver.findElement(By.cssSelector(".icon_calendar"));
        js.executeScript("arguments[0].scrollIntoView(true);", datePickerIcon);
        datePickerIcon.click();
        Thread.sleep(2000);

        selectDate(driver, year, requiredMonth, requireDate);


    }
}
package selenium_practice_set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class DataDrivenTest2 {


    /**
     *  1) functionality (What is Test case)
     *  2) prepare test data in excel
     *  3) develop automation script
     */
    @Test
    public void verifyFixedDeposit() throws IOException {
        WebDriver driver=new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");
        // handle popup
        WebElement closePopUpButton = driver.findElement(By.xpath("//button[@class='No thanks']"));
        if (closePopUpButton.isDisplayed())
        {
            closePopUpButton.click();
        }

        String filePath=System.getProperty("user.dir")+"\\test-data\\InterestCalculator.xlsx";
        //count no of rows in sheetD:\Shivam's Learning\JAVA+Selenium\JavaSeleniumPractice\test-data\InterestCalculator.xlsx
        int noOfRows = ExcelUtils.getRowCount(filePath, "Sheet1");

        //read data from excel sheet
        for (int r=1;r<=noOfRows;r++) //start with r=1 coz first row is header
        {
            //read data from excel sheet
            String principalAmount=ExcelUtils.getCellData(filePath, "Sheet1", r, 0);
            String rateOfInterest=ExcelUtils.getCellData(filePath, "Sheet1", r, 1);
            String period1=ExcelUtils.getCellData(filePath, "Sheet1", r,2);
            String period2=ExcelUtils.getCellData(filePath, "Sheet1", r,3);
            String frequency=ExcelUtils.getCellData(filePath, "Sheet1", r,4);
            String expectedMatValue=ExcelUtils.getCellData(filePath, "Sheet1", r, 5);

            //pass above data into application
              driver.findElement(By.xpath("//input[@id='principal']")).sendKeys(principalAmount);
              driver.findElement(By.xpath("//input[@id='interest']")).sendKeys(rateOfInterest);
              driver.findElement(By.xpath("//input[@id='tenure']")).sendKeys(period1);

            WebElement periodDropdown = driver.findElement(By.xpath("//select[@name='tenurePeriod']"));
            Select sel=new Select(periodDropdown);
            sel.selectByVisibleText(period2);

            WebElement frequencyDropdown = driver.findElement(By.xpath("//select[@name='frequency']"));
            Select select=new Select(frequencyDropdown);
            select.selectByVisibleText(frequency);

            driver.findElement(By.xpath("//div[@class='cal_div']//a[contains(@onclick,'return')]")).click();

            //validation
            String actualMatValue=driver.findElement(By.xpath("//span[@id='resp_matval']/strong")).getText();

            double expected=Double.parseDouble(expectedMatValue);
            double actual=Double.parseDouble(actualMatValue);
            //update result
            if (actual==expected)
            {
                System.out.println("Test Passed");
                ExcelUtils.setCellData(filePath, "Sheet1", r, 7, "Passed");
                ExcelUtils.fillGreenColour(filePath, "Sheet1", r, 7);
            }
            else
            {
                System.out.println("Test Failed");
                ExcelUtils.setCellData(filePath, "Sheet1", r, 7, "Failed");
                ExcelUtils.fillRedColour(filePath, "Sheet1", r, 7);
            }
               //clear data before processing with next row
            driver.findElement(By.xpath("//div[@class='cal_div']//*[contains(@class,'PL5')]")).click();
        }




    }





}

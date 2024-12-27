package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    /**
     * Page Classes can be created with two approaches :
     *      1.without using PageFactory
     *      2.using PageFactory
     * Each Page Class contains:
     * locators
     * constructor
     * Action Methods
     */
    WebDriver driver;

    //Approach1:
    //locators
    By username=By.xpath("//input[@name='username']");
    By password=By.xpath("//input[@name='password']");
    By loginButton =By.xpath("//button[@type='submit']");

    //constructor
    public LoginPage(WebDriver driver)
    {
        this.driver=driver;
    }

    //Action methods
    public void setUsername(String email)
    {
        driver.findElement(username).sendKeys(email);
    }
    public void setPassword(String pass)
    {
        driver.findElement(password).sendKeys(pass);
    }
    public void clickLogin()
    {
        driver.findElement(loginButton).click();
    }

}

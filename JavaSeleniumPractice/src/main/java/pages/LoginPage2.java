package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage2 {
    WebDriver driver;
    //Approach2: Using PageFactory

    //locators : driver.findElement is inclusive
    @FindBy(xpath = "//input[@name='username']")
    WebElement username;
    @FindBy(xpath = "//input[@name='password']")
    WebElement password;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton;
    @FindBy(tagName = "a")
    List<WebElement> links;
    @FindBy(xpath = "//span[@class='oxd-userdropdown-tab']//i")
    WebElement profileArrow;
    @FindBy(partialLinkText = "Logout")
    WebElement logout;

    //constructor
    public LoginPage2(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // this driver is applicable for all elements internally to find elements
    }

    //Action methods
    public void setUsername(String email) {
        username.sendKeys(email);
    }

    public void setPassword(String pass) {
        password.sendKeys(pass);
    }

    public void clickLogin() {
        loginButton.click();
    }
    public void logout()
    {
        profileArrow.click();
        logout.click();
    }

}

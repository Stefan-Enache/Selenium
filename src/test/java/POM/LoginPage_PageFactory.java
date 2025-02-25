package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage_PageFactory {

    WebDriver driver;

    // Constructor
    LoginPage_PageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);  // mandatory
    }


    // Locators
    @FindBy(xpath = "//input[@id='user-name']")
    WebElement txt_userName_locator;
    @FindBy(xpath = "//input[@id='password']")
    WebElement txt_password_locator;
    @FindBy(how = How.XPATH, using = "//input[@id='login-button']")
    WebElement loginButton_locator;

    @FindBy(tagName = "a")  // multiple elements
    List<WebElement> links;


    // Action methods
    public void setUserName(String userName) {
        txt_userName_locator.sendKeys(userName);

    }

    public void setPassword(String password) {
        txt_password_locator.sendKeys(password);
    }

    public void clickLogin() {
        loginButton_locator.click();
    }
}

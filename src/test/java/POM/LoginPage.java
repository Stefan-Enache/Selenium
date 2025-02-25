package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    // Constructor
    LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    // Locators      ->     2nd button in SelectorHub gets elements with formats: By.xpath("xpathvalue")
    By txt_userName_locator = By.xpath("//input[@id='user-name']");
    By txt_password_locator = By.xpath("//input[@id='password']");
    By loginButton_locator = By.xpath("//input[@id='login-button']");


    // Action methods
    public void setUserName(String userName) {
        driver.findElement(txt_userName_locator).sendKeys(userName);
    }

    public void setPassword(String password) {
        driver.findElement(txt_password_locator).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton_locator).click();
    }
}

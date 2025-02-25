package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;


// open app
// test logo
// login
// close app


public class _1_FistTestCase {

    WebDriver driver;

    @Test(priority = 1, groups = "sanity")
    void openApp() {
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
    }

    @Test (priority = 2, groups = "regression")
    void testLogo() {
        WebDriverWait logoWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement logo = logoWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='company-branding']")));
        if (logo.isDisplayed()) {
            System.out.println("Logo displayed");
        } else {
            System.out.println("Not displayed");
        }
    }

    @Test(priority = 3, groups = {"sanity", "regression", "functional"})
    void login() {
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
    }

    @Test(priority = 4, groups = {"sanity", "regression", "functional"})
    void closeApp() {
        driver.quit();
    }

}

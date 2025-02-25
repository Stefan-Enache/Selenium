package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Steps {

    WebDriver driver;
    @Given("the user is on the nopCommerce login page")
    public void the_user_is_on_the_nop_commerce_login_page() {
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @When("the user enters valid credentials \\(username: {string}, password: {string})")
    public void the_user_enters_valid_credentials_username_password(String username, String password) {
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
    }

    @When("the user clicks on the login page")
    public void the_user_clicks_on_the_login_page() {
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
    }

    @Then("the user should be redirected to the My Account page")
    public void the_user_should_be_redirected_to_the_my_account_page() {
        boolean status = driver.findElement(By.xpath("//h6[normalize-space()='Dashboard']")).isDisplayed();
        Assert.assertTrue(status);
    }

    @And("the user should see a welcome message")
    public void the_user_should_see_a_welcome_message() {
        boolean status = driver.findElement(By.xpath("//img[@alt='client brand banner']")).isDisplayed();
        Assert.assertEquals(status, true);
    }


}

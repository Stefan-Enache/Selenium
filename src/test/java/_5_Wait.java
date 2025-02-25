import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;


public class _5_Wait {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
//        Thread.sleep(3000);

//        // pageLoadTimeout()
//        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));

//        // implicitWait() -> used once after creating the driver instance
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


//        driver.get("https://opensource-demo.orangehrmlive.com/");
//        driver.manage().window().maximize();
//        // Explicit Wait Declaration-> condition + time
//        WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement element = myWait.until(d -> d.findElement(By.xpath("//input[@placeholder='Username']")));
//        element.sendKeys("fsdvfs");
//        myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Password']"))).sendKeys("1234");
//        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='OrangeHRM, Inc']"))).click();



        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().window().maximize();
        // Fluent Wait Declaration - found on Selenium site
        Wait<WebDriver> myFluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30L))
                .pollingEvery(Duration.ofSeconds(5L))
                .ignoring(NoSuchElementException.class);       // import org.openqa.selenium.NoSuchElementException;

        WebElement inputElement = myFluentWait.until(d -> driver.findElement(By.xpath("//input[@placeholder='Username']")));
        myFluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Password']"))).sendKeys("1234");
//        WebElement inputElement = myFluentWait.until(new Function<WebDriver, WebElement>() {          //import com.google.common.base.Function;
//            public WebElement apply(WebDriver driver) {
//                return driver.findElement(By.xpath("//input[@placeholder='username']"));
//            }
//        });
        inputElement.sendKeys("352bdsbds");

//        driver.quit();
    }
}

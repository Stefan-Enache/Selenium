package testNG;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.time.Duration;


public class _10_ParamTest {


    WebDriver driver;

    @BeforeClass
    @Parameters({"browser", "url"})
    void setup(String brows, String url) {
        switch (brows.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                System.out.println("Invalid browser");
                return;
        }

        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test(priority = 1)
    void testLogo() {
        Assert.assertTrue(driver.findElement(By.xpath("//img[@title='ParaBank']")).isDisplayed());
    }

    @Test(priority = 2)
    void testURL() {
        Assert.assertEquals("https://parabank.parasoft.com/parabank/index.htm", driver.getCurrentUrl());
    }

    @Test(priority = 3, dependsOnMethods = "testURL")
    void testTitle() {
        Assert.assertEquals("ParaBank | Welcome | Online Banking", driver.getTitle());
    }

    @AfterClass
    void tearDown() {
        driver.quit();
    }
}

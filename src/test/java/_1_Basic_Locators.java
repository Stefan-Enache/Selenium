import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;
import java.util.Set;

public class _1_Basic_Locators {
    public static void main(String[] args) throws InterruptedException {

        ChromiumDriver driver = new EdgeDriver(); // WebDriver -> RemoteWebDriver -> ChromiumDriver -> ChromeDriver
        driver.get("https://www.orangehrm.com/"); // Preferably without www.
        driver.manage().window().maximize();

        System.out.println(driver.getTitle());

        // id
        WebElement popupOK = driver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll"));
        if (popupOK.isDisplayed()) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed: Popup missing");
        }
        popupOK.click();

        // name
        WebElement searchBoxName = driver.findElement(By.name("EmailHomePage"));
        searchBoxName.sendKeys("123");
        driver.findElement(By.name("EmailHomePage")).sendKeys("dfsfs");

        // className
        List<WebElement> headerList = driver.findElements(By.className("nav-link-hed"));
        System.out.println(headerList.size());

        // tagName
        List<WebElement> totalLinksNumber = driver.findElements(By.tagName("a"));
        System.out.println(totalLinksNumber.size());

        // linkText & partialLinkText
        driver.findElement(By.linkText("Pricing")).click(); //ElementClickInterceptedException
        driver.findElement(By.partialLinkText("Why ")).click(); //ElementClickInterceptedException

        driver.close();
    }
}

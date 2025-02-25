import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class _17_BrokenLinks_SVG_DOM {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.get("http://www.deadlinkcity.com/");
//        driver.manage().window().maximize();
//
//        int brokenLinks = 0;
//        List<WebElement> links = driver.findElements(By.tagName("a"));
//        for (WebElement link : links) {
//            String hrefAttributeValue = link.getAttribute("href");
//            if (hrefAttributeValue == null || hrefAttributeValue.isEmpty()) {
//                System.out.println("Impossible verification: Null or Empty href");
//                continue;
//            }
//
//            // hit URL to server
//            try {
//                URL linkURL = new URL(hrefAttributeValue);                                      // converted href to URL
//                HttpURLConnection connection = (HttpURLConnection) linkURL.openConnection();    // open connection to the server
//                connection.connect();
//                if (connection.getResponseCode() >= 400) {
//                    System.out.println(hrefAttributeValue + "====> Broken link");
//                    brokenLinks++;
//                } else {
//                    System.out.println(hrefAttributeValue + "====> Working link");
//                }
//            } catch (Exception e) {
//                System.out.println("UnknownHostException");
//            }
//        }
//
//        System.out.println("Number of broken links: " + brokenLinks);



//        // ShadowDOM elements are only visible with CSS selectors
//        driver.get("https://dev.automationtesting.in/shadow-dom");
//        driver.manage().window().maximize();
//        driver.findElement(By.xpath("//*[@class='fc-button fc-cta-consent fc-primary-button']")).click();
//
//        SearchContext shadow = driver.findElement(By.cssSelector("#shadow-root")).getShadowRoot();            // shadow header
//        System.out.println(shadow.findElement(By.cssSelector("#shadow-element")).getText());
//
//        SearchContext innerShadow = shadow.findElement(By.cssSelector("#inner-shadow-dom")).getShadowRoot();
//        System.out.println(innerShadow.findElement(By.cssSelector("#nested-shadow-element")).getText());
//
//        SearchContext nestedShadow3 = innerShadow.findElement(By.cssSelector("#nested-shadow-dom")).getShadowRoot();
//        System.out.println(nestedShadow3.findElement(By.cssSelector("#multi-nested-shadow-element")).getText());
//
//        // jump 4 nested shadowDOMs       -> copy from SelectorHub
//        driver.get("https://books-pwakit.appspot.com/");
//        driver.manage().window().maximize();
//        SearchContext s1 = driver.findElement(By.cssSelector("book-app[apptitle='BOOKS']")).getShadowRoot();
//        s1.findElement(By.cssSelector("#input")).sendKeys("dsadas");



        // SVG  -> name()
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

        driver.findElement(By.xpath("(//*[name()='svg'][@role='presentation'])[12]")).click();

    }
}

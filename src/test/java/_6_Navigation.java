import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class _6_Navigation {
    public static void main(String[] args) throws MalformedURLException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // navigate().to() -> like get() but accepts String or URL
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
//        URL myURL = new URL("https://www.nopcommerce.com/en");
//        driver.navigate().to(myURL);

//        // back()
//        driver.navigate().back();
//        System.out.println(driver.getCurrentUrl());
//
//        // forward()
//        driver.navigate().forward();
//        System.out.println(driver.getCurrentUrl());
//
//        // refresh()
//        driver.navigate().refresh();

        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();
        Set<String> windowIds = driver.getWindowHandles(); // set does not have get() or index
        List<String> idList = new ArrayList<>(windowIds);
        System.out.println(driver.getTitle());

        // Switch
        driver.switchTo().window(idList.get(1));
        System.out.println(driver.getTitle());

        for (String s: windowIds) {
            String title = driver.switchTo().window(s).getTitle();
            if (title.equals("OrangeHRM") || title.equals("Human Resources Management Software | OrangeHRM")) {   //switches tab and gets title
                System.out.println(driver.getCurrentUrl());
                driver.close();
            }
        }

        driver.quit();
    }
}

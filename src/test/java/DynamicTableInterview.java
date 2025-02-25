import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class DynamicTableInterview {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        driver.get("https://tablepress.org/demo/");
        driver.manage().window().maximize();

        List<WebElement> headers = driver.findElements(By.xpath("//div[contains(@class,'dt-scroll-head')]//tr[1]//th"));

        int columnIndex = 0;
        for (int i = 0; i < headers.size(); i++) {
            if (headers.get(i).getText().equals("Country")) {   // change this to get a different column
                columnIndex = i + 1;    // Java counts from 0 locator counts from td[1]
                System.out.println("Header/column index = " + columnIndex);
            }
        }

        int rowNr = driver.findElements(By.xpath(
                "//div[contains(@class,'dt-layout-row dt-layout-table')]//div[contains(@class,'dt-layout-full')]//tbody//tr")).size();

        List<WebElement> countries = new ArrayList<>();
        for (int i = 1; i <= rowNr; i++) {
            countries.add(driver.findElement(By.xpath("//div[contains(@class,'dt-layout-row dt-layout-table')]//div[contains(@class,'dt-layout-full')]" +
                    "//tbody//tr[" + i + "]//td[" + columnIndex + "]")));
        }

        for (WebElement email : countries) {
            System.out.println(email.getText());
        }

//        driver.quit();
    }
}

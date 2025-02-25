import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class _7_Checkboxes_Radio {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        WebElement sunday = driver.findElement(By.xpath("//input[@id='sunday']"));
        sunday.click();
        System.out.println("Sunday checked :" + sunday.isSelected());
        sunday.click();
        System.out.println("Sunday checked :" + sunday.isSelected());

        List<WebElement> checkboxList = new ArrayList<>(driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']")));
        for (WebElement s : checkboxList) {
            System.out.println(s.getAccessibleName());
            s.click();
        }

        Thread.sleep(1000);
        for (int i = checkboxList.size() - 3; i < checkboxList.size(); i++) { // last 3
            checkboxList.get(i).click();
        }

        driver.findElement(By.xpath("//*[text()='Monday']/preceding::input[1]")).click();

        Thread.sleep(1000);
        for (int i = 0; i < checkboxList.size(); i++) {
            if(i == 0 || checkboxList.get(i).getAccessibleName().equals("Friday")) {
                checkboxList.get(i).click();
            }
        }


        // Radio
        driver.findElement(By.xpath("//input[@id='male']")).click();

//        driver.quit();
    }
}

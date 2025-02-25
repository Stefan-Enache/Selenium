import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class _8_Alerts {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();
//
//        WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
//        Alert explicitAlert = myWait.until(ExpectedConditions.alertIsPresent());
//        explicitAlert.accept();

//        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
//        Alert myAlert = driver.switchTo().alert();
//        System.out.println(myAlert.getText());
//        myAlert.accept();

//        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
//        System.out.println(driver.switchTo().alert().getText());
//        driver.switchTo().alert().dismiss();

        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        Alert inputAlert = driver.switchTo().alert();
        inputAlert.sendKeys("dsgsdg"); // invisible in alert window
        inputAlert.accept();


        // Authenticate
        // https://username:password@site
//        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
//        driver.manage().window().maximize();

//        driver.quit();
    }
}

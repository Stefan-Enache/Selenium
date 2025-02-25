import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

public class _4_Methods {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().window().maximize();

        Thread.sleep(3000);
        driver.findElement(By.linkText("OrangeHRM, Inc")).click();

        //getWindowHandle() getWindowHandles()
        String handle = driver.getWindowHandle();
        System.out.println(handle);
        Set<String> handles = driver.getWindowHandles();
        System.out.println(handles);


        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F"); //replaces 1st tab
        // driver.close(); // closes 1st tab even though 2nd tab is focused


        //isEnabled(), isSelected() -> used for input boxes, dropDowns, radio, checkbox
        System.out.println(driver.findElement(By.xpath("//input[@id='FirstName']")).isEnabled());
        System.out.println(driver.findElement(By.xpath("//input[@id='gender-male']")).isSelected());

        // NoSuchElementException -> usually synchronization
        // ElementNotFoundException -> incorrect locator

        driver.quit(); //closes all tabs
    }
}

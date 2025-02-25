import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;

public class _2_CssLocators {
    public static void main(String[] args) {
        ChromiumDriver driver = new ChromeDriver();
        driver.get("https://www.nopcommerce.com/en");
        driver.manage().window().maximize();

        // tag and id   ->   tag#id
        System.out.println("tag and id: " + driver.findElement(By.cssSelector("div#bar-notification")).isDisplayed());
        //System.out.println(driver.findElement(By.cssSelector("#bar-notification")).isDisplayed()); // works without tag but needs #

        // tag and class   ->   tag.class
//        System.out.println("tag and class: " + driver.findElement(By.cssSelector("div.developer-image sprite-image")).isDisplayed()); // does not work with spaces
        System.out.println("tag and class: " + driver.findElement(By.cssSelector("div.developer-image")).isDisplayed()); // remove space and everything after it
//        System.out.println("tag and class: " + driver.findElement(By.cssSelector(".developer-image")).isDisplayed()); // works without tag but needs .


        // tag and attribute   ->   tag[attribute="value"]
        System.out.println("tag and attribute:" + driver.findElement(By.cssSelector("svg[viewBox='0 0 38 38']")).isDisplayed());
//        System.out.println("tag and attribute:" + driver.findElement(By.cssSelector("svg[viewBox='0 0 38 38']")).isDisplayed()); // singe quotes ' '
//        System.out.println("tag and attribute:" + driver.findElement(By.cssSelector("[viewBox=\"0 0 38 38\"]")).isDisplayed()); // works without tag but needs []

        // tag class & attribute   ->   tag.class[attribute="value"]
        System.out.println("tag class & attribute: " + driver.findElement(By.cssSelector("button.owl-next[type='button']")).isDisplayed());
//        System.out.println("tag class & attribute: " + driver.findElement(By.cssSelector(".owl-next[type=\"button\"]")).isDisplayed()); // no tag


//        Selector Hub browser extension

        driver.close();
    }
}

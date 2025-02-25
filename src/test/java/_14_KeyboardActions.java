import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class _14_KeyboardActions {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions().setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
        WebDriver driver = new ChromeDriver(options);
        Actions act = new Actions(driver);

        driver.get("https://text-compare.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.xpath("//*[text()='Continue with Recommended Cookies']")).click();
        driver.findElement(By.xpath("//textarea[@id='inputText1']")).sendKeys("welcome");
        act.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
        act.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
        act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
        act.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
        act.keyDown(Keys.CONTROL).keyDown(Keys.SHIFT).sendKeys("a").keyUp(Keys.SHIFT).keyUp(Keys.CONTROL).perform();

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://demo.nopcommerce.com/");
        WebElement register = driver.findElement(By.xpath("//*[text()='Register']"));
        act.keyDown(Keys.CONTROL).click(register).keyUp(Keys.CONTROL).perform();
        Set<String> windows = driver.getWindowHandles();
        List<String> wins = new ArrayList<>(windows);

        driver.switchTo().window(wins.get(1));


    }
}

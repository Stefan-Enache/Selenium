import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _9_Frames {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://ui.vision/demo/webtest/frames/");
        driver.manage().window().maximize();
        Thread.sleep(2000);

        // driver.switchTo().frame(name), .frame(id), .frame(webElement) .frame(index)

        WebElement frame1 = driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
        driver.switchTo().frame(frame1);
        driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("11111");

        // cannot go from frame to frame, must return to the main page first
        driver.switchTo().defaultContent(); // Go back to main page

        driver.switchTo().frame(driver.findElement(By.xpath("//frame[@src='frame_2.html']")));
        driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("2222");

        driver.switchTo().defaultContent();

        driver.switchTo().frame(2); // frame 3
        driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("3333");

        // inner frame (nested frame) -> inspect shows link to another page from witch I can get elements
        driver.switchTo().frame(driver.findElement(By.xpath(
                "//iframe[@src=\"https://docs.google.com/forms/d/1yfUq-GO9BEssafd6TvHhf0D6QLDVG3q5InwNE2FFFFQ/viewform?embedded=true\"]")));
        driver.findElement(By.xpath("//div[@id='i6']//div[@class='AB7Lab Id5V1']")).click();

        driver.switchTo().defaultContent(); // goes directly to main page, skipping frame 3 (nested frame's parent)

    }
}

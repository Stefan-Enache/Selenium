import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _15_JavaScriptExecutor_Scrolling_FileUpload {
    public static void main(String[] args) {
        // ElementInterceptedException indicate JavaScriptExecutioner is necessary
        WebDriver driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();
        WebElement inputBox = driver.findElement(By.xpath("//input[@id='name']"));

        // executeScript() instead of or sendKeys()
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].setAttribute('value','John')", inputBox);

        // executeScript() instead of or click()
        WebElement button = driver.findElement(By.xpath("//input[@id='male']"));
        jse.executeScript("arguments[0].click()", button);

        // scroll
        WebElement slider = driver.findElement(By.xpath("//h2[normalize-space()='Slider']"));
        jse.executeScript("arguments[0].scrollIntoView()", slider);
        jse.executeScript("window.scrollBy(0,2000)","");
        System.out.println(jse.executeScript("return pageYOffset", ""));
        jse.executeScript("window.scrollBy(0,document.body.scrollHeight)",""); //bottom
        jse.executeScript("window.scrollBy(0,-document.body.scrollHeight)",""); // - top
        driver.manage().window().minimize();
        driver.manage().window().maximize();

        // zoom
        jse.executeScript("document.body.style.zoom='200%'");


//        // file upload
//        driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");
//        driver.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys("c:\\menu.log" + "\n" + "c:\\error.log");

    }
}

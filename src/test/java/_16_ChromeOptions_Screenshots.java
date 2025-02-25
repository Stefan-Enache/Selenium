import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class _16_ChromeOptions_Screenshots {
    public static void main(String[] args) {

        ChromeOptions chromeOptions = new ChromeOptions(); // before WebDriver
        // headless testing (no UI) -> elements will not be visible, allows multitasking, faster
//        chromeOptions.addArguments("--headless=new");

        // incognito
//        chromeOptions.addArguments("--incognito");

        // SSL
        chromeOptions.setAcceptInsecureCerts(true);

        // no autotest ribbon (Chrome is being run by autotest software)
        chromeOptions.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});

        // extensions     -> CRX Extractor plugin needed
        File crx = new File("E:\\WORK\\IntelliJ Projects\\Selenium\\SelectorsHubCRX.crx");
        chromeOptions.addExtensions(crx);
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();

        // full page screenshot
        TakesScreenshot ts = (TakesScreenshot) driver;
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);
        File targetFile = new File("E:\\WORK\\IntelliJ Projects\\Selenium\\screenshots\\fullPage.png");
        sourceFile.renameTo(targetFile); // copy source to target
//
//        // section screenshot
//        File sourceFile2 = driver.findElement(By.xpath("//div[contains(@class,'product-grid')]")).getScreenshotAs(OutputType.FILE);
//        File targetFile2 = new File(System.getProperty("user.dir") + "\\screenshots\\section.jpg"); // dynamic path
//        sourceFile2.renameTo(targetFile2);
//
//        // element screenshot
//        File sourceFile3 = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']")).getScreenshotAs(OutputType.FILE);
//        File targetFile3 = new File(System.getProperty("user.dir") + "\\screenshots\\element.jpg");
//        sourceFile3.renameTo(targetFile3);

    }
}

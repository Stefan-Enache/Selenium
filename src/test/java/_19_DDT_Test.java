import org.apache.poi.ss.usermodel.IndexedColors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.time.Duration;

public class _19_DDT_Test {
    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.calculator.net/interest-calculator.html?cstartingprinciple=10%2C000&cannualaddition=&cmonthlyaddition=&cadditionat1=beginning&cinterestrate=5&ccompound=annually&cyears=5&cmonths=&ctaxtrate=&cinflationrate=&printit=0&x=Calculate#interestresults");
        driver.manage().window().maximize();

        String filePath = System.getProperty("user.dir") + "//testData/interestData.xlsx.";
        int rows = _19_DDT_ExcelUtils.getRowCount(filePath, "Sheet1");

        for (int i = 1; i <= rows; i ++) {
            driver.findElement(By.xpath("//input[@value='Clear']")).click();
            // read excel
            String investment = _19_DDT_ExcelUtils.getCellData(filePath, "Sheet1", i, 0);
            String year = _19_DDT_ExcelUtils.getCellData(filePath, "Sheet1", i, 1);
            String rate = _19_DDT_ExcelUtils.getCellData(filePath, "Sheet1", i, 2);
            String expectedValue = _19_DDT_ExcelUtils.getCellData(filePath, "Sheet1", i, 3);

            // pass data to webpage
            driver.findElement(By.xpath("//input[@id='cstartingprinciple']")).sendKeys(investment);
            driver.findElement(By.xpath("//input[@id='cyears']")).sendKeys(year);
            driver.findElement(By.xpath("//input[@id='cinterestrate']")).sendKeys(rate);
            driver.findElement(By.xpath("//input[@name='x']")).click();

            // validation
            String actualValue = driver.findElement(By.xpath("//body[1]/div[3]/div[1]/div[4]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/b")).getText();
            System.out.println(actualValue);
            if(actualValue.equals(expectedValue)) {
                System.out.println("Test Passed");
                _19_DDT_ExcelUtils.setCellData(filePath, "Sheet1", i, 5, "Pass");
                _19_DDT_ExcelUtils.fillColor(filePath, "Sheet1", i, 5, IndexedColors.GREEN.getIndex());
            } else {
                    System.out.println("Test Failed");
                    _19_DDT_ExcelUtils.setCellData(filePath, "Sheet1", i, 5, "Fail");
                    _19_DDT_ExcelUtils.fillColor(filePath, "Sheet1", i, 5, IndexedColors.RED.getIndex());
            }
        }

        driver.quit();
    }
}

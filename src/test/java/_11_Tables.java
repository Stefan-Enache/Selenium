import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _11_Tables {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//        // Static Table
//        driver.get("https://testautomationpractice.blogspot.com/");
//        driver.manage().window().maximize();
//
//        List<WebElement> rows = driver.findElements(By.xpath("//table[@name=\"BookTable\"]//tr"));
//        List<WebElement> columns = driver.findElements(By.xpath("//table[@name=\"BookTable\"]//tr[2]//td"));
//        System.out.println(rows.size());
//        System.out.println(driver.findElement(By.xpath("//table[@name=\"BookTable\"]//tr[5]//td[1]")).getText());
//
//        List<WebElement> table = driver.findElements(By.xpath("//table[@name=\"BookTable\"]"));
//        for (WebElement e: table){
//            System.out.println(e.getText());
//        }
//
//        System.out.println("----------------------------------");      //author = Mukesh   +   Price
//        int sum = 0;
//        for (int r = 2; r<=rows.size(); r++){ // r 1 = headers
//            for (int c = 1; c<=columns.size(); c++){
//                if(driver.findElement(By.xpath("//table[@name=\"BookTable\"]//tr[" + r +"]//td[" + c +"]")).getText().equals("Mukesh")) {
//                    System.out.println(driver.findElement(By.xpath("//table[@name=\"BookTable\"]//tr[" + r + "]")).getText());
//                    int price = Integer.parseInt(driver.findElement(By.xpath("//table[@name=\"BookTable\"]//tr[" + r + "]//td[4]")).getText());
//                    sum += price;
//                }
//            }
//        }
//        System.out.println(sum);


        // Dynamic Table
        driver.get("https://demo.opencart.com/admin/index.php?route=common/dashboard&user_token=0ffd2f3b90c3d39c0906b88593ee0bfb");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(10000);
        driver.findElement(By.xpath("//a[@class='parent collapsed'][normalize-space()='Customers']")).click();
        driver.findElement(By.xpath("//ul[@id='collapse-5']//a[contains(text(),'Customers')]")).click();

        String pages = driver.findElement(By.xpath("//div[@class='col-sm-6 text-end']")).getText();
        int pageNumber = Integer.parseInt(pages.substring(pages.indexOf("(") + 1, pages.indexOf("Pages") - 1));

        for (int p = 1; p <= pageNumber; p++) {
            if (p > 1) {
                WebElement activePage = driver.findElement(By.xpath("//ul[@class='pagination']//*[text()=" + p + "]"));
                activePage.click();
                Thread.sleep(3000);
            }
            int nrOfRows = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr")).size();
            for (int i = 1; i <= nrOfRows; i++) {
                String name = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr[" + i + "]/td[2]")).getText();
                String email = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr[" + i + "]/td[3]")).getText();
                System.out.println("Name: " + name + "\t");
                System.out.println("Email: " + email);
                System.out.println("------------------------------------------------------");
            }
        }



//        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers");
//        driver.manage().window().maximize();
//
//        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
//        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
//        driver.findElement(By.xpath("//button[@type='submit']")).click();
//
//        int rows = driver.findElements(By.xpath("//div[@class='oxd-table-card']")).size() * 4;
//        List<WebElement> elements = driver.findElements(By.xpath("//div[@data-v-6c07a142]"));
//        for (int i = 0; i < rows; i+=4) {
//            System.out.println(elements.get(i).getText());
//        }

//        driver.quit();
    }
}

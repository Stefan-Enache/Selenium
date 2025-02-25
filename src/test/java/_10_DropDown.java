import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class _10_DropDown {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.get("https://testautomationpractice.blogspot.com/");
//        driver.manage().window().maximize();
//
//        WebElement dropdown = driver.findElement(By.xpath("//select[@id='country']"));
//        Select select = new Select(dropdown);
//
//        select.selectByIndex(3);
//        Thread.sleep(1000);
//
//        select.selectByVisibleText("Japan");
//        Thread.sleep(1000);
//
//        select.selectByValue("uk");
//
//        List<WebElement> dropdownValues = select.getOptions();
//        System.out.println(dropdownValues.size());



//        //Bootstrap
//        driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
//        driver.manage().window().maximize();
//        Thread.sleep(2000);
//        driver.findElement(By.xpath("//*[@class=\" css-47sehv\"]")).click(); // accept popup
//
//        driver.findElement(By.cssSelector("span.multiselect-selected-text")).click();
//        driver.findElement(By.cssSelector("input[value='Java']")).click();
//
//        List<WebElement> options = driver.findElements(By.xpath("//ul//label"));
//        for(WebElement e: options) {
//            System.out.println(e.getText());
//            if(e.getText().equals("Python"))e.click();
//        }



////        Hidden Dropdown - SelectorHub debug
//        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList");
//        driver.manage().window().maximize();
//
//        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
//        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
//        driver.findElement(By.xpath("//button[@type='submit']")).click();
//
//        driver.findElement(By.xpath("(//div[@class='oxd-select-text oxd-select-text--active'])[3]")).click();
//        List<WebElement> options = driver.findElements(By.xpath("//div[@role='listbox']//span"));
//        System.out.println(options.size());
//
//        for(WebElement op: options){
//            System.out.println(op.getText());
//        }
//
//        driver.findElement(By.xpath("//span[contains(text(),'QA Engineer')]")).click();



//        // auto suggest box
//        driver.get("https://www.google.co.uk/");
//        driver.findElement(By.xpath("//div[text()='Acceptă tot']")).click();
//        driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("selenium");
//
//
//        List<WebElement> list = driver.findElements(By.xpath("//ul[@role=\"listbox\"]//li//span"));
//
//        for (WebElement e: list){
//            System.out.println(e.getText());
//            if (e.getText().equals("selenium")){
//                e.click();
//            }
//        }



        driver.get("https://blazedemo.com/");
        driver.manage().window().maximize();

        Select s1 = new Select(driver.findElement(By.xpath("//select[@name='fromPort']")));
        s1.getOptions().get(1).click();
        for (WebElement s : s1.getOptions()) {
            if (s.getText().equals("Boston")) {
                s.click();
            }
        }

        Select s2 = new Select(driver.findElement(By.xpath("//select[@name='toPort']")));
        s2.getOptions().get(1).click();
        for (WebElement s : s2.getOptions()) {
            if (s.getText().equals("Rome")) {
                s.click();
            }
        }

        driver.findElement(By.xpath("//input[@value='Find Flights']")).click();
        Thread.sleep(2000);

        List<WebElement> prices = driver.findElements(By.xpath("//table[@class='table']//td[6]"));
        List<Double> numericPrices = new ArrayList<>();

        for (WebElement price : prices) {
            double p = Double.parseDouble(price.getText().replace("$", ""));
            numericPrices.add(p);
        }

        double lowestPrice = numericPrices.stream().min(Double::compare).get();
        System.out.println(lowestPrice);

        for (int r = 1; r <= prices.size(); r++) {
            String price$ = driver.findElement(By.xpath("//table[@class='table']//tbody//tr[" + r + "]/td[6]")).getText();
            double price = Double.parseDouble(price$.replace("$", ""));
            if (price == lowestPrice) {
                driver.findElement(By.xpath("//table[@class='table']//tbody//tr[" + r + "]/td[1]//input[@class='btn btn-small']")).click();
                break;
            }
        }

//        driver.quit();
    }
}

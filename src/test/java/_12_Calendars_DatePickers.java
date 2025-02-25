import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.time.Month;
import java.util.HashMap;
import java.util.List;

public class _12_Calendars_DatePickers {

    static void selectFutureDate(WebDriver driver, String month, String year, String day) {
        while (true) {
            String currentYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
            String currentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
            if (currentMonth.equals(month) && currentYear.equals(year)) {
                break;
            }
            driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click(); // next month button
        }

        List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));
        for (WebElement date : allDates) {
            if (date.getText().equals(day)) {
                date.click();
                break;
            }
        }
    }

    static void selectPastDate(WebDriver driver, String month, String year, String day) {
        while (true) {
            String currentYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
            String currentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
            if (currentMonth.equals(month) && currentYear.equals(year)) {
                break;
            }
            driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click(); // previous month button
        }

        List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));

        for (WebElement date : allDates) {
            if (date.getText().equals(day)) {
                date.click();
                break;
            }
        }
    }

    public static Month convertMonth(String month) {
        HashMap<String, Month> monthMap = new HashMap<>();
        monthMap.put("Jan", Month.JANUARY);
        monthMap.put("Feb", Month.FEBRUARY);
        monthMap.put("Mar", Month.MARCH);
        monthMap.put("Apr", Month.APRIL);
        monthMap.put("May", Month.MAY);
        monthMap.put("Jun", Month.JUNE);
        monthMap.put("Jul", Month.JULY);
        monthMap.put("Aug", Month.AUGUST);
        monthMap.put("Sep", Month.SEPTEMBER);
        monthMap.put("Oct", Month.OCTOBER);
        monthMap.put("Nov", Month.NOVEMBER);
        monthMap.put("Dec", Month.DECEMBER);
        return monthMap.get(month);
    }

    public static void selectConvertedDate(WebDriver driver, String year, String month, String date) {
        Select yearDropdown = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-year']")));
        yearDropdown.selectByVisibleText(year);
        Month convertedRequiredMonth = convertMonth(month);

        while (true) {
            String displayedMonth = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']/option[@selected='selected']")).getText();
            Month convertedDisplayedMonth = convertMonth(displayedMonth);
            if (convertedRequiredMonth.compareTo(convertedDisplayedMonth) == 0) {
                break;
            } else if (convertedRequiredMonth.compareTo(convertedDisplayedMonth) > 0) {
                driver.findElement(By.xpath("//a[@title='Next']")).click();
            } else {
                driver.findElement(By.xpath("//a[@title='Prev']")).click();
            }
        }

        List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td/a"));
        for (WebElement dt : allDates) {
            if (dt.getText().equals(date)) {
                dt.click();
                break;
            }
        }
    }

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

//        driver.get("https://jqueryui.com/datepicker/");
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().window().maximize();
//
//        driver.switchTo().frame(0);
////        driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("05/27/2024");
//
//        driver.findElement(By.xpath("//input[@id='datepicker']")).click();
////        selectFutureDate(driver, "July", "2025", "19");
//        selectPastDate(driver, "May", "2022", "19");


        // converting to Month object
        driver.get("https://www.globalsqa.com/demo-site/datepicker/#DropDown%20DatePicker");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//p[@class='fc-button-label']")).click();
        driver.findElement(By.xpath("//li[@id='DropDown DatePicker']")).click();
        driver.switchTo().frame(driver.findElement(By.xpath(
                "//div[@class='single_tab_div resp-tab-content resp-tab-content-active']//iframe[@class='demo-frame lazyloaded']")));
        driver.findElement(By.xpath("//input[@id='datepicker']")).click();

        selectConvertedDate(driver, "2026", "Feb", "27");


//        driver.quit();
    }
}

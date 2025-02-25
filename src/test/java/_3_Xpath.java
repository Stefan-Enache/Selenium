import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class _3_Xpath {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.nopcommerce.com/en");
        driver.manage().window().maximize();


        // absolute xPath
        System.out.println("absolute xPath: " + driver.findElement(By.xpath(
                "/html[1]/body[1]/div[7]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]")).isDisplayed());

        // 1 attribute
        System.out.println("1 attribute: " + driver.findElement(By.xpath("//img[@title='nopCommerce']")).isDisplayed());

        // 2 attribute
        System.out.println("2 attributes: " + driver.findElement(By.xpath(
        "//*[@width='1'][@style='position: absolute; top: 0px; left: 0px; border: none; visibility: hidden;']")).isEnabled());

        // 'and 'or' operators
        System.out.println("and: " + driver.findElement(By.xpath(
        "//*[@width='1' and @style='position: absolute; top: 0px; left: 0px; border: none; visibility: hidden;']")).isEnabled());
        System.out.println("or: " + driver.findElement(By.xpath(
        "//*[@width='1' or @style='xxx']")).isEnabled());
        System.out.println("or with 2 separate attributes: " + driver.findElement(By.xpath(
                "//*[@width='1']|*[@style='position: absolute; top: 0px; left: 0px; border: none; visibility: hidden;']")).isEnabled());

        // Inner Text + text()
        System.out.println("inner text: " + driver.findElement(By.xpath("//h2[text()='For every size and type of business']")).getText());

        // contains(@attribute, 'value')
        System.out.println("contains: " + driver.findElement(By.xpath(
                "//*[contains(@style, 'absolu')]")).isEnabled());

        System.out.println("contains text: " + driver.findElement(By.xpath(
                "//*[contains(text(), 'absolu')]")).isEnabled());

        System.out.println("contains text . : " + driver.findElement(By.xpath( // . can be used instead of text()
                "//*[contains(., 'absolu')]")).isEnabled());

        System.out.println("starts-with: " + driver.findElement(By.xpath(
                "//*[starts-with(@style, 'posit')]")).isEnabled());

        // chained - used when child has no attributes
        System.out.println("chained: " + driver.findElement(By.xpath(
                "//*[@class='navigation-main-logo']/a/img")).isEnabled()); // error without @


        //normalize-space -> returns the text of the element, and of all the elements it contains
        System.out.println("normalize-space: " + driver.findElement(By.xpath("//*[normalize-space()='Free and open-source eCommerce platform']")).isDisplayed());

        System.out.println("---------------------------------------------------------");


        // axes
        //abc[xyz='123']/parent::tag[0]
        //*[xyz='123']/parent::*
        //*[xyz='123']/..


        //abc[xyz='123']/child[2]::tag[3]
        //*[xyz='123']/child::*    -> all children
        //*[xyz='123']/tag


        // //abc[xyz='123']/ancestor::tag
        // //*[xyz='123']/ancestor::*   -> all ancestors


        //*[xyz='123']/descendant[2]/tag[3]
        //*[xyz='123']//tag[2]
        //*[xyz='123']/descendant[2]/*   -> // all grandchildren
        //*[xyz='123']//*   -> // all grandchildren


        // //abc[xyz='123']/following-sibling::tag
        // //*[xyz='123']/following::* -> more elements


        //abc[xyz='123']/preceding-sibling::tag
        //*[xyz='123']/preceding::* -> more elements


        driver.quit();
    }
}

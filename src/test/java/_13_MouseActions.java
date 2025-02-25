import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class _13_MouseActions {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

//        driver.get("https://demo.opencart.com/");
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        Thread.sleep(2000);
//
//        WebElement desktops = driver.findElement(By.xpath("//ul//a[@class='nav-link dropdown-toggle'][normalize-space()='Desktops']"));
//        WebElement mac = driver.findElement(By.xpath("//a[@class='nav-link'][normalize-space()='Mac (1)']"));
//
//        // Hover -> moveToElement()          // build() is optional          //.perform() is mandatory and contains build()
//        Actions act = new Actions(driver);
//        act.moveToElement(desktops).moveToElement(mac).click().build().perform();



//        // Right Click -> contextClick()
//        driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        WebElement rightClickButton = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
//        Actions act = new Actions(driver);
//        // storing into Action variable for later use
//        // Actions = class      Action = interface
//        Action myAction = act.contextClick(rightClickButton).build();
//        myAction.perform();
//        driver.findElement(By.xpath("//span[normalize-space()='Copy']")).click();
//        driver.switchTo().alert().accept();


        // Multiple elements in SelectorHub -> 3rd button


//        // Double Click
//        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick3");
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.findElement(By.xpath("//*[@id=\"accept-choices\"]")).click();
//        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name=\"iframeResult\"]")));
//        WebElement field1 = driver.findElement(By.xpath("//input[@id='field1']"));
//
//        field1.clear();
//        field1.sendKeys("bla bla");
//        WebElement dClick = driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));
//        Actions act = new Actions(driver);
//        act.doubleClick(dClick).perform();
//
//        // No inner text present -> use field2.getAttribute("value") to get the text from the value attribute
//        WebElement field2 = driver.findElement(By.xpath("//input[@id='field2']"));
//        String field2Text = field2.getAttribute("value");
//        System.out.println(field2Text);



        //Drag and Drop
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement capitol = driver.findElement(By.xpath("//div[text()='Rome'][@id=\"box6\"]"));
        WebElement country = driver.findElement(By.xpath("//div[@id='box106']"));
        Actions act = new Actions(driver);
        act.dragAndDrop(capitol, country).perform();

        driver.switchTo().newWindow(WindowType.TAB); // Open new Tab

        // slider
        driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//p[text()='Consent']")).click();

        WebElement min_slider = driver.findElement(By.xpath("//span[@class='ui-slider-handle ui-corner-all ui-state-default'][1]"));
        System.out.println(min_slider.getLocation());
        act.dragAndDropBy(min_slider,100,0).perform();
        System.out.println(min_slider.getLocation().getX()); // + - 5 depending on page layout

    }
}

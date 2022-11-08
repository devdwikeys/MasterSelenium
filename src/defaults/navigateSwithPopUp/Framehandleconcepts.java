package defaults.navigateSwithPopUp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Framehandleconcepts {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "E:\\MasterSelenium\\PathWebDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://jqueryui.com/droppable/");
        Actions actions = new Actions(driver);

        //switch to frame contains in website
        WebElement frame = driver.findElement(By.xpath("//iframe"));
        driver.switchTo().frame(frame);
        WebElement dragDrop = driver.findElement(By.xpath("//*[@id='draggable']"));
        actions.dragAndDrop(dragDrop, driver.findElement(By.xpath("//*[@id='droppable']"))).build().perform();
        //switch back to defaults web (out of frame)
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//*[text()='Sortable']")).click();
    }
}

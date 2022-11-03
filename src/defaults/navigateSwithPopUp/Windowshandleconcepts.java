package defaults.navigateSwithPopUp;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Windowshandleconcepts {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "E:\\MasterSelenium\\PathWebDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://www.tokopedia.com/");

        Actions actions = new Actions(driver);
        WebElement rightClick = driver.findElement(By.xpath("//*[text()='tv android']"));
        actions.moveToElement(rightClick).contextClick().keyUp(Keys.ARROW_DOWN).click().build().perform();
    }
}

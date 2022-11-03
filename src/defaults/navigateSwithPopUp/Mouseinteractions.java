package defaults.navigateSwithPopUp;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Mouseinteractions {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "E:\\MasterSelenium\\PathWebDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://www.tokopedia.com/");
        //To handle mouse&keyboard we should calling class Action in selenium
        Actions actions = new Actions(driver);

        //should use method build() and perform() when using class Actions.
        //with composite method, we can also declare as an variables first for WebElement
        WebElement inputShift = driver.findElement(By.xpath("//input[@data-unify='Search']"));
        //Perfoming keyboard action to hold shift and also do double click on target
        actions.moveToElement(inputShift).click().keyDown(Keys.SHIFT).sendKeys("samsung").doubleClick().build().perform();
        //Perfoming mouse move to spesific element
        Thread.sleep(3000);
        actions.moveToElement(driver.findElement(By.xpath("//div[@data-testid='headerText']"))).build().perform();
        //perfoming right click to spefici element
        Thread.sleep(7000);
        WebElement rightClick = driver.findElement(By.xpath("//*[text()='Tentang Tokopedia']"));
        actions.moveToElement(rightClick).contextClick().build().perform();
    }
}

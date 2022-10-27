package defaults;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Locators {
    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver", "E:\\MasterSelenium\\PathWebDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        //This context will explain to located Sibling to Sibling / Child to parents we reverse from previously
        //This located following-sibling, yg artinya located jangkar di sibling yang sama namun pointernya kearah sibling lain
        System.out.println(driver.findElement(By.xpath("//Header/div/button[1]/following-sibling::button[1]")).getText());
        //this located travels from child to parent
        System.out.println(driver.findElement(By.xpath("//Header/div/button/parent::div/button[2]")).getText());
    }
}

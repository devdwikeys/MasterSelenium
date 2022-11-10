package Midlevel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Calenderhandling {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "E:\\MasterSelenium\\PathWebDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://www.path2usa.com/travel-companions");

        //driver.findElement(By.xpath("//input[@id='form-field-travel_comp_date']")).click();
        Actions move = new Actions(driver);
        move.moveToElement(driver.findElement(By.xpath("//input[@id='form-field-travel_comp_date']"))).build().perform();

    }
}

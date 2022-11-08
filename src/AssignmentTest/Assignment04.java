package AssignmentTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Assignment04 {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "E:\\MasterSelenium\\PathWebDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/nested_frames");

        WebElement frameTop = driver.findElement(By.xpath("//frame[@name='frame-top']"));
        driver.switchTo().frame(frameTop);
        WebElement frameMidle = driver.findElement(By.xpath("//frame[@name='frame-middle']"));
        driver.switchTo().frame(frameMidle);
        System.out.println(driver.findElement(By.xpath("//div[@id='content']")).getText());
        driver.switchTo().defaultContent();


    }
}

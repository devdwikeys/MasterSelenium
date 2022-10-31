package project.tiketdotcom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class e2eTestHotelBooking {

    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver", "E:\\MasterSelenium\\PathWebDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://tiket.com/");
        driver.findElement(By.xpath("//img [@alt='Booking hotel']")).click();
        JavascriptExecutor command = (JavascriptExecutor) driver;
        command.executeScript("window.scroll(0,400)");

        driver.findElement(By.xpath(" //input[@id='destination-input']")).click();
        List<WebElement> option  = driver.findElements(By.xpath("//div[@class='name']"));
        System.out.println(driver.findElements(By.xpath("//div[@class='name']")).size());
        for ( WebElement selectLocation : option){
            if (selectLocation.getText().equals("Bali")){
                selectLocation.click();
                break;
            }
        }

    }
}

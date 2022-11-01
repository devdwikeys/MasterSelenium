package defaults;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Browseractivities {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "E:\\MasterSelenium\\PathWebDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //we can call method manage() to control the browser
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("http://google.com"); //commonly using at first time open browser, this function waiting till all page completed load
        driver.navigate().to("https://youtube.com"); //diff with method get() this function didnt wait till all page completed load
        driver.navigate().back();
        driver.navigate().forward();
    }
}

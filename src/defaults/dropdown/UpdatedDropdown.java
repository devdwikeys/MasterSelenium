package defaults.dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class UpdatedDropdown {

    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver", "E:\\MasterSelenium\\PathWebDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        driver.findElement(By.xpath("//*[@id='divpaxinfo']")).click();
        Thread.sleep(2000);
        //do some validate to store the value of passengers
        System.out.println("Before do action : " +driver.findElement(By.xpath("//*[@id='divpaxinfo']")).getText());
        //do multiple click using loop
        for (int i = 1; i <=4; i++){
            driver.findElement(By.xpath("//*[@id='hrefIncAdt']")).click();
        }
        //doing with while, same function only diff how to write
        int j = 1;
        while (j <= 4 ){
            driver.findElement(By.xpath("//*[@id='hrefIncAdt']")).click();
            j++;
        }
        driver.findElement(By.xpath("//*[@id='btnclosepaxoption']")).click();
        System.out.println("after do action : " +driver.findElement(By.xpath("//*[@id='divpaxinfo']")).getText());
    }
}

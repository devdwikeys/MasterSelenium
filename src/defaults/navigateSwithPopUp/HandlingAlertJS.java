package defaults.navigateSwithPopUp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class HandlingAlertJS {

    public static void main(String[] args) throws InterruptedException {

        String name = "Qarenina";
        String name1 = "Qareninarestu";
        System.setProperty("webdriver.chrome.driver", "E:\\MasterSelenium\\PathWebDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        //createTestcase to push alert JS
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys(name);
        driver.findElement(By.xpath("//input[@id='alertbtn']")).click();
        Thread.sleep(2000);
        //store the value of text from javascript allert and do accept validation
        String popupText = driver.switchTo().alert().getText();
        System.out.println(popupText);
        Assert.assertEquals(popupText, "Hello " + name +", share this practice page and share your knowledge");
        Thread.sleep(2000);
        //switch to javascript allert and do action confirm the popup
        driver.switchTo().alert().accept();

        //createTestcase to push confirm/optional alert JS
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys(name1);
        driver.findElement(By.xpath("//input[@id='confirmbtn']")).click();
        //store the value of text from javascript allert and do accept validation
        String confirmText = driver.switchTo().alert().getText();
        System.out.println(confirmText);
        Assert.assertEquals(confirmText, "Hello " + name1 +", Are you sure you want to confirm?");
        Thread.sleep(2000);
        //switch to javascript allert and do action confirm the popup
        driver.switchTo().alert().dismiss();

    }
}

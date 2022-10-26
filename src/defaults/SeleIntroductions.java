package defaults;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SeleIntroductions {

    public static void main(String[] args) throws InterruptedException {

        //Setting path chromedriver.exe
        System.setProperty("webdriver.chrome.driver", "E:\\MasterSelenium\\PathWebDriver\\chromedriver.exe");
        //create an object to new chromedriver
        WebDriver driver = new ChromeDriver();

        //implicit wait - 5sec, will call global method that means for all cases will waiting 5 sec untill the object showing
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        /*
        Type Locators can be handle by selenium is :
            By ID
            By Xpath
            By CSS Selector
            By name
            By Class Name
            By Tag Name
            By Link Text
            By Partial Link Text

         */

        //Create direct link using driver
        driver.get("https://rahulshettyacademy.com/locatorspractice");

        //locating an object by ID and perfoming action input into textField username
        driver.findElement(By.id("inputUsername")).sendKeys("dwiki");

        //locating an object by name  and perfoming action input into tetField pswrd
        driver.findElement(By.name("inputPassword")).sendKeys("qarenina");

        //locating an object by class and perfoming action click into button signin
        driver.findElement(By.className("signInBtn")).click();

        //locating an object by CSSselector and performing verifyElement/ get Text
        System.out.println(driver.findElement(By.cssSelector("p.error")).getText());

        //locating an object by LinkText and perfoming click into hyperlink
        driver.findElement(By.linkText("Forgot your password?")).click();

        Thread.sleep(3000);

        //locating an object by Xpath and perfoming input into textField
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Qaren");

        //locating an object By customize css selector and perfoming input into textField
        driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("qaren@gmail.com");

        //locating an object By Xpath within index number to get unique locator and perfoming clear the textField
        driver.findElement(By.xpath("//input[@type='text'][2]")).clear();

        //locating an object by CSSselector within index number to get unique locator
        driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("qarenina@gmail.com");

        //locating an object by Xpath within child locator to get unique
        driver.findElement(By.xpath("//form/input[@placeholder='Phone Number']")).sendKeys("087781184831");
        driver.findElement(By.xpath("//button[@class='reset-pwd-btn']")).click();
        System.out.println(driver.findElement(By.xpath("//p[@class='infoMsg']")).getText());
        driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#inputUsername")).sendKeys("Qarenina");
        //locating an object by CSSselector within dynamic locators
        driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
        driver.findElement(By.id("chkboxOne")).click();
        driver.findElement(By.xpath("//input[@id='chkboxTwo']")).click();
        //locating an object by regular expression Xpath
        driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();

        driver.close();

    }
}

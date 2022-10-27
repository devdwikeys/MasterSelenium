package defaults.dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Dropdown {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "E:\\MasterSelenium\\PathWebDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();

        //create an unique Xpath by parentchild relationship
        //--//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='BLR']--
        driver.findElement(By.xpath("//a[@value='BLR']")).click();
        Thread.sleep(3000);
        //driver.findElement(By.xpath("//a[@value='MAA']")).click();
        // --at terminal will showing error *element not interactable* its mean the element exist--

        //driver.findElement(By.xpath("//a[@value='MAsddaA']")).click();
        // -- at terminal will showing error *element unable* its mean the element didnt exist--

        //how to handle the dynamic dropdown we can input index to unique located an object
        //driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();

        //how to handle to located unique an element without index, when can use parents-sibling, following-sibling, etc
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='MAA']")).click();


    }
}

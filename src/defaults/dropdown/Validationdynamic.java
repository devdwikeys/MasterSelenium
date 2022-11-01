package defaults.dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class Validationdynamic {

    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver", "E:\\MasterSelenium\\PathWebDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        //in sometimes method isEnabled didnt work properly cause on element get dynamic validations

        //we should get validtaions using dynamic attribute from element
        System.out.println(driver.findElement(By.xpath("//div[@id='Div1']")).getAttribute("style"));

        //do some action to get other value from attributes
        driver.findElement(By.xpath("//input[@id='ctl00_mainContent_rbtnl_Trip_1']")).click();

        //see diff from attribute value
        System.out.println(driver.findElement(By.xpath("//div[@id='Div1']")).getAttribute("style"));

        //create validations when attribute got value 1 or the element isEnabled
        if (driver.findElement(By.xpath("//div[@id='Div1']")).getAttribute("style").contains("0.5")){
            System.out.println("The element is enabled");
            Assert.assertTrue(true);
        }
        else {
            System.out.println("The element is disabled");
            Assert.assertFalse(false);
        }
    }
}

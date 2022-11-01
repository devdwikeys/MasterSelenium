package defaults.dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Staticdropdown {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "E:\\MasterSelenium\\PathWebDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        //how to handle dropdown with select tag at inspect element -  -static data-

        //create an object Webelement to store the located
        WebElement staticDropdown = driver.findElement(By.xpath("//select[contains(@id, 'DropDownListCurrency')]"));

        //create an object to using Select method --special method for dropdown(select tag)--
        Select dropdown = new Select(staticDropdown);
        //this select only able to get 1 selected item not multiple
        dropdown.selectByIndex(3); //filtered by index
        System.out.println(dropdown.getFirstSelectedOption().getText());//getFirstSelect only able to select by single not multiple
        dropdown.selectByVisibleText("AED");//filtered by showing text at page
        System.out.println(dropdown.getFirstSelectedOption().getText());//use this method we can use for validating the data
        dropdown.selectByValue("INR");//filtered by attribute at inspect element
        System.out.println(dropdown.getFirstSelectedOption().getText());
        Thread.sleep(5000);
        driver.close();

    }
}

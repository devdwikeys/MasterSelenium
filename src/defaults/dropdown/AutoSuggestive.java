package defaults.dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class AutoSuggestive {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "E:\\MasterSelenium\\PathWebDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        //input suggestion word into textfield
        driver.findElement(By.xpath("//input[@id='autosuggest']")).sendKeys("In");

        /*
        how to store all suggestion keyword with dynamic data
        First we should find all object with dynamic index --//li[@class='ui-menu-item']/a-- results for suggestion
        then store it into arraylist and create new object to store that
         */
        // we use method --findElements-- using s for jamak to store an list --and create an array object
        List<WebElement> options = driver.findElements(By.xpath("//li[@class='ui-menu-item']/a"));

        //to listing all value we should using --enhanced loop--
        for ( WebElement option : options){
            if (option.getText().equals("Indonesia")){ //we by looping 1by1 element till get same value with expected
                option.click();
                break;//we should calling break when our value found then looping must be stop
            }
        }


    }
}

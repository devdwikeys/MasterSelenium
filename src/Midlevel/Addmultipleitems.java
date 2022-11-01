package Midlevel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class Addmultipleitems {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "E:\\MasterSelenium\\PathWebDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //declare an object to input multipleSearching item
        String[] itemNeeded = {"Brocolli","Cucumber","Beetroot", "Beans", "Brinjal"};
        int j = 0;

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");

        //first create an Objectlist to store all item on page
        List<WebElement> product = driver.findElements(By.xpath("//h4[@class='product-name']"));

        //need iterate to select one item by filter usinglist
        for (int i=0; i <= product.size(); i++){
            //create an object to store everysingle getText on arraylist
            //need split the value of getText to get correct contains
            String[] name = product.get(i).getText().split("-"); //name[0]-"Brocolli " -name[1]-" 1 Kg"
            //need delete all whitepspace on text can use trim method
            //also need store an new object
            String formattedName = name[0].trim();

            //need convert array into arraylist for easy search
            //check whether name you extracted is present in arraylist or not
            List itemNeededList = Arrays.asList(itemNeeded);

            //make conditions to searching item with contains every single index
            if (itemNeededList.contains(formattedName)){
                j++;
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                if (j==itemNeeded.length){
                    break;
                }
            }
        }
    }
}

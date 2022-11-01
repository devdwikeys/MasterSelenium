package Midlevel;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Addmultiplemethod {

    public static void main(String[] args) throws InterruptedException {



        System.setProperty("webdriver.chrome.driver", "E:\\MasterSelenium\\PathWebDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //declare an object to input multipleSearching item
        String[] itemNeeded = {"Brocolli","Cucumber","Beetroot", "Beans", "Brinjal"};

        //implicit wait will targeting globally an locator on this code
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //create an object to create global explicit wait
        //WebDriverWait explicitWait = new WebDriverWait(driver,5);
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
        Thread.sleep(3000);
        //calling method by static
        addItem(driver, itemNeeded);
        //continue the testcase to do checkout
        driver.findElement(By.xpath("//img[@alt='Cart']")).click();
        driver.findElement(By.xpath("//*[text()='PROCEED TO CHECKOUT']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("rahulshettyacademy");
        driver.findElement(By.xpath("//button[@class='promoBtn']")).click();
        //implement explicit wait
        //explicit wait only work on targetting object not an global like implicit
        //explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='promoInfo']")));
        System.out.println(driver.findElement(By.xpath("//span[@class='promoInfo']")).getText());


    }

    //create an method addItem
    public static void addItem(WebDriver driver, String[] itemNeeded){

        //declare an variables to loop
        int j = 0;
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

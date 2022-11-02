package AssignmentTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class Assignment02 {

    public static void main(String[] args) throws InterruptedException {

        //declare global variables
        System.setProperty("webdriver.chrome.driver", "E:\\MasterSelenium\\PathWebDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait explicit = new WebDriverWait(driver, Duration.ofSeconds(5));


        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        //calling method in same class(static method)
        driver.findElement(By.xpath("//*[@id='username']")).sendKeys(getUsername(driver));
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys(getPassword(driver));
        driver.findElement(By.xpath("//*[text()=' User']//following-sibling::span")).click();
        //check validation radiobutton isSelected
        Assert.assertFalse(driver.findElement(By.xpath("//*[text()=' User']//following-sibling::span")).isSelected());
        //handling explicit wait
        explicit.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='okayBtn']"))).click();
        //handing static dropdown
        WebElement options = driver.findElement(By.xpath("//select[@class='form-control']"));
        Select dropdown = new Select(options);
        dropdown.selectByVisibleText("Consultant");
        driver.findElement(By.xpath("//*[@id='terms']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='terms']")).isSelected());
        driver.findElement(By.xpath("//*[@id='signInBtn']")).click();
        //handing explicit wait
        explicit.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='btn btn-info']")));
        addItems(driver);
        driver.findElement(By.xpath("//*[contains(@class, 'btn-primary')]")).click();

    }

    public static String getUsername (WebDriver driver){
       String username = driver.findElement(By.xpath("//*[text()='rahulshettyacademy']")).getText();
       return username;

    }
    public static String getPassword(WebDriver driver){
        String password = driver.findElement(By.xpath("//*[text()='learning']")).getText();
        return password;
    }

    public static void addItems(WebDriver driver){
        List<WebElement> products = driver.findElements(By.xpath("//*[@class='btn btn-info']"));
        for (int i=0; i< products.size(); i++){
            products.get(i).click();
        }
    }
}

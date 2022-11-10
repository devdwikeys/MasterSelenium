package AssignmentTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;

public class Assignment05 {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "E:\\MasterSelenium\\PathWebDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        WebElement checkBox = driver.findElement(By.xpath("//input[@id='checkBoxOption2']"));
        checkBox.click();
        //create validation isSelected checkbox
        System.out.println(checkBox.isSelected());
        Assert.assertTrue(checkBox.isSelected());
        String option = driver.findElement(By.xpath("//input[@id='checkBoxOption2']/parent::label")).getText();
        option.trim();
        System.out.println(option);
        WebElement dropDown = driver.findElement(By.xpath("//select[@id='dropdown-class-example']"));
        Select select = new Select(dropDown);
        select.selectByVisibleText(option);
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys(option);
        driver.findElement(By.xpath("//input[@id='alertbtn']")).click();
        String text = driver.switchTo().alert().getText();

        if (text.contains(option)){
            System.out.println("Alert message success");
        }else {
            System.out.println("Invalid get text");
        }
        driver.switchTo().alert().accept();
        driver.findElement(By.xpath("//a[@id='opentab']")).click();
    }
}

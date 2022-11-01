package defaults.dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class Updateddropdown {

    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver", "E:\\MasterSelenium\\PathWebDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        //how to handle and check validation on checkbox
        System.out.println("Checkbox value Before do action : "
                +driver.findElement(By.xpath("//input[contains(@Id,'SeniorCitizenDiscount')]"))
                .isSelected()); //will check validations of checkbox, datatype Boolean if false is unchecked/ true is checked
        //use method assertion to create validate on testcase
        Assert.assertFalse(driver.findElement(By.xpath("//input[contains(@Id,'SeniorCitizenDiscount')]"))
                .isSelected());

        driver.findElement(By.xpath("//input[contains(@Id,'SeniorCitizenDiscount')]")).click();

        System.out.println("Checkbox value after do action : "
                +driver.findElement(By.xpath("//input[contains(@Id,'SeniorCitizenDiscount')]"))
                .isSelected()); //will check validations of checkbox, datatype Boolean if false is unchecked/ true is checked
        //create validation on checkbox after perfoming some click
        Assert.assertTrue(driver.findElement(By.xpath("//input[contains(@Id,'SeniorCitizenDiscount')]"))
                .isSelected());

        //count the number of element all checkbox at page URL
        System.out.println("This total all checkbox : " + driver.findElements(By.xpath("//input[@type='checkbox']")).size());

        driver.findElement(By.xpath("//*[@id='divpaxinfo']")).click();
        Thread.sleep(2000);
        //do some validate defaults value on element and use assertion
        System.out.println("Before do action : " +driver.findElement(By.xpath("//*[@id='divpaxinfo']")).getText());
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='divpaxinfo']")).getText(), "1 Adult");

        //do multiple click using loop
        for (int i = 1; i <=4; i++){
            driver.findElement(By.xpath("//*[@id='hrefIncAdt']")).click();
        }
        //doing with while, same function only diff how to write
        int j = 1;
        while (j <= 4 ){
            driver.findElement(By.xpath("//*[@id='hrefIncAdt']")).click();
            j++;
        }
        driver.findElement(By.xpath("//*[@id='btnclosepaxoption']")).click();

        //do some validate after do action on element and use assertion
        System.out.println("after do action : " +driver.findElement(By.xpath("//*[@id='divpaxinfo']")).getText());
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='divpaxinfo']")).getText(), "9 Adult");
    }
}

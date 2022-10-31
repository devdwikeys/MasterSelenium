package AssignmentTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class Assignment01 {

    /*
    The task is should input data on some element, then get the success toaster, print text of toaster
    and create validations on that
     */

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "E:\\MasterSelenium\\PathWebDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/angularpractice/");

        driver.findElement(By.xpath("//*[text()='Name']//following-sibling::input")).sendKeys("Qarenina");
        driver.findElement(By.xpath("//*[text()='Email']//following-sibling::input")).sendKeys("qaren@gmail.com");
        Thread.sleep(3000);
        JavascriptExecutor command = (JavascriptExecutor) driver;
        command.executeScript("window.scroll(0,600)");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='exampleInputPassword1']")).sendKeys("Qareninarestu");
        driver.findElement(By.xpath("//*[@id='exampleCheck1']")).click();
        System.out.println("Checkstatus checkbox is selected : " +
                driver.findElement(By.xpath("//*[@id='exampleCheck1']")).isSelected());
        List<WebElement> option = driver.findElements(By.xpath("//select/option"));
        for (WebElement chooseFemale :option){
            if (chooseFemale.getText().equals("Female")){
                chooseFemale.click();
                break;
            }
        }
        driver.findElement(By.xpath("//input[@id='inlineRadio2']")).click();
        List<WebElement> validationEnabled = driver.findElements(By.xpath("//input[@type='radio']"));
        for (WebElement checkStatus: validationEnabled){
            System.out.println("checkStatus checkbox isEnabled : " + checkStatus.isEnabled());
        }
        driver.findElement(By.xpath("//input[@name='bday']")).sendKeys("10/03/2022");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@class='btn btn-success']")).click();
        Thread.sleep(2000);
        command.executeScript("window.scroll(0,-600)");
        String text = driver.findElement(By.xpath("//strong")).getText();
        Assert.assertEquals(text,"Success!");
        System.out.println(text);

    }
}

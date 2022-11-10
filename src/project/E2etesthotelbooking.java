package project;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class E2etesthotelbooking {

    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver", "E:\\MasterSelenium\\PathWebDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://tiket.com/");
        driver.findElement(By.xpath("//img [@alt='Booking hotel']")).click();
        JavascriptExecutor command = (JavascriptExecutor) driver;
        command.executeScript("window.scroll(0,400)");

        driver.findElement(By.xpath(" //input[@id='destination-input']")).click();
        List<WebElement> option  = driver.findElements(By.xpath("//div[@class='name']"));
        System.out.println(driver.findElements(By.xpath("//div[@class='name']")).size());
        for ( WebElement selectLocation : option){
            if (selectLocation.getText().equals("Bali")){
                selectLocation.click();
                break;
            }
        }
        WebElement today = driver.findElement(By.xpath("//div[text()='Hari ini']/following-sibling::div[@class='day-mod-body with-cheapest']"));
        today.click();
        int todayDate = Integer.parseInt(today.getText());
        System.out.println(todayDate);
        int oneWeeksDate = todayDate + 7;
        String oneWeekDate = String.valueOf(oneWeeksDate);
        List<WebElement> endDate = driver.findElements(By.xpath("//div[@class='day-mod-body ']"));
        System.out.println(endDate.size());
        System.out.println(oneWeeksDate);
        Thread.sleep(2000);
        for (WebElement selectEndDate: endDate){
            if (selectEndDate.getText().equals(oneWeekDate)){
                selectEndDate.click();
                break;
            }
        }


    }
}

package AssignmentTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class Assignment03 {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "E:\\MasterSelenium\\PathWebDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/windows");

        //need to print all text in parentTab and childTab
        driver.findElement(By.xpath("//a[@href='/windows/new']")).click();
        Set<String> windows = driver.getWindowHandles(); //store the value of [parentID, childID]
        Iterator<String> it = windows.iterator();
        String parentId = it.next();
        String childId = it.next();
        driver.switchTo().window(childId);
        //get the element text from childTab
        System.out.println(driver.findElement(By.xpath("//div[@class='example']/h3")).getText());
        driver.switchTo().window(parentId);
        System.out.println(driver.findElement(By.xpath("//div[@class='example']/h3")).getText());
    }
}

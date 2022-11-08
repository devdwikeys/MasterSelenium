package defaults.navigateSwithPopUp;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class Windowshandleconcepts {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "E:\\MasterSelenium\\PathWebDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");

        //click the element link will open in new tab
        driver.findElement(By.xpath("//*[@class='blinkingText']")).click();
        //how to switch the tab/windows into other
        //we should declare to store parentWindows/tab and childWindows/tab
        Set<String> windows = driver.getWindowHandles(); //store the value of [parentID, childID]
        Iterator<String> it = windows.iterator();
        String parentId = it.next();
        String childId = it.next();
        //how to switch from parentId/Web/tab into childId/parent/tab
        driver.switchTo().window(childId);
        System.out.println(driver.findElement(By.xpath("//p[@class='im-para red']")).getText()
                .split("at")[1].trim().split(" ")[0]);
        String getEmail = driver.findElement(By.xpath("//p[@class='im-para red']")).getText().split("at")[1].trim().split(" ")[0];
        driver.switchTo().window(parentId);
        driver.findElement(By.xpath("//*[@id='username']")).sendKeys(getEmail);
    }
}

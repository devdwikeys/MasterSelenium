package project.interview;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Verintautomation {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "E:\\MasterSelenium\\PathWebDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");

        driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("Verint");
        WebElement searchBox = driver.findElement(By.xpath("//div[@class='mkHrUc']"));
        System.out.println(searchBox.findElements(By.xpath("//div/div/ul/li/div/div/div/span")).size());
        List<WebElement> listItem = searchBox.findElements(By.xpath("//div/div/ul/li/div/div/div/span"));
        for (WebElement selectedItem : listItem){
            if (selectedItem.getText().equals("verint indonesia")){
                selectedItem.click();
                break;
            }
        }
        List<WebElement> listLink = driver.findElements(By.xpath("//cite[@role='text']"));
        System.out.println(listLink.size());
        for (WebElement selectedLink : listLink){
            if (selectedLink.getText().contains("verint.com")){
                Actions move = new Actions(driver);
                move.moveToElement(selectedLink).keyDown(Keys.CONTROL).click().build().perform();
                break;
            }
        }
        Set<String> windows = driver.getWindowHandles(); //store the value of [parentID, childID]
        Iterator<String> it = windows.iterator();
        String parentId = it.next();
        String childId = it.next();
        //how to switch from parentId/Web/tab into childId/parent/tab
        driver.switchTo().window(childId);
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.verint.com/");
        Assert.assertEquals(driver.getTitle(),"Verint Customer Engagement");
        driver.switchTo().window(parentId);

    }
}

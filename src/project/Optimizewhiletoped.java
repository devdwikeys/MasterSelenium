package project;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Optimizewhiletoped {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "E:\\MasterSelenium\\PathWebDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://seller.tokopedia.com/edu");

        //Declare webelement to store dynamic link
        WebElement butonMenu = driver.findElement(By.xpath("//*[@data-testid='btnSellereduSelectedtopicSlideright']"));
        List<WebElement> tabLink = butonMenu.findElements(By.xpath("//*[contains(@data-testid,'icnSellereduSelectedtopicDynamicIcon')]"));
        System.out.println(tabLink.size());
        for ( WebElement clickLink : tabLink){
            Actions ctrl = new Actions(driver);
            ctrl.moveToElement(clickLink).keyDown(Keys.CONTROL).click().build().perform();
            Thread.sleep(3000);
        }
        Set<String> move = driver.getWindowHandles();
        Iterator<String> it = move.iterator();
        while (it.hasNext()){
            driver.switchTo().window(it.next());
            System.out.println(driver.getCurrentUrl());
            Thread.sleep(2000);
        }
    }
}

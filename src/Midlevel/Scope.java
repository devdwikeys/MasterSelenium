package Midlevel;

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

public class Scope {
    public static void main(String[] args) throws InterruptedException {
        /*
        task : give me the count of links on the page
        hints : every link should be contains <a href> on HTML, so we can defines element contains tag <a>
        next case : count of links only on footer side
         */
        System.setProperty("webdriver.chrome.driver", "E:\\MasterSelenium\\PathWebDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        System.out.println(driver.findElements(By.tagName("a")).size());
        //select footer element to limiting webdriver scope
        WebElement footer = driver.findElement(By.xpath("//div[@id='gf-BIG']"));
        System.out.println(footer.findElements(By.tagName("a")).size());
        //declare sublimit element from footer
        WebElement coloumnFooter = footer.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        System.out.println(coloumnFooter.findElements(By.tagName("a")).size());
        List<WebElement> links = coloumnFooter.findElements(By.tagName("a"));
        //create case to click all link contains from coloumnfooter and check if the pages are opening
        for (WebElement clickLink : links){
            Actions ctrl = new Actions(driver);
            ctrl.moveToElement(clickLink).keyDown(Keys.CONTROL).click().build().perform();
            Thread.sleep(4000);
        }
        //open all tab and get the title on each tab
        Set<String> tab = driver.getWindowHandles();
        Iterator<String> it = tab.iterator();

        while (it.hasNext()){
            driver.switchTo().window(it.next());
            System.out.println(driver.getTitle());
        }
    }
}

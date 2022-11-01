package project.tiketdotcom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class E2etestflightbooking {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "E:\\MasterSelenium\\PathWebDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://tiket.com/");
        driver.findElement(By.xpath("//a[@href='/pesawat']//div[@class='VerticalIcons_icon__M26iM']")).click();
        Thread.sleep(5000);

        //how to scroll on selenium we should use JS
        //to call method we should create an object for js
        JavascriptExecutor command = (JavascriptExecutor) driver;
        command.executeScript("window.scroll(0,400)");
        Thread.sleep(5000);
        System.out.println("Total radio button : " +driver.findElements(By.xpath("//input[@type='radio']")).size());
        Assert.assertEquals(driver.findElements(By.xpath("//input[@type='radio']")).size() , 2);
        //testcase do booking oneway
        driver.findElement(By.xpath("//input[@id='roundtrip']/following-sibling::label")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@id='oneway']/following-sibling::label")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@placeholder='Kota atau bandara']")).click();
        Thread.sleep(5000);
        List<WebElement> optionsDepart = driver.findElements(By.xpath("//div[@class='col-code']"));
        for ( WebElement choose : optionsDepart){
            if (choose.getText().equals("JKTC")){
                choose.click();
                break;
            }
        }
        Thread.sleep(5000);
        List<WebElement> optionsArrive = driver.findElements(By.xpath("//input[@placeholder='Mau ke mana?']/parent::div //div[@class='col-code']"));
        System.out.println(driver.findElements(By.xpath("//input[@placeholder='Mau ke mana?']/parent::div //div[@class='col-code']")).size());
        for (WebElement chooseTo : optionsArrive){

            if (chooseTo.getText().equals("DPSC")){
                chooseTo.click();
                break;
            }
        }
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[@class='widget-date-picker-day']/span")).click();
        System.out.println(driver.findElement(By.xpath("//div[@class='widget-date-picker-day']/span")).getText());

        for (int i = 1; i<=3; i++){
            driver.findElement(By.xpath("//*[text()='Dewasa']/parent::div/following-sibling::div //button[@data-btn='plus']")).click();
        }

        Thread.sleep(5000);
        int j = 1;
        while (j<=2){
            driver.findElement(By.xpath("//*[text()='Anak']/parent::div/following-sibling::div //button[@class='button-count js-btn-plus']")).click();
            j++;
        }

        Thread.sleep(5000);
        List<WebElement> optionCheck = driver.findElements(By.xpath("//div[@class='col-xs-6 col-cabin']/ul/li/label"));
        for (WebElement tickBox : optionCheck){
            if (tickBox.getText().equals("Bisnis")){
                tickBox.click();
                break;
            }
        }

        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[text()='SELESAI']")).click();
        driver.findElement(By.xpath("//*[text()='CARI PENERBANGAN']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@class=\"comp-info-box\"]/div[contains(@class, 'v3-btn__blue')]")).click();
        driver.navigate().back();
        Thread.sleep(3000);
        driver.navigate().forward();






        //Thread.sleep(3000);
        //check validations for radiobutton
        //System.out.println(driver.findElement(By.xpath("//input[@id='roundtrip']/following-sibling::label")).isSelected());
        //Assert.assertTrue(driver.findElement(By.xpath("//input[@id='roundtrip']/following-sibling::label")).isSelected());
        //Assert.assertFalse(driver.findElement(By.xpath("//input[@id='oneway']/following-sibling::label")).isSelected());


    }
}

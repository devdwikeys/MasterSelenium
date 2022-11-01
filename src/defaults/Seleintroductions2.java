package defaults;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class Seleintroductions2 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "E:\\MasterSelenium\\PathWebDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //To use method to create an object from class
        Seleintroductions2 callMethod = new Seleintroductions2();
        String name = "Qarenina";
        //in the test case will do this method first
        String password = callMethod.getPassword(driver);


        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(name);
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@id='chkboxOne']")).click();
        driver.findElement(By.xpath("//input[@id='chkboxTwo']")).click();
        driver.findElement(By.xpath("//button[.='Sign In']")).click();
        Thread.sleep(3000);

        //how extract value from frontend to backend using TestNg
        String element = driver.findElement(By.xpath("//p")).getText();
        System.out.println(element);

        //How to validate the element by TestNG
        Assert.assertEquals(element, "You are successfully logged in.");
        //How to validate the element dynamic
        String element2 = driver.findElement(By.xpath("//div[@class='login-container']/h2")).getText();
        System.out.println(element2);
        Assert.assertEquals(element2, "Hello "+name+",");

        //how to located by text on HTML
        driver.findElement(By.xpath("//*[text()='Log Out']")).click();
        driver.close();

        //On TestNG validation not print at terminal, it will be showing on terminal only for false
    }

    //Create an method outside main method to create dynamic store value on password

    public String getPassword(WebDriver driver) throws InterruptedException {

        //create flow to forget password to store value into new object password
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@class='reset-pwd-btn']")).click();

        //Store value test into new an object
        String passwordText = driver.findElement(By.xpath("//p[@class='infoMsg']")).getText();
        System.out.println(passwordText);
        //we should split the String into new abject array
        // the value from Text is --- Please use temporary password 'rahulshettyacademy' to Login. ---
        String [] passArray = passwordText.split("'");
        /*
        The logic is after split from passwordText
        [0] = -- Please use temporary password '--
        [1] = --rahulshettyacademy' to Login.--
        We need more spesific to get the right value
         */
        String [] passArray2 = passArray[1].split("'");
        //String [] passArray2 = passArray[1].split("'").[0];
        /*
        The logic is after split from passArray[1] -- value index -- rahulshettyacademy' to Login.
        [0] = --rahulshettyacademy-- -- this index we need to store the right value --
        [1] = --' to login--
         */
        String password = passArray2[0];
        return password;
        //we return the value into outside this method

    }
}

package defaults.dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class e2eTest {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "E:\\MasterSelenium\\PathWebDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        //Case auto suggestion when input value into textfield Country
        driver.findElement(By.xpath("//input[@id='autosuggest']")).sendKeys("In");
        List<WebElement> options = driver.findElements(By.xpath("//li[@class='ui-menu-item']/a"));
        for ( WebElement option : options){
            if (option.getText().equals("India")){ //we by looping 1by1 element till get same value with expected
                option.click();
                break;//we should calling break when our value found then looping must be stop
            }
        }
        //Defaults page will selected oneway trip case, this create validation to check radio button oneway isSelected
        boolean OneWay = driver.findElement(By.xpath("//input[@id='ctl00_mainContent_rbtnl_Trip_0']")).isSelected();
        System.out.println("Status OneWay radioBtn : " + OneWay);
        Assert.assertTrue(OneWay);
        //Case input departure and arrival
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//a[@value='BLR']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='MAA']")).click();
        //TestCase selected schedule by today and check validations isEnabled for returnDate element'
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[contains(@class, 'ui-datepicker-today')]")).click();
        //create validations for OneWay, if OneWay the returnDate opacity value is 0.5
        System.out.println(driver.findElement(By.xpath("//div[@id='Div1']")).getAttribute("style"));
        if (driver.findElement(By.xpath("//div[@id='Div1']")).getAttribute("style").contains("0.5")){
            System.out.println("The element is disabled");
            Assert.assertTrue(true);
        }
        else {
            System.out.println("The element is enabled");
            Assert.assertTrue(false);
        }

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

        //CreateTestcase for selected static dropdown with tag at currency Element
        //create an object Webelement to store the located
        WebElement staticDropdown = driver.findElement(By.xpath("//select[contains(@id, 'DropDownListCurrency')]"));

        //create an object to using Select method --special method for dropdown(select tag)--
        Select dropdown = new Select(staticDropdown);
        //this select only able to get 1 selected item not multiple
        dropdown.selectByIndex(3); //filtered by index
        System.out.println(dropdown.getFirstSelectedOption().getText());//getFirstSelect only able to select by single not multiple
        dropdown.selectByVisibleText("AED");//filtered by showing text at page
        System.out.println(dropdown.getFirstSelectedOption().getText());//use this method we can use for validating the data
        dropdown.selectByValue("INR");//filtered by attribute at inspect element
        System.out.println(dropdown.getFirstSelectedOption().getText());
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id='ctl00_mainContent_btn_FindFlights']")).click();




    }
}

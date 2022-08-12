import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class GoogleImageTabTest {
    WebDriver driver;
    private static final String KEYWORD = "image";

    @BeforeTest
    public void profileSetUp(){chromedriver().setup();}

    @BeforeMethod
    public void testSetUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
    }

    @Test
    public void checkImageTabHasImages(){
        driver.findElement(By.xpath("//button[@id='W0wltc']")).click();
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys(KEYWORD);
        driver.findElement(By.xpath("//div[@class='FPdoLc lJ9FBc']//input[@name='btnK']")).click();
        driver.findElement(By.xpath("//a[@data-hveid='CAIQAw']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='islrg']//img")).isEnabled());
    }

    @AfterMethod
    public void testDown(){driver.quit();}
}

package seleniumAdvanced;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Sharif on 10/18/2017.
 */
public class ExtentReportTestClass extends ExtendReport {
    public WebDriver driver;

    public void commonAPI(){
        System.setProperty("webdriver.chrome.driver", "C://Users//Sharif//development//SeleniumBasic//drivers//chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Test
    public void test_01(){
        commonAPI();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://bos.ranksitt.net/login");
        driver.findElement(By.xpath("html/body/section/div/div/div[2]/form/div[1]/div/input")).sendKeys("admin");
        driver.findElement(By.xpath("html/body/section/div/div/div[2]/form/div[2]/div[2]/inputza")).sendKeys();
        driver.findElement(By.xpath("html/body/section/div/div/div[2]/form/div[3]/div[2]/button[1]")).click();
        System.out.println("Test is fail");

    }
    @Test
    public void test_02(){
        commonAPI();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://bos.ranksitt.net/login");
        driver.findElement(By.xpath("html/body/section/div/div/div[2]/form/div[1]/div/input")).sendKeys("admin");
        driver.findElement(By.xpath("html/body/section/div/div/div[2]/form/div[2]/div[2]/input")).sendKeys("admin");
        driver.findElement(By.xpath("html/body/section/div/div/div[2]/form/div[3]/div[2]/button[1]")).click();
        System.out.println("Test is pass");

    }
}

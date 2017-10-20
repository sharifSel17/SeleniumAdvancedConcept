package seleniumAdvanced;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/**
 * Created by Sharif on 10/11/2017.
 */
public class LoginBaseProperties extends TestBaseProperties{

    @Test
    public void loginTest() throws Exception{
        setUp();
        System.setProperty("webdriver.chrome.driver", "C://Users//Sharif//development//SeleniumBasic//drivers//chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("http://bos.ranksitt.net/login");
        driver.findElement(By.xpath(OR.getProperty("login.userId"))).sendKeys("admin");
        driver.findElement(By.xpath(OR.getProperty("login.userPassWord"))).sendKeys("admin");
        driver.findElement(By.xpath(OR.getProperty("login.SubmitButton"))).click();
    }
}

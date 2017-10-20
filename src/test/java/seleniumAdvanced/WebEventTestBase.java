package seleniumAdvanced;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Sharif on 10/19/2017.
 */
public class WebEventTestBase {
    public WebDriver dr;
    public EventFiringWebDriver driver;
    public WebEventWebEventListener eventListener;

    @BeforeTest
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C://Users//Sharif//development//SeleniumBasic//drivers//chromedriver.exe");
        dr = new ChromeDriver();
        driver = new EventFiringWebDriver(dr);
        eventListener = new WebEventWebEventListener();
        driver.register(eventListener);
    }

    @Test
    public void testEventListener() throws InterruptedException {
        driver.get("http://automationpractice.com/index.php");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id='header']/div[2]/div/div/nav/div[1]/a")).click();
        Thread.sleep(3000);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='header']/div[2]/div/div/nav/div[1]/a"))));
        driver.findElement(By.xpath("//*[@id='email']")).sendKeys("testCode");
        driver.findElement(By.xpath("//*[@id='passwd']")).sendKeys("testpass");
        driver.findElement(By.xpath("//*[@id='SubmitLogin']")).click();
    }
}

package seleniumAdvanced;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Sharif on 10/19/2017.
 */
public class WebEventTestEventListener extends WebEventTestBase{
    @Test
    public void testEventListener() throws InterruptedException{
        driver.get("http://automationpractice.com/index.php");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='header']/div[2]/div/div/nav/div[1]/a"))));
        driver.findElement(By.xpath("//*[@id='header']/div[2]/div/div/nav/div[1]/aaaa")).click();


        driver.findElement(By.xpath("//*[@id='email']")).sendKeys("testCode");
        driver.findElement(By.xpath("//*[@id='passwd']")).sendKeys("testpass");
        driver.findElement(By.xpath("//*[@id='SubmitLogin']")).click();
    }
}

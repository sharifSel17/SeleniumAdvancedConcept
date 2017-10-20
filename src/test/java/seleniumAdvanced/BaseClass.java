package seleniumAdvanced;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Sharif on 10/12/2017.
 */
public class BaseClass {
    public WebDriver driver;
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "C://Users//Sharif//development//SeleniumBasic//drivers//chromedriver.exe");
        driver = new ChromeDriver();
    }

}

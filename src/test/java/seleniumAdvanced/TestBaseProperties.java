package seleniumAdvanced;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

/**
 * Created by Sharif on 10/11/2017.
 */


public class TestBaseProperties {
    public Properties OR;
    public File file;
    public FileReader fileReader;
    WebDriver driver;
    public void setUp() throws Exception{
        OR = new Properties();
        file = new File(System.getProperty("user.dir")+"\\src\\test\\Properties\\config.properties");
        fileReader = new FileReader(file);
        OR.load(fileReader);

        file = new File(System.getProperty("user.dir")+"\\src\\test\\Properties\\or.properties");
        fileReader = new FileReader(file);
        OR.load(fileReader);

    }

}

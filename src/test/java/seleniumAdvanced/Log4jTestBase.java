package seleniumAdvanced;

import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeTest;
import java.util.logging.Logger;

/**
 * Created by Sharif on 10/19/2017.
 */
public class Log4jTestBase {
    private static final Logger logger = Logger.getLogger(Log4jTestBase.class.getName());

    @BeforeTest
    public void loadlog4J(){
        String log4jConfPath = System.getProperty("user.dir")+"\\src\\test\\java\\seleniumAdvanced\\log4J.properties";
        PropertyConfigurator.configure(log4jConfPath);
    }
}

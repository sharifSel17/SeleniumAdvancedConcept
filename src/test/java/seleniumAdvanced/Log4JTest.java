package seleniumAdvanced;

import org.testng.annotations.Test;
import java.util.logging.Logger;

/**
 * Created by Sharif on 10/19/2017.
 */
public class Log4JTest extends Log4jTestBase{
    private static final Logger logger = Logger.getLogger(Log4JTest.class.getName());
    @Test
    public void testLogin(){
        logger.info("staring login test");
        logger.info("clicked on sign in button");
        logger.info("enter user name");
        logger.info("enter password");
        logger.info("click on submit button");
    }
}

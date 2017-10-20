package seleniumAdvanced;

import org.testng.annotations.Test;

/**
 * Created by Sharif on 10/11/2017.
 */
public class LogOutBaseProperties extends TestBaseProperties{


    @Test
    public void loginTest(){
        System.out.println(OR.get("userName"));
        System.out.println(OR.get("passWord"));
        System.out.println(OR.get("url"));
        System.out.println(OR.get("browser"));
        System.out.println(OR.get("login.userId"));
    }
}

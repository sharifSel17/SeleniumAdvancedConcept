package seleniumAdvanced;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Sharif on 10/12/2017.
 */
public class HowToHandleDynamicCalenderInSelenium extends BaseClass{
    @Test
    public void seleteDate() throws InterruptedException{
        String selectdata = "10/15/2017";
        Date d = new Date(selectdata);
        SimpleDateFormat dt = new SimpleDateFormat("MMMM/dd/yyyy");
        String date = dt.format(d);
        System.out.println(date);
        String[] split = date.split("/");
        System.out.println(split[2]+" "+split[1]+" "+split[0]);
        String month = split[0]+" "+split[2];
        System.out.println("month-------"+month);
        setup();
        driver.get("https://www.goibibo.com/");
        driver.findElement(By.xpath("//*[@id='gi_oneway_label']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(".//*[@id='searchWidgetCommon']/div/div[3]/div[1]/div[1]/div/input")).click();
        Thread.sleep(2000);
        //*[contains(text(),'November 2016')]
        while(true){
            try{
                driver.findElement(By.xpath("//*[contains(text(),'"+month+"')]")).isDisplayed();
				String firstPart = ".//*[@id='fare_";
                String secondPart = "']";
                String[] splitDate = selectdata.split("/");
                String finalPart = firstPart+splitDate[2]+splitDate[1]+splitDate[0]+secondPart;
                System.out.println("selecting this date in calender:-"+finalPart);
                driver.findElement(By.xpath(finalPart)).click();
                break;
            }
            catch(Exception e){
                driver.findElement(By.xpath(".//*[@id='searchWidgetCommon']/div/div[3]/div[1]/div[1]/div/div/div/div[3]/div[1]/span")).click();
                Thread.sleep(2000);
            }
        }
    }

}

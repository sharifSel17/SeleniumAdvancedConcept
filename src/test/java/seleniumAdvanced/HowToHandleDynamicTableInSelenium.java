package seleniumAdvanced;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by Sharif on 10/13/2017.
 */
public class HowToHandleDynamicTableInSelenium extends BaseClass{
    String[] s1 = {"testing","maintenance","design"};
    @Test
    public void dynamicObject() throws Exception{
        String testing = "testing";
        int j = 0;
        int k = 1;
        setup();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://online.actitime.com/self-employee/login.do");
        driver.findElement(By.xpath(".//*[@id='username']")).sendKeys("sharifaiub09");
        driver.findElement(By.xpath(".//*[@id='loginFormContainer']/tbody/tr[1]/td/table/tbody/tr[2]/td/input")).sendKeys("QA9eXuZY");
        driver.findElement(By.xpath(".//*[@id='loginButton']/div")).click();
        Thread.sleep(8000);

        driver.findElement(By.xpath(".//*[@id='enterTTMainContent']/table[1]/tbody/tr[3]/td[1]/table/tbody/tr/td[7]/nobr/span")).click();
        Thread.sleep(6000);
        driver.findElement(By.xpath(".//*[@id='createTasksPopup_customerSelector']/table/tbody/tr/td[2]/em/button")).click();
        driver.findElement(By.xpath(".//*[contains(text(),'- New Customer -')]")).click();
        driver.findElement(By.xpath(".//*[@id='createTasksPopup_newCustomer']")).sendKeys("David");
        driver.findElement(By.xpath(".//*[@id='createTasksPopup_newProject']")).sendKeys("HRManagement");


        int count = driver.findElements(By.xpath(".//*[@id='createTasksPopup_createTasksTableContainer']/table/tbody/tr")).size();

        for(int i =1; i<= count; i++){

            String selectdata = "10/15/2017";

            Date d = new Date(selectdata);

            SimpleDateFormat dt = new SimpleDateFormat("MMM/dd/yyyy");

            String date = dt.format(d);

            System.out.println(date);

            String[] split = date.split("/");
            System.out.println(split[0]+" "+split[1]+" "+split[2]);
            String year = split[2];
            System.out.println("year-------"+year);
            String month = split[0];
            System.out.println("month-------"+month);
            String day = split[1];

            String xpath1 = "//*[@id='createTasksPopup_createTasksTableContainer']/table/tbody/tr[";
            String xpath2 = "]";
            String finalXpath = xpath1+i+xpath2;

            // xpath for enter task name
            String enterTaskName = finalXpath+"/td[1]/input";
            System.out.println("enter Task Name object:-"+enterTaskName);
            driver.findElement(By.xpath(enterTaskName)).sendKeys("Task:-"+i);

            // xpath for not needed
            String notNeeded = finalXpath+"/td[3]/input";
            System.out.println("not needed:-"+notNeeded);
            driver.findElement(By.xpath(notNeeded)).sendKeys("I am test");

            // xpath for Code to select date
            String setDeadLine = finalXpath+"/td[1]/following-sibling::td[3]/div/table/tbody/tr/td[2]/em/button";
            System.out.println("set DeadLine:-"+setDeadLine);

            driver.findElement(By.xpath(setDeadLine)).click();

            if(i>=1){
                driver.findElements(By.xpath("//*[@class='x-date-picker x-unselectable atap-base-date-picker atap-date-picker']/table/tbody/tr/td[2]/table/tbody/tr/td[2]/em/button")).get(i-1).click();
            }

            String monthObject = month;
            System.out.println("month Object:-"+monthObject);
            String yearObject = year;
            System.out.println("year Object:-"+yearObject);


            driver.findElement(By.linkText(monthObject)).click();
            driver.findElement(By.linkText(yearObject)).click();
            //Careful about space
            if(i>=1){
                driver.findElements(By.xpath("//button[@class='x-date-mp-ok']")).get(i-1).click();
            }
            //driver.findElement(By.xpath("//button[@class='x-date-mp-ok']")).click();
            driver.findElement(By.linkText(day)).click();

            //x-path for select work type
            String typeOfWork = finalXpath+"/td[1]/following-sibling::td[4]/child::*/child::*/child::*/child::*/child::td[2]/child::*/button";
            driver.findElement(By.xpath(typeOfWork)).click();
            Thread.sleep(2000);

            String object = "//*[contains(text(),"+"'"+s1[j++]+"'"+")]";
            System.out.println(object);

            if (i==1){
                WebElement text = driver.findElements(By.xpath("//*[@class='x-layer x-menu at-dropdown-list-btn-menu billingTypeSelectorMenu addNewTasks']/ul/li")).get(2);
                text.click();
            }
            if (i==2){
                WebElement text = driver.findElements(By.xpath("//*[@class='x-layer x-menu at-dropdown-list-btn-menu billingTypeSelectorMenu addNewTasks']/ul/li")).get(11);
                text.click();
            }
            if (i==3){
                WebElement text = driver.findElements(By.xpath("//*[@class='x-layer x-menu at-dropdown-list-btn-menu billingTypeSelectorMenu addNewTasks']/ul/li")).get(21);
                text.click();
            }

        }

    }

}

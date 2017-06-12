package Utilites;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by laxmikant on 04/05/2017.
 */
public class AlertFunction {
    /*static ExtentReports extent ;
    static WebDriver driver;*/
    public static void AlerFun(WebDriver driver) throws InterruptedException {

       /* extent = initExtentReport.init();
        ExtentTest test = extent.startTest("Registration Page Test", "To Test the functionalty of Submit button");
*/      Thread.sleep(100);
        if ((ExpectedConditions.alertIsPresent()) == null) {
        //System.out.println("alert was not present");
    } else {
         // System.out.println("alert was present");

            Alert alert = driver.switchTo().alert();
          String AlertMessage =  driver.switchTo().alert().getText();
            /*test.log(LogStatus.INFO, AlertMessage);*/
         // alert.accept();

      }


    }
}

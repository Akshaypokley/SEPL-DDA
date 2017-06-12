package Utilites;

import org.openqa.selenium.WebDriver;

/**
 * Created by akshay.pokley on 6/8/2017.
 */
public class BeforeWH {
    WebDriver driver;

    public static void BeforeWH(WebDriver driver){

       /*S WinHandleBefore1 = ;*/
        // Switch to new window opened
        for (String Handle1 : driver.getWindowHandles()) {
            driver.switchTo().window(Handle1);
        }

        try {
            Thread.sleep(5000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

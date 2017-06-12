package Utilites;

import org.openqa.selenium.WebDriver;

/**
 * Created by AKSHAY on 05/05/2017.
 */
public class WindowFun2 {
    static WebDriver driver;
    public static void  WindowFunction2(WebDriver driver )
    {
        String WinHandleBefore1 = driver.getWindowHandle();
        // Switch to new window opened
        for(String Handle1 : driver.getWindowHandles())
        {
            driver.switchTo().window(Handle1);
        }

        try
        {
            Thread.sleep(5000);

        }  catch (InterruptedException e)
        {
            e.printStackTrace();
        }

    }
}

package Utilites;

import org.openqa.selenium.WebDriver;

import java.util.Set;

/**
 * Created by AKSHAY on 02/05/2017.
 */
public class Windowhander {
    static WebDriver driver;
    static String windowHandle;
    public static void NewWindow(WebDriver driver) throws InterruptedException {

        Thread.sleep(900);
        String parentWindow = driver.getWindowHandle();

        Set<String> handles = driver.getWindowHandles();
        for (String windowHandle : handles) {
            if (!windowHandle.equals(parentWindow)) {
                driver.switchTo().window(windowHandle);
            }

        }


    }
    public static WebDriver LastWindow()
    {
        driver.switchTo().window(windowHandle);
        return driver;
    }
}

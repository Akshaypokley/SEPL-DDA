package Utilites;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by akshay.pokley on 5/24/2017.
 */
public class Frame {
   static WebDriver driver;

    public  static void switchToFrame(String frame,WebDriver driver) {
        try {
            WebElement d=driver.findElement(By.xpath(frame));
            driver.switchTo().frame(d);
            System.out.println("Navigated to frame with id " + frame);
        } catch (NoSuchFrameException e) {
            System.out.println("Unable to locate frame with id " + frame
                    + e.getStackTrace());
        } catch (Exception e) {
            System.out.println("Unable to navigate to frame with id " + frame
                    + e.getStackTrace());
        }
    }
}

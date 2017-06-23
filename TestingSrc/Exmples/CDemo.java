package Exmples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static Utilites.OpenBrowser.openBrowser;

/**
 * Created by akshay.pokley on 6/23/2017.
 */
public class CDemo {

    static WebDriver driver;

@BeforeMethod
    public static String f() {
        driver=openBrowser("chrome");
        driver.get("http://www.gogamers.com/#!blank/gs4id");
        String regex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";


        driver.findElement(By.xpath(".//*[@id='field1']")).sendKeys("$");

    String str = driver.findElement(By.xpath(".//*[@id='field1']")).getText();
        if (str.matches("^[\\s\\S]+")) {
            System.out.println("Invalid character in Name field");
        } else {
            System.out.println("valid");
        }
        return str;

    }

    @Test
    public void j(){}
}
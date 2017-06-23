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


        driver.findElement(By.xpath(".//*[@id='field1']")).sendKeys("lopi");
    final String str = driver.findElement(By.xpath(".//*[@id='field1']")).getText();
    final Pattern pattern = Pattern.compile("^[A-Za-z, ]++$");
    if (!pattern.matcher(str).matches()) {
            System.out.println("Invalid character in Name field");
        } else {
            System.out.println("valid");
        }
        return str;

    }

    @Test
    public void j(){}
}
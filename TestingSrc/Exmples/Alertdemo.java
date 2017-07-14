package Exmples;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static Utilites.OpenBrowser.openBrowser;

/**
 * Created by akshay.pokley on 7/12/2017.
 */
public class Alertdemo {
    WebDriver driver;

    @BeforeTest
    public void setup() throws Exception {
        driver = openBrowser("chrome");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://only-testing-blog.blogspot.in/2014/01/textbox.html");
    }

    @AfterTest
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void Text() throws InterruptedException {
        //Alert Pop up Handling.
        driver.findElement(By.xpath("//input[@value='Show Me Alert']")).click();
        //To locate alert.
        Alert A1 = driver.switchTo().alert();
        //To read the text from alert popup.
        String Alert1 = A1.getText();
        System.out.println(Alert1);
        Thread.sleep(2000);
        //To accept/Click Ok on alert popup.
        A1.accept();

        //Confirmation Pop up Handling.
        driver.findElement(By.xpath("//button[@onclick='myFunction()']")).click();
        Alert A2 = driver.switchTo().alert();
        String Alert2 = A2.getText();
        System.out.println(Alert2);
        Thread.sleep(2000);
        //To click On cancel button of confirmation box.
        A2.dismiss();

        //Prompt Pop up Handling.
        driver.findElement(By.xpath("//button[contains(.,'Show Me Prompt')]")).click();
        Alert A3 = driver.switchTo().alert();
        String Alert3 = A3.getText();
        System.out.println(Alert3);
        //To type text In text box of prompt pop up.
        A3.sendKeys("This Is John");
        Thread.sleep(2000);
        A3.accept();
    }
}

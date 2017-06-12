package Utilites;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by AKSHAY on 17/04/2017.
 */
public class TakeScreenShot

            {

    public static String takeScreenshot(WebDriver driver) throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        SimpleDateFormat sd = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
        String DateStr = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
        String imageName = "Registration"+DateStr+".png";
        String imagePath="ExtenReport/Registration/"+imageName;
        FileUtils.copyFile(scrFile, new File(imagePath));

        return imageName;


    }


}

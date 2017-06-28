package Utilites;

import org.openqa.selenium.WebDriver;

import java.util.regex.Pattern;

/**
 * Created by akshay.pokley on 6/26/2017.
 */
public class ValidationLogic {

  static WebDriver driver;
    public static void StringLog(WebDriver driver,String fieldValue,String result)
    {
        final Pattern pattern = Pattern.compile("^[A-Za-z, ]++$");
       /* if (!pattern.matcher(fieldValue).matches()) {
            result="fails";
        }else {
            result="pass";
        }*/

    }
}

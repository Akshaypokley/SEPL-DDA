package Utilites;

import Pages.Login;
import org.openqa.selenium.WebDriver;

/**
 * Created by akshay.pokley on 6/16/2017.
 */
public class Logi {
   static WebDriver driver;
    public  static String  Pa;
    public static int ik;
    public static void main(String[] args) {
        String source = "!@#$%^&*()?><";
        String Value = "uhj";
        int Value_len = Value.length();
        int source_len = source.length();


        String FA;

        for (int i = 0; (i < source_len); ++i) {
            ik = i;
            int j = 0;

            if (j >= Value_len) {

            } else if (Value.charAt(j) != source.charAt(i + j)) {
                Pa = "Pass";

            } else {
                ++j;
                if (j == Value_len) {
                }
            }
        }
        if (ik == source_len) {
            if (Pa.equals("Pass")) {
                System.out.println("jj");
                Login login = new Login(driver);
                login.setLoginF(Value);
                // Pa=P;
            }
        }
    }
}

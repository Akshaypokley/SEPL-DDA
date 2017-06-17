package Exmples;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.util.Strings;

/**
 * Created by akshay.pokley on 6/14/2017.
 */
public class DemoTest4 {
    public String  findTarget(String target, String source ) {

        int target_len = target.length();
        int source_len = source.length();

        String found = "fail";

        for (int i = 0; (i < source_len); ++i) {

            int j = 0;

            if (j >= target_len) {
                break;
            } else if (target.charAt(j) != source.charAt(i + j)) {
                break;
            } else {
                ++j;
                if (j == target_len) {
                    found = "pass";
                }
            }
        }


        return found;

    }

    public  void main ( String ... args ) {

        String target = "for";
        String source = "for";

        System.out.println(findTarget(target, source));

    }}
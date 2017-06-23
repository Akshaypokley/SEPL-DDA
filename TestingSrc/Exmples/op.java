package Exmples;

import java.io.IOException;
import java.util.regex.Pattern;

/**
 * Created by akshay.pokley on 6/23/2017.
 */
public class op {
    public static void main(String[] args)
    {
    final String input = "dsfsdf";
    final String gh = "443";
    final Pattern pattern = Pattern.compile("^[A-Za-z, ]++$");

    final  Pattern pattern2 = Pattern.compile("^[0-9]++$");

    if (!pattern2.matcher(gh).matches()) {
            System.out.println("Invalid Integer");
        }else {
            System.out.println("valid Integer");
        }
    if (!pattern.matcher(input).matches()) {
        System.out.println("Invalid string");
    }else {
        System.out.println("valid String");
    }
}
}

package ch01;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jun097kim on 2017-10-15.
 */
public class Q1_09_B {
    public static void main(String[] args) {
        String s1 = "waterbottle";
        String s2 = "erbottlewat";

        System.out.println(isRotation(s1, s2));
    }

    private static boolean isRotation(String s1, String s2) {
        return isSubstring(s1 + s1, s2);
    }

    private static boolean isSubstring(String s1, String s2) {
        String regex = ".*" + s2 + ".*";

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(s1);

        return m.matches();
    }
}

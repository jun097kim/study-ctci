package ch01;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by jun097kim on 2017-10-14.
 */
public class Q1_01_A {
    public static void main(String[] args) {
        String s1 = "Hello";

        System.out.println(isUnique(s1));
    }

    private static boolean isUnique(String s1) {
        return isUnique(s1.toCharArray());
    }

    private static boolean isUnique(char[] s1) {
        Set<Character> charSet = new HashSet<>();

        for (char c : s1) {
            if (!charSet.add(c)) {
                return false;
            }
        }
        return true;
    }
}

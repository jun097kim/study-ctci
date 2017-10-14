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
        Set<Character> charSet = new HashSet<>();

        for (int i = 0; i < s1.length(); i++) {
            if (!charSet.add(s1.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}

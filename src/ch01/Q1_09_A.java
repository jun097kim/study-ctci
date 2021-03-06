package ch01;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by jun097kim on 2017-10-10.
 */
public class Q1_09_A {
    public static void main(String[] args) {
        String s1 = "waterbottle";
        String s2 = "erbottlewat";

        System.out.println(isRotation(s1, s2));
    }

    private static boolean isRotation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        Queue<Character> charQueue = new LinkedList<>();
        for (int i = 0; i < s1.length(); i++) {
            charQueue.offer(s1.charAt(i));
        }

        Character peekedChar = charQueue.peek();
        boolean firstMatch = false;
        int matchedI = 0;

        for (int i = 0; i < s2.length(); i++) {
            if (firstMatch) {
                if (charQueue.poll() != s2.charAt(i)) {
                    return false;
                }
            } else if (peekedChar == s2.charAt(i)) {
                firstMatch = true;
                matchedI = i;
                charQueue.poll();
            }
        }

        for (int i = 0; i < matchedI; i++) {
            if (charQueue.poll() != s2.charAt(i)) {
                return false;
            }
        }

        return true;
    }
}

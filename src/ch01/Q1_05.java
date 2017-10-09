package ch01;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by jun097kim on 2017-10-09.
 */
public class Q1_05 {
    public static void main(String[] args) {
        String[] s1 = {"pale", "pales", "pale", "pale"};
        String[] s2 = {"ple", "pale", "bale", "bake"};

        for (int i = 0; i < s1.length; i++) {
            System.out.println(oneAway(s1[i], s2[i]));
        }
    }

    private static boolean oneAway(String s1, String s2) {
        return oneAway(s1.toCharArray(), s2.toCharArray());
    }

    private static boolean oneAway(char[] s1, char[] s2) {
        int lengthDiff = s2.length - s1.length;
        int lengthDiffAbs = Math.abs(lengthDiff);

        if (lengthDiffAbs > 1) {
            return false;
        } else if (lengthDiffAbs == 1) {
            if (lengthDiff < 0) {
                char[] tmp = s1;
                s1 = s2;
                s2 = tmp;
            }

            Queue<Character> charQueue = new LinkedList<>();

            for (char c : s1) {
                charQueue.offer(c);
            }

            Character peekedChar = charQueue.peek();
            for (char c : s2) {
                if (peekedChar == c) {
                    charQueue.poll();
                    peekedChar = charQueue.peek();

                    if (peekedChar == null) {
                        break;
                    }
                }
            }

            return charQueue.isEmpty();
        } else {
            int equalCnt = 0;

            for (int i = 0; i < s1.length; i++) {
                if (s1[i] == s2[i]) {
                    equalCnt++;
                }

                if (equalCnt < i) {
                    return false;
                }
            }

            return equalCnt == (s1.length - 1);
        }
    }
}

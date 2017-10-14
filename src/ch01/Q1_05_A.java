package ch01;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by jun097kim on 2017-10-09.
 */
public class Q1_05_A {
    public static void main(String[] args) {
        String[] s1 = {"pale", "pales", "pale", "pale"};
        String[] s2 = {"ple", "pale", "bale", "bake"};

        for (int i = 0; i < s1.length; i++) {
            System.out.println(s1[i] + "," + s2[i] + ": " + oneEditAway(s1[i], s2[i]));
        }
    }

    private static boolean oneEditAway(String first, String second) {
        // 길이가 같은 경우, 문자 교체로 같게 만들 수 있는지 확인
        // 길이 차이가 1인 경우, 문자 삽입 또는 삭제로 같게 만들 수 있는지 확인
        if (first.length() == second.length()) {
            return oneEditReplace(first, second);
        } else if (first.length() + 1 == second.length()) {
            return oneEditInsert(first, second);
        } else if (first.length() == second.length() + 1) {
            return oneEditInsert(second, first);
        }

        // 길이 차이가 1보다 큰 경우, 같게 만들 수 없음
        return false;
    }

    static boolean oneEditReplace(String s1, String s2) {
        int equalCnt = 0;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                equalCnt++;
            }

            if (equalCnt < i) {
                return false;
            }
        }

        return equalCnt == (s1.length() - 1);
    }

    static boolean oneEditInsert(String s1, String s2) {
        Queue<Character> charQueue = new LinkedList<>();
        for (int i = 0; i < s1.length(); i++) {
            charQueue.offer(s1.charAt(i));
        }

        Character peekedChar = charQueue.peek();
        for (int i = 0; i < s2.length(); i++) {
            if (peekedChar == s2.charAt(i)) {
                charQueue.poll();
                peekedChar = charQueue.peek();

                if (peekedChar == null) {
                    break;
                }
            }
        }

        return charQueue.isEmpty();
    }
}

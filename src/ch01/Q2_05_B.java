package ch01;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by jun097kim on 2017-10-22.
 */
public class Q2_05_B {
    private static int result;

    public static void main(String[] args) {
        LinkedList<Integer> digitList1 = new LinkedList<>(Arrays.asList(1, 5, 9));
        LinkedList<Integer> digitList2 = new LinkedList<>(Arrays.asList(2, 3, 6, 7));

        System.out.println(sumDigitLists(digitList1, digitList2));
    }

    private static int sumDigitLists(LinkedList<Integer> digitList1, LinkedList<Integer> digitList2) {
        int lengthDiff = digitList1.size() - digitList2.size();
        int lengthDiffAbs = Math.abs(lengthDiff);

        if (lengthDiff > 0) {
            add0Diff(digitList2, lengthDiffAbs);
        } else if (lengthDiff < 0) {
            add0Diff(digitList1, lengthDiffAbs);
        }

        result += removeFirstNode(digitList1) + removeFirstNode(digitList2);

        if (digitList1.size() == 0 && digitList2.size() == 0) {
            return result;
        }

        result *= 10;
        return sumDigitLists(digitList1, digitList2);
    }

    private static void add0Diff(LinkedList<Integer> digitList, int diff) {
        for (int i = 0; i < diff; i++) {
            digitList.addFirst(0);
        }
    }

    private static int removeFirstNode(LinkedList<Integer> digitList) {
        if (!(digitList.size() > 0)) {
            return 0;
        }

        return digitList.remove(0);
    }
}

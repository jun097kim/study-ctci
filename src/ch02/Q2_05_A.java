package ch02;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by jun097kim on 2017-10-20.
 */
public class Q2_05_A {
    private static int powerOf10 = 1;

    public static void main(String[] args) {
        LinkedList<Integer> digitList1 = new LinkedList<>(Arrays.asList(1, 5, 9));
        LinkedList<Integer> digitList2 = new LinkedList<>(Arrays.asList(2, 3, 6, 7));

        System.out.println(sumDigitLists(digitList1, digitList2));
    }

    private static int sumDigitLists(LinkedList<Integer> digitList1, LinkedList<Integer> digitList2) {
        int sumFirstNodes = (removeFirstNode(digitList1) + removeFirstNode(digitList2)) * powerOf10;
        powerOf10 *= 10;

        if (digitList1.size() == 0 && digitList2.size() == 0) {
            return sumFirstNodes;
        }

        return sumFirstNodes + sumDigitLists(digitList1, digitList2);
    }

    private static int removeFirstNode(LinkedList<Integer> digitList) {
        if (!(digitList.size() > 0)) {
            return 0;
        }

        return digitList.remove(0);
    }
}

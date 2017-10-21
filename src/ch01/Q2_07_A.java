package ch01;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by jun097kim on 2017-10-21.
 */
public class Q2_07_A {
    public static void main(String[] args) {
        LinkedList<Integer> l1 = new LinkedList<>();
        LinkedList<Integer> l2 = new LinkedList<>(Arrays.asList(9, 2));

        LinkedList<Integer> intersection = new LinkedList<>(Arrays.asList(1, 7, 3, 5, 4));

        l1.addAll(intersection);    //           1 -> 7 -> 3 -> 5 -> 4
        l2.addAll(intersection);    // 9 -> 2 -> 1 -> 7 -> 3 -> 5 -> 4

        System.out.println(findIntersection(l1, l2));
    }

    private static Integer findIntersection(LinkedList<Integer> l1, LinkedList<Integer> l2) {
        Iterator<Integer> itL1 = l1.iterator();
        Iterator<Integer> itL2 = l2.iterator();

        if (l1.size() < l2.size()) {
            nextDiff(itL2, l2.size() - l1.size());
        } else if (l1.size() > l2.size()) {
            nextDiff(itL1, l1.size() - l2.size());
        }

        while (itL1.hasNext()) {
            Integer next1 = itL1.next();
            Integer next2 = itL2.next();

            if (next1 == next2) {
                return next1;
            }
        }
        return null;
    }

    private static void nextDiff(Iterator it, int diff) {
        for (int i = 0; i < diff; i++) {
            it.next();
        }
    }
}

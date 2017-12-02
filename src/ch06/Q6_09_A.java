package ch06;

import java.util.Arrays;

public class Q6_09_A {
    public static void main(String[] args) {
        Boolean[] locker = new Boolean[101];

        toggleLocker(locker);

        for (int i = 1; i <= 100; i++) {
            if (locker[i]) {
                System.out.print(i + " ");
            }
        }
    }

    private static void toggleLocker(Boolean[] locker) {
        Arrays.fill(locker, true);
        toggleLocker(locker, 2);
    }

    private static void toggleLocker(Boolean[] locker, int multiplicand) {
        if (multiplicand > locker.length) {
            return;
        }

        for (int i = multiplicand; i < locker.length; i += multiplicand) {
            locker[i] = !locker[i];
        }

        toggleLocker(locker, multiplicand + 1);
    }
}

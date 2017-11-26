package ch06;

import java.util.Arrays;

public class Q6_09_A {
    public static void main(String[] args) {
        boolean[] flags = sieveOfEratosthenes(100);

        for (int i = 0; i < flags.length; i++) {
            if (flags[i])
                System.out.print(i + " ");
        }
    }

    static boolean[] sieveOfEratosthenes(int max) {
        boolean[] flags = new boolean[max + 1];

        init(flags);

        for (int i = 2; i <= Math.sqrt(max); i++) {
            if (flags[i]) {
                for (int j = i * 2; j <= max; j += i) {
                    flags[j] = false;
                }
            }
        }

        return flags;
    }

    static void init(boolean[] flags) {
        Arrays.fill(flags, true);
        flags[0] = false;
        flags[1] = false;
    }
}

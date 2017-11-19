package ch05;

import java.util.Scanner;

public class Q5_01_A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the N, M, i, j: ");

        int n = sc.nextInt(2);
        int m = sc.nextInt(2);
        int i = sc.nextInt();
        int j = sc.nextInt();

        sc.close();

        int inserted = updateBits(n, m, i, j);
        System.out.println(Integer.toBinaryString(inserted));
    }

    private static int updateBits(int n, int m, int i, int j) {
        int allOnes = ~0;

        int left = allOnes << (j + 1);
        int right = (1 << i) - 1;

        int mask = left | right;
        n &= mask;

        return n | (m << i);
    }
}

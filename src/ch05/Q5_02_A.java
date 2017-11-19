package ch05;

public class Q5_02_A {
    public static void main(String[] args) {
        double rNum = 0.72;

        System.out.println(printBinary(rNum));
    }

    private static String printBinary(double rNum) {
        StringBuilder binary = new StringBuilder(".");

        while (rNum != 1) {
            if (binary.length() > 32) {
                return "ERROR";
            }

            rNum *= 2;
            binary.append((int) rNum);

            if (rNum > 1) rNum -= 1;
        }

        return binary.toString();
    }
}

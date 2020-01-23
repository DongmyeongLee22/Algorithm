package cracking.bitmanipulation;

public class Insert {

    int insertBit(int N, int M, int i, int j) {
        // N = 10000, M = 101
        // i = 1, j = 3이라고 생각하자
        BitReverse.test();

        int left = (-1 << j + 1); // 11111 << 4 = 10000
        int right = (1 << i) - 1; // 00010 - 1 = 00001
        int mask = left | right; // 10001

        N = N & mask; // 10000 AND 10001 = 10000
        M = M << i; // 101 << 1 = 1010

        return N | M; // 11010
    }

    String pintBinary(double num) {
        if (num > 1 || num < 0) {
            return "ERROR";
        }

        StringBuilder binary = new StringBuilder();
        binary.append(".");

        while (num > 0) {
            if (binary.length() >= 32) {
                return "ERROR";
            }

            double r = num * 2;
            if (r > 1) {
                binary.append("1");
                num = r - 1;
            } else {
                binary.append("0");
                num = r;
            }
        }
        return binary.toString();
    }
}

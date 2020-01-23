package programmers.hash1;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int n) {

        String str = "asd";
        char[] chars = str.toCharArray();
        char i1 = (char) (chars[1] + 1);
        boolean[] decimalArr = new boolean[n + 1];

        for (int i = 2; i <= n; i++) {
            if (!decimalArr[i]) {
                makeTrueMultiples(i, n, decimalArr);
            }
        }
        int ret = 0;

        for (int i = 2; i < decimalArr.length; i++) {
            if (!decimalArr[i]) ret++;
        }

        return ret;
    }

    private void makeTrueMultiples(int i, int n, boolean[] decimalArr) {
        for (int j = 2 * i; j <= n; j += i) {
            decimalArr[j] = true;
        }
    }

    public String test(String s) {
        char[] chars = s.toCharArray();
        StringBuilder builder = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        long asd = 3;
        String s1 = Long.toString((asd));
        int index = 0;
        for (char c : chars) {
            if (c == ' ') {
                builder.append(c);
                index = 0;
            } else if (index % 2 == 0) {
                if (c >= 97) {
                    builder.append((char) (c - 32));
                } else {
                    builder.append(c);
                }
                index++;
            } else {
                if (c < 97) {
                    builder.append((char) (c + 32));
                } else {
                    builder.append(c);
                }
                index++;
            }
        }

        return builder.toString();
    }
}
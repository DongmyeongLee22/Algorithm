package programmers.hash1;

public class DartGame {

    class Solution {
        public int solution(String dartResult) {

            char[] chars = dartResult.toCharArray();

            int sum = 0;
            int last = 0;
            int cur = 0;

            for (int i = 0; i < dartResult.length(); i++) {
                if (chars[i] >= 'A' && chars[i] <= 'Z') {
                    cur = makeMultiple(cur, chars[i]);

                    if ((i == dartResult.length() - 1) || chars[i + 1] != '#' && chars[i + 1] != '*') {
                        sum += cur;
                        last = cur;
                    }

                } else if (chars[i] == '#' || chars[i] == '*') {
                    if (chars[i] == '#') {
                        cur = -cur;
                        sum += cur;
                        last = cur;
                    } else {
                        sum += last + cur * 2;
                        last = cur * 2;
                    }
                } else {
                    cur = chars[i] - '0'; // 숫자
                    if (cur == 1 && chars[i + 1] == '0') {
                        cur = 10;
                        i++;
                    }
                }
            }

            return sum;
        }

        private int makeMultiple(int cur, char aChar) {
            if (aChar == 'S') return cur;

            if (aChar == 'D') return cur * cur;

            return cur * cur * cur;
        }
    }
}
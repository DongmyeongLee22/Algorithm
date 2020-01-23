package programmers.lv2;

import java.util.HashSet;
import java.util.concurrent.atomic.AtomicInteger;

public class FindDecimal {


    public int solution(String numbers) {
        // 7개의 숫자
        // 0 ~ 9
        // 최대 9999999
        final int DECIMAL_SIZE = 10000000;
        boolean[] decimalArr = new boolean[DECIMAL_SIZE];
        makeDecimalArr(decimalArr);

        int[] count = new int[1];

        HashSet<Integer> set = new HashSet<>();
        permutation("", numbers, set);

        set.forEach(i -> {
            if (!decimalArr[i]) {
                decimalArr[i] = true;
                count[0]++;
            }
        });
        return count[0];
    }

    private void permutation(String prefix, String numbers, HashSet<Integer> set) {
        if (!prefix.equals("")) set.add(Integer.parseInt(prefix));

        int n = numbers.length();

        for (int i = 0; i < n; i++) {
            permutation(prefix + numbers.charAt(i),
                    numbers.substring(0, i) +
                            numbers.substring(i + 1, n), set);
        }
    }


    private void makeDecimalArr(boolean[] decimalArr) {
        decimalArr[1] = true;
        decimalArr[0] = true;
        for (int i = 2; i < decimalArr.length; i++) {
            if (!decimalArr[i]) {
                setDecimalArr(decimalArr, i);
            }
        }
    }

    private void setDecimalArr(boolean[] decimalArr, int i) {
        for (int j = i * 2; j < decimalArr.length; j += i) {
            decimalArr[j] = true;
        }
    }

}

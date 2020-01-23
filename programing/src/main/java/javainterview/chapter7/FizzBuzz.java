package javainterview.chapter7;


import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FizzBuzz {

    public List<String> makeFizzBuzz(int n) {
        List<String> ret = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String word = isFizzBuzz(3, i, "Fizz") + isFizzBuzz(5, i, "Buzz");

            if (word.equals("")) {
                ret.add(Integer.toString(i));
            } else {
                ret.add(word);
            }
        }

        return ret;
    }

    private String isFizzBuzz(int divisor, int number, String str) {
        return number % divisor == 0 ? str : "";
    }

    public int[] fibo(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("숫자는 0보다 커야합니다.");
        }

        if (n == 0) {
            return new int[]{};
        }

        if (n == 1) {
            return new int[]{0};
        }

        if (n == 2) {
            return new int[]{0, 1};
        }

        int[] ret = new int[n];
        ret[0] = 0;
        ret[1] = 1;

        for (int i = 2; i < n; i++) {
            ret[i] = ret[i - 1] + ret[i - 2];
        }

        return ret;
    }

    public int fiboRecursion(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("숫자는 0보다 커야합니다.");
        }
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fiboRecursion(n - 1) + fiboRecursion(n - 2);
    }

    public int fiboDinamic(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("숫자는 0보다 커야합니다.");
        }
        if (n == 0) return 0;
        if (n == 1) return 1;
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }

    public int fiboBest(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("숫자는 0보다 커야합니다.");
        }
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 0;
        }
        int left = 0;
        int right = 1;
        int ret = 1;
        for (int i = 2; i <= n; i++) {
            ret = left + right;
            left = right;
            right = ret;
        }
        return ret;
    }

    int facto(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("숫자는 0보다 커야합니다.");
        }

        if (n == 0) {
            return 0;
        }


        int ret = 1;
        for (int i = 1; i <= n; i++) {
            ret = ret * i;
        }

        return ret;
    }

String reverse(String s){
    StringBuilder builder = new StringBuilder(s);
    // a b c d e len = 5 -> 2
    // a b c d len = 4  -> 2
    for(int i = 0 ; i < builder.length() / 2; i++){
        char temp = builder.charAt(i);
        char other = builder.charAt(builder.length() - 1 - i);

        builder.setCharAt(i, other);
        builder.setCharAt(builder.length() - 1 - i, temp);
    }

    return builder.toString();
}
}


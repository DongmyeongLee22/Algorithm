import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    public String solution(String s) {
        int length = s.length();

        int [] arr = new int[1];
        if (length % 2 == 0) {
            return s.charAt(length / 2 - 1) + String.valueOf(s.charAt(length / 2));
        } else {
            int sum = IntStream.rangeClosed(-10, 5).sum();
            System.out.println(sum);
            return String.valueOf(s.charAt(length / 2));
        }
    }
}
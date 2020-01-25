package programmers.lv1;

import java.util.Arrays;
import java.util.stream.Stream;

public class Pro1 {
    public boolean solution(String s) {
        int length = s.length();
        if (length != 4 && length != 6) return false;

        for(char c : s.toCharArray()){
            if (c <= '0' || c >= '9') return false;
        }

        return true;

    }

    public long solution(long n) {
        String s = String.valueOf(n);
        StringBuilder builder = new StringBuilder();
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        for (int i = chars.length - 1; i >= 0; i--) {
            builder.append(chars[i]);
        }
        return Long.parseLong(builder.toString());
    }
}

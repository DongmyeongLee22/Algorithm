package programmers.lv2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Ka2020OpenClose2 {

    public String solution(String p) {
        if (isPerfect(p)) return p;

        return String.valueOf(replaceAnswer(p));
    }


    public String replaceAnswer(String str) {

        // 1
        if (str.length() == 0) return str;

        // 2
        UVChars uvChars = divideString(str);

        // 3
        if (isPerfect(uvChars.u)) return uvChars.u + replaceAnswer(uvChars.v);

        // 4
        String left = replaceAnswer(uvChars.v);
        String right = deleteFirstAndLast(uvChars.u);

        return '(' + left + ')' + right;
    }

    // OK
    public boolean isPerfect(String str) {

        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == ')') {
                if (stack.isEmpty() || stack.peek() != '(') return false;
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return true;
    }


    // OK
    private String deleteFirstAndLast(String str) {
        if (str.length() == 2) return "";

        char[] ret = new char[str.length() - 2];

        for (int i = 0; i < str.length() - 2; i++) {
            char aChar = str.charAt(i + 1);
            System.out.println(aChar);
            if (aChar ==')') ret[i] = '(';
            if (aChar == '(') ret[i] = ')';
        }

        return String.valueOf(ret);
    }

    // 2 OK
    private UVChars divideString(String str) {
        // u는 분리가 불가능한 균형
        // v는 빈칸 허용

        int openCount = 0, closeCount = 0, index = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(index++);
            if (c == '(') {
                openCount++;
            } else {
                closeCount++;
            }
            if (openCount == closeCount) break;
        }


        return new UVChars(str.substring(0, index), str.substring(index));
    }

    class UVChars {

        String u;
        String v;

        public UVChars(String u, String v) {
            this.u = u;
            this.v = v;
        }
    }
}

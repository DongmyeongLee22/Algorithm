package programmers.lv2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Ka2020OpenClose {

    public String solution(String p) {
        if (isPerfect(p.toCharArray())) return p;

        return String.valueOf(replaceAnswer(p.toCharArray()));
    }


    // OK
    public boolean isPerfect(char[] chars) {

        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            if (c == ')') {
                if (stack.isEmpty() || stack.peek() != '(') return false;
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return true;
    }

    public char[] replaceAnswer(char[] chars) {

        // 1
        if (chars.length == 0) return chars;

        // 2
        UVChars uvChars = divideString(chars);

        // 3
        if (isPerfect(uvChars.u)) return concatTowChars(uvChars.u, replaceAnswer(uvChars.v));

        // 4
        List<Character> ret = new ArrayList<>();

        // 4-1
        ret.add('(');

        // 4-2
        char[] vRevursion = replaceAnswer(uvChars.v);
        addCharsToList(ret, vRevursion);

        // 4-3
        ret.add(')');

        // 4-4
        char[] listChars = deleteFirstAndLast(uvChars.u);

        addCharsToList(ret, listChars);

        return makeCharsByList(ret);
    }


    // OK
    private char[] deleteFirstAndLast(char[] chars) {
        if (chars.length == 2) return new char[0];

        char[] ret = new char[chars.length - 2];

        for (int i = 0; i < chars.length - 2; i++) {
            char aChar = chars[i + 1];
            System.out.println(aChar);
            if (aChar ==')') ret[i] = '(';
            if (aChar == '(') ret[i] = ')';
        }

        return ret;
    }

    // oK
    private void addCharsToList(List<Character> ret, char[] chars) {
        for (char aChar : chars) {
            ret.add(aChar);
        }
    }

    // 3 OK
    private char[] concatTowChars(char[] leftChars, char[] rightChars) {
        char[] ret = new char[leftChars.length + rightChars.length];
        int index = 0;
        for (char c : leftChars) {
            ret[index++] = c;
        }
        for (char c : rightChars) {
            ret[index++] = c;
        }
        return ret;
    }

    // 2 OK
    private UVChars divideString(char[] chars) {
        // u는 분리가 불가능한 균형
        // v는 빈칸 허용

        List<Character> uList = new ArrayList<>();

        int openCount = 0, closeCount = 0, index = 0;

        for (int i = 0; i < chars.length; i++) {
            char c = chars[index++];
            uList.add(c);
            if (c == '(') {
                openCount++;
            } else {
                closeCount++;
            }
            if (openCount == closeCount) break;
        }

        char[] v, u;

        if (index == chars.length) {
            v = new char[0];
            u = chars;
        } else {
            v = makeCharsFromIndex(chars, index);
            u = makeCharsByList(uList);
        }

        return new UVChars(u, v);
    }

    private char[] makeCharsFromIndex(char[] chars, int index) {
        char[] ret = new char[chars.length - index];
        for (int i = 0; i < chars.length - index; i++) {
            ret[i] = chars[index + i];
        }
        return ret;
    }

    private char[] makeCharsByList(List<Character> uList) {
        char[] ret = new char[uList.size()];
        for (int i = 0; i < uList.size(); i++) {
            ret[i] = uList.get(i);
        }
        return ret;
    }

    class UVChars {

        char[] u;
        char[] v;

        public UVChars(char[] u, char[] v) {
            this.u = u;
            this.v = v;
        }
    }
}

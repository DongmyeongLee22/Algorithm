package programmers.lv2;

import java.util.Stack;

public class RightBracket {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                if (stack.isEmpty() || stack.peek() == ')') return false;
                stack.pop();
                continue;
            }
            stack.push(c);
        }
        if (!stack.isEmpty() && stack.pop() == '(') return false;
        stack.clear();
        return true;
    }
}

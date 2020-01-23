package programmers.lv2;

import java.util.Stack;

public class IronRod {
    public int solution(String arrangement) {
        char[] chars = arrangement.toCharArray();
        int answer = 0;


        // ( ) ( ( ( ( ) ( ) ) ( ( ) ) ( ) ) ) ( ( ) )
        Stack<Character> stack = new Stack<>();

        stack.push(chars[0]);

        boolean isLast = chars[0] == '(';
        int openCount = isLast ? 1 : 0;

        for (int i = 1; i < arrangement.length(); i++) {

            if ( chars[i] == ')'){
                if (stack.peek() == '('){
                    openCount--;
                    answer += openCount;
                }else{
                    answer++;
                    openCount--;
                }
            }else{ // (
                openCount++;
            }

            stack.push(chars[i]);
        }

        return answer;
    }
}

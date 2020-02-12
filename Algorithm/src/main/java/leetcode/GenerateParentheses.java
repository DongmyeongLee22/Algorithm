package leetcode;
import java.util.*;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<>();
        back(ret, new StringBuilder(), 0, 0, n);
        return ret;
    }

    private void back(List<String> ret, StringBuilder b, int open, int close, int max){
        if(open == max && close == max){
            ret.add(b.toString());
        }else{
            if(open < max){
                b.append('(');
                back(ret, b, open + 1, close, max);
                b.deleteCharAt(b.length() - 1);
            }

            if(open > close){
                b.append(')');
                back(ret, b, open, close + 1, max);
                b.deleteCharAt(b.length() - 1);
            }
        }
    }
}

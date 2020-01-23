package programmers.lv2;

import java.util.HashSet;
import java.util.Set;

public class EndingGame {
    public int[] solution(int n, String[] words) {

        Set<String> set = new HashSet<>();
        int member = 1, turn = 1;
        String lastStr = words[0];
        set.add(lastStr);

        for (int i = 1; i < words.length; i++) {
            String curStr = words[i];
            int length = lastStr.length();

            member = member == n ? 1 : member + 1;
            turn++;

            if (!lastStr.substring(length - 1, length)
                    .equals(curStr.substring(0, 1))) break;
            if (set.contains(curStr)) break;
            set.add(curStr);
            lastStr = curStr;
        }

        if (lastStr.equals(words[words.length-1])) return new int[]{0,0};

        return new int[]{member, ((turn-1) / n) + 1};
    }
}

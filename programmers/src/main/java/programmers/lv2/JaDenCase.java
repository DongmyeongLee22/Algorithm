package programmers.lv2;

import java.util.stream.Stream;

public class JaDenCase {
    public String solution(String s) {
        String[] strArr = s.split(" ");

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < strArr.length; i++) {
            for (int j = 0; j < strArr[i].length(); j++) {
                if (j == 0) {
                    builder.append(Character.toString(strArr[i].charAt(j)).toUpperCase());
                    // Character.toUpperCase(words[i].charAt(j));
                } else {
                    builder.append(Character.toString(strArr[i].charAt(j)).toLowerCase());
                }
            }

            if (i != strArr.length - 1) builder.append(" ");

        }

        for (int i = 0; i < strArr.length; i++) {
            String cur = strArr[i];
            builder.append(cur.substring(0, 1).toUpperCase()).append(cur.substring(1).toLowerCase());
            if (i != strArr.length - 1) builder.append(" ");
        }

        if (s.charAt(s.length() - 1) == ' ') builder.append(" ");

        return builder.toString();
    }

    public String sol(String s){
        char[] chars = s.toLowerCase().toCharArray();
        StringBuilder builder = new StringBuilder();
        boolean flag = false;

        for (char aChar : chars) {
            builder.append(flag ? Character.toString(aChar).toUpperCase() : aChar);
            if (aChar == ' ') flag = true;
        }

        return builder.toString();
    }
}

package programmers.lv2;

import java.util.Arrays;

public class BigNumber {
    public String solution(int[] numbers) {

        String [] strings = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++){
            strings[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(strings,(a, b) -> (b+a).compareTo(a+b));

        if (strings[0].equals("0")) return "0";

        StringBuilder builder = new StringBuilder();

        for (String string : strings) {
            builder.append(string);
        }

        return builder.toString();
    }

}

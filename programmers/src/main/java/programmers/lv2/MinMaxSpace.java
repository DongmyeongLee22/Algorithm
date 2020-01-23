package programmers.lv2;

public class MinMaxSpace {
    public String solution(String s) {
        String[] strArr = s.split(" ");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i = 0 ; i < strArr.length; i++){
            int number = Integer.parseInt(strArr[i]);
            if (min > number) min = number;
            if (max < number) max = number;
        }

        return min + " " + max;
    }
}

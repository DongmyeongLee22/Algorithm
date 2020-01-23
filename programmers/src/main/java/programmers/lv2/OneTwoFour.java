package programmers.lv2;

public class OneTwoFour {
    public String solution(int n) {
        StringBuilder builder = new StringBuilder();
        int mod = 0;

        char[] val = {'4', '1', '2'};

        while (n > 0) {
            mod = n % 3;
            builder.append(val[mod]);
            n = (n-1)/3;

        }

        return builder.reverse().toString();
    }

}

package programmers.lv2;

public class Fibo123456 {
    public int solution(int n) {
        final int DIVIDE = 123456;

        if(n == 0) return 0;

        long left = 0, temp = 0, right = 1;
        for(int i = 2; i <= n; i++){
            temp = right;
            right = (left + right) % DIVIDE;
            left = temp;
        }
        return (int) (right % DIVIDE);
    }
}

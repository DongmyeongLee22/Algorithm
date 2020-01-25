package programmers.lv2;

public class SequenceNum {
    public int solution(int n) {
        int answer = 0;
        int num = n;
        while (n != 0) {
            if (isRight(n, num)) answer++;
            n--;
        }
        return answer;
    }

    private boolean isRight(int n, int target) {
        int val = n;
        while (n != 0) {
            if (val == target) return true;
            if (val > target) return false;
            n--;
            val += n;
        }
        return false;
    }
}

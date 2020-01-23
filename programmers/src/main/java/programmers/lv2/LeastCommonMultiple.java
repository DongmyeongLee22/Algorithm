package programmers.lv2;

public class LeastCommonMultiple {
    // 2 6 8 14

    // 최소 = 두수곱 / 최대공
    public int solution(int[] arr) {
        int answer = (arr[0] * arr[1]) / getGcd(arr[0], arr[1]);
        for (int i = 2; i < arr.length; i++){
            answer = (answer * arr[i]) / getGcd(answer, arr[i]);
        }
        return answer;
    }

    private int getGcd(int a, int b){
        int mod = a % b;

        return mod == 0 ? b : getGcd(b, mod);
    }
}

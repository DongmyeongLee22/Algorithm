package programmers.lv2;

// 멀쩡한 사각형
public class Square {
    public long solution(int w,int h) {
        long answer = w * h;
        long gcd = getGcd(w, h);

        return answer - (((w / gcd) + (h / gcd) -1) * gcd);
    }

    private long getGcd(int w, int h) {

        int mod = w % h;

        if (mod != 0){
            return getGcd(h, mod);
        }

        return h;
    }
}

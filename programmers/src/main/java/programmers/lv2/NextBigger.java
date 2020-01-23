package programmers.lv2;

public class NextBigger {
    // 1 1 1 0 1 0 0 1
    // 1 1 1 0 1 0 1 0
    // 가장 첫번째 1을 찾는다
    // 그 다음에 1을 넣는다.

    public int solution(int n) {
        int temp = n;
        int oneCount = 0;


        // 0 1 1 0 1 1 1 0
        while ((temp & 1) != 1) {
            temp >>= 1;
            oneCount++; // 1
        }

        int zeroCount = oneCount;

        while ((temp & 1) != 0){
            temp >>= 1;
            zeroCount++; // 4
        }

        int oneSize = zeroCount - oneCount - 1;

        n &= -(1 << zeroCount);

        int pattern = (1 << zeroCount) | (1 << oneSize) -1;

        return n | pattern;
    }
}

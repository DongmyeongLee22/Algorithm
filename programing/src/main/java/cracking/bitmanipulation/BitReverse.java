package cracking.bitmanipulation;

import java.util.ArrayList;
import java.util.List;

public class BitReverse {

    private final int BIT_LENGTH = Integer.BYTES * 8;

    int revers(int bit) {
        if (bit == -1) return BIT_LENGTH;
        List<Integer> list = getZeroOneList(bit);
        return findLongestBit(list);
    }

    private List<Integer> getZeroOneList(int bit) {
        List<Integer> ret = new ArrayList<>();
        int count = 0;
        int OneOrZero = 0;
        for (int i = 0; i < BIT_LENGTH; i++) {
            if ((bit & 1) != OneOrZero) {
                ret.add(count);
                count = 0;
                OneOrZero = bit & 1;
            }
            count++;
            bit >>>= 1;
        }
        ret.add(count);
        return ret;
    }

    public static void test(){
    }
    private int findLongestBit(List<Integer> list) {

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < list.size(); i += 2) {

            int zerosLen = list.get(i);
            int leftOne = i > 0 ? list.get(i - 1) : 0;
            int rightOne = i < list.size() - 1 ? list.get(i + 1) : 0;

            int now = 0;
            if (zerosLen == 1) {
                now = leftOne + 1 + rightOne;
            } else if (zerosLen > 1) {
                now = 1 + Math.max(leftOne, rightOne);
            } else if (zerosLen == 0) {
                now = Math.min(leftOne, rightOne);
            }

            max = Math.max(now, max);
        }

        return max;
    }

    int bestPractice(int bit) {
        if ((~bit) == 0) return BIT_LENGTH;
        int max = 0;
        int curCount = 0, prevCount = 0;

        while (bit != 0) {
            if ((bit & 1) == 1) {
                curCount++;
            } else {
                prevCount = (bit & 2) == 0 ? 0 : curCount;
                curCount = 0;
            }

            max = Math.max(max, curCount + prevCount + 1);
            bit >>>= 1;
        }
        return max;
    }
}

package programmers.lv2;

import java.util.Arrays;

public class MakeDecimal {
    public int solution(int[] nums) {
        int answer = 0;
        int count = 0;
        final int DECIMAL_SIZE = 1001;

        // false는 소수이다.
        // true는 소수가 아니다.
        boolean[] decimalArr = new boolean[DECIMAL_SIZE];

        makeDecimalArr(decimalArr);

        for (int i = 0; i < nums.length - 2; i++) {
            int left = nums[i];
            for (int j = i + 1; j < nums.length - 1; j++) {
                int twoSum = left + nums[j];
                for (int z = j + 1; z < nums.length ; z++) {
                    System.out.println(nums[i] + " " + nums[j] + " " + nums[z]);
                    if (!decimalArr[twoSum + nums[z]]) answer++;
                }
            }
        }

        return answer;
    }

    private void makeDecimalArr(boolean[] decimalArr) {
        for (int i = 2; i < decimalArr.length; i++) {
            if (!decimalArr[i]) {
                setDecimalArr(decimalArr, i);
            }
        }
    }

    private void setDecimalArr(boolean[] decimalArr, int i) {
        for (int j = i * 2; j < decimalArr.length; j += i) {
            decimalArr[j] = true;
        }
    }
}

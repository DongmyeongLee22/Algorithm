package leetcode;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    class Solution {
        public int lengthOfLIS(int[] nums) {
            if (nums.length == 0) return 0;

            int[] d = new int[nums.length];

            int ret = 0;

            // 10 2 3 7 5
            // -1 --> index = 0, ret = 1;
            // d[0] -> 10
            // -1 --> index = 0. ret = 1;
            // d[0] -> 2
            // -2 --> index = 1, ret = 2;
            // d[1] -> 3
            // -3 --> index = 2, ret = 3;
            // d[2] -> 7
            // d = 2, 3, 7
            // -3 --> index = 2, ret = 3;
            // d[2] -> 5

            /**
             * 시간복잡도 nlogn, 공간복잡도 n
             * binarySearch 이용
             */
            for (int num : nums) {
                int index = Arrays.binarySearch(d, 0, ret, num);

                if (index < 0) index = -(index + 1);

                if (index == ret) ret += 1;

                d[index] = num;
            }

        /*
        시간복잡도 n^2 공간복잡도 n
        d[0] = 1;

        // 1 1 1 2
        // 1 1 1 2 2 3 4 4
        int ret = d[0];
        for(int i = 1; i < nums.length; i++){
            int max = 0;
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i] && d[j] > max) max = d[j];
            }
            d[i] = max + 1;
            ret = Math.max(ret, d[i]);
        }
        */

            return ret;
        }
    }
}

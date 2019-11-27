package com.company.leetcode;

public class MaximumProductSubarray {
    class Solution {
        public int maxProduct(int[] nums) {
            int[][] ret = new int[nums.length][2];
            ret[0][0] = nums[0];
            ret[0][1] = nums[0];

            for (int i = 1; i < nums.length; i++) {

                int cur = nums[i];

                ret[i][0] = Math.max(cur, Math.max(cur * ret[i - 1][0], cur * ret[i - 1][1]));
                ret[i][1] = Math.min(cur, Math.min(cur * ret[i - 1][0], cur * ret[i - 1][1]));

            }

            int max = ret[0][0];

            for (int i = 1; i < nums.length; i++) {
                if (ret[i][0] > max) max = ret[i][0];
            }

            return max;

        }
    }
}

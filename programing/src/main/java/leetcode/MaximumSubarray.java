package leetcode;

public class MaximumSubarray {
    class Solution {
        public int maxSubArray(int[] nums) {
            int [] d = new int [nums.length];

            d[0] = nums[0];
            // -2, 1, -3, 4, -1, 2, 1, -5, 4
            // -2, 1, -2, 4, 3, 5, 6, 1, 5
            for(int i = 1; i < nums.length; i++){
                d[i] = Math.max(nums[i], nums[i] + d[i-1]);
            }

            int max = d[0];

            for(int i = 1; i < nums.length; i++){
                if(max < d[i]) max = d[i];
            }

            return max;
        }
    }
}

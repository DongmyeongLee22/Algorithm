package com.company.leetcode;

public class NextPermutation {
    class Solution {
        public void nextPermutation(int[] nums) {
            if (nums.length == 1 || nums.length == 0) return;

            int a = nums.length - 2;
            while (a >= 0 && nums[a] >= nums[a + 1]) a--;


            if (a != -1) {
                int b = nums.length - 1;
                while (nums[b] <= nums[a]) b--;
                swap(nums, a, b);
            }

            int start = a + 1;
            int end = nums.length - 1;
            while (start < end) {
                swap(nums, start++, end--);
            }

        }

        public void swap(int[] nums, int a, int b) {
            int temp = nums[a];
            nums[a] = nums[b];
            nums[b] = temp;
        }
    }
}

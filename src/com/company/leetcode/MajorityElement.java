package com.company.leetcode;

public class MajorityElement {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.majorityElement(new int[]{1, 1, 2, 3, 1, 2, 3, 2, 3, 3, 3, 3});
    }

    static class Solution {
        public int majorityElement(int[] nums) {
            int cnt = 0;
            int x = 0;

            for (int num : nums) {
                if (cnt == 0) {
                    x = num;
                    cnt++;
                } else if (num == x) cnt++;
                else cnt--;
            }

            return x;
        }
    }
}

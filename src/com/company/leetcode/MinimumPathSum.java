package com.company.leetcode;

public class MinimumPathSum {
    public static void main(String[] args) {
        int grid[][] = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };

        Solution solution = new Solution();
        solution.minPathSum(grid);


    }

    static class Solution {
        public int minPathSum(int[][] grid) {

            int[][] ret = new int[grid.length][grid[0].length];

            ret[0][0] = grid[0][0];

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {

                    if (i == 0 && j == 0) continue;

                    int up = (i > 0) ? ret[i - 1][j] : Integer.MAX_VALUE;
                    int left = (j > 0) ? ret[i][j - 1] : Integer.MAX_VALUE;

                    ret[i][j] = grid[i][j] + Math.min(left, up);

                }
            }

            return ret[grid.length - 1][grid[0].length - 1];
        }
    }
}

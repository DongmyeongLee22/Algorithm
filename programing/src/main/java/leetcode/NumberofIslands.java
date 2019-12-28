package leetcode;

import java.util.HashMap;
import java.util.Map;

public class NumberofIslands {
    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();

        String s = "KEY";

        map.put(s, map.getOrDefault(s, 1) + 1);
        map.put(s, map.get(s) + 1);

        System.out.println(map.get(s));

    }

    static class Solution {
        public int numIslands(char[][] grid) {

            int count = 0;

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == '1') {
                        count++;
                        countIsland(grid, i, j);
                    }
                }
            }

            return count;
        }

        public void countIsland(char[][] grid, int i, int j) {

            grid[i][j] = 'o';

            if (j < grid[0].length - 1 && grid[i][j + 1] == '1') countIsland(grid, i, j + 1);
            if (j > 0 && grid[i][j - 1] == '1') countIsland(grid, i, j - 1);
            if (i < grid.length - 1 && grid[i + 1][j] == '1') countIsland(grid, i + 1, j);
            if (i > 0 && grid[i - 1][j] == '1') countIsland(grid, i - 1, j);

        }
    }
}

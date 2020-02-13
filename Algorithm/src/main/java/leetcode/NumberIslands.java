package leetcode;

public class NumberIslands {
    private final char VISITED = '0';

    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == VISITED) continue;
                checkIslands(grid, i, j);
                count++;
            }
        }
        return count;
    }

    private void checkIslands(char[][] grid, int row, int col) {
        if (grid[row][col] == VISITED) return;
        grid[row][col] = VISITED;

        char UN_VISITED = '1';
        if (row > 0 && grid[row - 1][col] == UN_VISITED) checkIslands(grid, row - 1, col);
        if (row < grid.length - 1 && grid[row + 1][col] == UN_VISITED) checkIslands(grid, row + 1, col);
        if (col > 0 && grid[row][col - 1] == UN_VISITED) checkIslands(grid, row, col - 1);
        if (col < grid[0].length - 1 && grid[row][col + 1] == UN_VISITED) checkIslands(grid, row, col + 1);
    }

}

package leetcode;

public class MinPathSum {
    public int minPathSum(int[][] grid) {
        int[][] d = new int[grid.length][grid[0].length];

        d[0][0] = grid[0][0];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(i == 0 && j == 0) continue;

                if(i == 0){
                    d[i][j] = d[i][j-1] + grid[i][j];
                }else if(j == 0){
                    d[i][j] = d[i-1][j] + grid[i][j];
                }else{
                    d[i][j] = Math.min(d[i-1][j], d[i][j-1]) + grid[i][j];
                }
            }
        }

        return d[grid.length - 1][grid[0].length - 1];
    }
}

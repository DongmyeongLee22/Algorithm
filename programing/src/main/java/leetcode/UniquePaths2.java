package leetcode;

public class UniquePaths2 {
    class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int [][] o = obstacleGrid;
            int [][] d = new int [o.length][o[0].length];
            if(o[0][0] == 1) return 0;
            d[0][0] = 1;

            for(int i = 0; i < o.length; i++){
                for(int j = 0; j < o[0].length; j++){
                    if(o[i][j] == 1){
                        d[i][j] = 0;
                    }else{
                        if(i > 0)d[i][j] += d[i - 1][j];
                        if(j > 0)d[i][j] += d[i][j - 1];
                    }
                }
            }

            return d[o.length - 1][o[0].length - 1];

        }
    }
}

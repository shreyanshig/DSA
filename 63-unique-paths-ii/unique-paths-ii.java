class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid)
    {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1 || obstacleGrid[n-1][m-1] == 1)
            return 0;
        int dp[][] = new int[n][m];
        dp[n-1][m-1] = 1;
        for(int row=n-1; row>=0; row--){
            for(int col=m-1; col>=0; col--){
                if(row == n-1 && col == m-1)
                    continue;
                int right = 0;
                if(col + 1 < m && obstacleGrid[row][col+1] == 0)
                    right = dp[row][col+1];
                int down = 0;
                if(row + 1 < n && obstacleGrid[row+1][col] == 0)
                    down = dp[row+1][col];
                dp[row][col] = right + down;
            }
        }
        return dp[0][0];
    }
}
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid)
    {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int dp[][] = new int[n][m];
        for(int row=0; row<n; row++){
            for(int col=0; col<m; col++){
                if(obstacleGrid[row][col] == 1)
                    dp[row][col] = 0;
                else if(row == 0 && col == 0)
                    dp[row][col] = 1;
                else{
                    int left = 0;
                    if(col-1 >= 0)
                        left = dp[row][col-1];
                    int up = 0;
                    if(row-1 >= 0)
                        up = dp[row-1][col];
                    dp[row][col] = left + up;
                }
            }
        }
        return dp[n-1][m-1];
    }
}
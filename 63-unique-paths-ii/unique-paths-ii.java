class Solution {
    public int dfs(int obstacleGrid[][], int row, int col, int n, int m, int dp[][])
    {
        if(row == n-1 && col == m-1)
            return 1;
        if(dp[row][col] != -1)
            return dp[row][col];
        int right = 0;
        if(col + 1 < m && obstacleGrid[row][col+1] == 0)
            right = dfs(obstacleGrid, row, col+1, n, m, dp);
        int down = 0;
        if(row + 1 < n && obstacleGrid[row+1][col] == 0)
            down = dfs(obstacleGrid, row+1, col, n, m, dp);
        dp[row][col] = right + down;
        return right + down;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid)
    {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1 || obstacleGrid[n-1][m-1] == 1)
            return 0;
        int dp[][] = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                dp[i][j] = -1;
            }
        }
        int a = dfs(obstacleGrid, 0, 0, n, m, dp);
        return a;
    }
}
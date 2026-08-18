class Solution {
    public int dfs(int grid[][], int row, int col, int n, int m, int dp[][])
    {
        if(row == n-1 && col == m-1)
            return grid[row][col];
        if(dp[row][col] != -1)
            return dp[row][col];
        int right = (int)1e9;
        if(col+1 < m)
            right = dfs(grid, row, col+1, n, m, dp);
        int down = (int)1e9;
        if(row+1 < n)
            down = dfs(grid, row+1, col, n, m, dp);
        dp[row][col] = grid[row][col] + Math.min(right, down);
        return grid[row][col] + Math.min(right, down);   
    }
    public int minPathSum(int[][] grid)
    {
        int dp[][] = new int[grid.length][grid[0].length];
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                dp[i][j] = -1;
            }
        }
        int a = dfs(grid, 0, 0, grid.length, grid[0].length, dp);
        return a;
    }
}
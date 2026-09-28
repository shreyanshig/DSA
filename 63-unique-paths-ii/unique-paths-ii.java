class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid)
    {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int prev[] = new int[m];
        for(int row=0; row<n; row++){
            int current[] = new int[m];
            for(int col=0; col<m; col++){
                if(obstacleGrid[row][col] == 1)
                    current[col] = 0;
                else if(row == 0 && col == 0)
                    current[col] = 1;
                else{
                    int left = 0;
                    if(col-1 >= 0)
                        left = current[col-1];
                    int up = 0;
                    if(row-1 >= 0)
                        up = prev[col];
                    current[col] = left + up;
                }
            }
            prev = current;
        }
        return prev[m-1];
    }
}
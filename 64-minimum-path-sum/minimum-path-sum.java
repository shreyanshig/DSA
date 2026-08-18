class Solution {
    public int minPathSum(int[][] grid)
    {
        int n = grid.length;
        int m = grid[0].length;
        int prev[] = new int[m];
        for(int i=0; i<n; i++){
            int temp[] = new int[m];
            for(int j=0; j<m; j++){
                if(i == 0 && j == 0)
                    temp[j] = grid[i][j];
                else{
                    int left = (int)1e9;
                    int up = (int)1e9;
                    if(j-1 >= 0)
                        left = grid[i][j] + temp[j-1];
                    if(i-1 >= 0)
                        up = grid[i][j] + prev[j];
                    temp[j] = Math.min(left, up);
                }
            }
            prev = temp;
        }
        return prev[m-1];
    }
}
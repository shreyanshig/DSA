class Solution {
    public int dfs(int i, int j, int piles[], int dp[][])
    {
        if(i >= j)
            return 0;
        if(dp[i][j] != -1)
            return dp[i][j];
        int takeFirst = piles[i] + Math.min(dfs(i+2, j, piles, dp), dfs(i+1, j-1, piles, dp));
        int takeLast = piles[j] + Math.min(dfs(i, j-2, piles, dp), dfs(i+1, j-1, piles, dp));
        dp[i][j] = Math.max(takeFirst, takeLast);
        return Math.max(takeFirst, takeLast);
    }
    public boolean stoneGame(int[] piles)
    {
        int dp[][] = new int[piles.length][piles.length];
        for(int i=0; i<piles.length; i++){
            for(int j=0; j<piles.length; j++){
                dp[i][j] = -1;
            }
        }
        int result = dfs(0, piles.length-1, piles, dp);
        int sum = 0;
        for(int i=0; i<piles.length; i++){
            sum += piles[i];
        }
        if(result > sum - result)
            return true;
        return false;
    }
}
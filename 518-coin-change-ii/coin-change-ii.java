class Solution {
    public int dfs(int coins[], int ind, int amt, int dp[][])
    {
        if(ind < 0)
            return 0;
        if(amt <= 0){
            if(amt == 0)
                return 1;
            return 0;
        }
        if(dp[ind][amt] != -1)
            return dp[ind][amt];
        int notTake = dfs(coins, ind-1, amt, dp);
        int take = dfs(coins, ind, amt-coins[ind], dp);
        dp[ind][amt] = notTake + take;
        return notTake + take;
    }
    public int change(int amount, int[] coins)
    {
        int n = coins.length;
        int dp[][] = new int[n][amount+1];
        for(int i=0; i<n; i++){
            for(int j=0; j<amount+1; j++){
                dp[i][j] = -1;
            }
        }
        int a = dfs(coins, n-1, amount, dp);
        return a;
    }
}
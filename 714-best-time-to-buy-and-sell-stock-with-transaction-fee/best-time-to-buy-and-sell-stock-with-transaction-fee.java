class Solution {
    public int dfs(int prices[], int ind, int buySell, int n, int fee, int dp[][])
    {
        if(ind >= n){
            if(buySell == 0)
                return 0;
            return (int)-1e9;
        }
        if(dp[ind][buySell] != -1)
            return dp[ind][buySell];
        int notBuyOrSell = dfs(prices, ind+1, buySell, n, fee, dp);
        int buyOrSell = 0;
        if(buySell == 0)
            buyOrSell = (dfs(prices, ind+1, 1, n, fee, dp) - prices[ind]) - fee;
        else
            buyOrSell = prices[ind] + dfs(prices, ind+1, 0, n, fee, dp);
        dp[ind][buySell] = Math.max(notBuyOrSell, buyOrSell);
        return Math.max(notBuyOrSell, buyOrSell);
    }
    public int maxProfit(int[] prices, int fee)
    {
        int n = prices.length;
        int dp[][] = new int[n][2];
        for(int i=0; i<n; i++){
            for(int j=0; j<2; j++){
                dp[i][j] = -1;
            }
        }
        int a = dfs(prices, 0, 0, n, fee, dp);
        return a;
    }
}
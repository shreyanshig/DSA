class Solution {
    public int dfs(int prices[], int ind, int n, int k, int buySell, int dp[][][])
    {
        if(ind >= n){
            if(buySell == 0)
                return 0;
            return (int)-1e9;
        }
        if(dp[ind][k][buySell] != -1)
            return dp[ind][k][buySell];
        int notBuyOrSell = dfs(prices, ind+1, n, k, buySell, dp);
        int buyOrSell = (int)-1e9;
        if(k > 0 && buySell == 0)
            buyOrSell = dfs(prices, ind+1, n, k-1, 1, dp) - prices[ind];
        else if(buySell == 1)
            buyOrSell = prices[ind] + dfs(prices, ind+1, n, k, 0, dp);
        dp[ind][k][buySell] = Math.max(notBuyOrSell, buyOrSell);
        return Math.max(notBuyOrSell, buyOrSell);
    }
    public int maxProfit(int k, int[] prices)
    {
        int n = prices.length;
        int dp[][][] = new int[n][k+1][2];
        for(int i=0; i<n; i++){
            for(int j=0; j<k+1; j++){
                for(int K=0; K<2; K++){
                    dp[i][j][K] = -1;
                }
            }
        }
        int a = dfs(prices, 0, n, k, 0, dp);
        return a;
    }
}
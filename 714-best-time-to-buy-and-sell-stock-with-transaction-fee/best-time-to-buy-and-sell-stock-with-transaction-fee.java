class Solution {
    public int maxProfit(int[] prices, int fee)
    {
        int n = prices.length;
        int dp[][] = new int[n+1][2];
        dp[n][0] = 0;
        dp[n][1] = (int)-1e9;
        for(int ind=n-1; ind>=0; ind--){
            for(int buySell=0; buySell<2; buySell++){
                int notBuyOrSell = dp[ind+1][buySell];
                int buyOrSell = 0;
                if(buySell == 0)
                    buyOrSell = (dp[ind+1][1] - prices[ind]) - fee;
                else
                    buyOrSell = prices[ind] + dp[ind+1][0];
                dp[ind][buySell] = Math.max(notBuyOrSell, buyOrSell);
            }
        }
        return dp[0][0];
    }
}
class Solution {
    public int maxProfit(int[] prices, int fee)
    {
        int n = prices.length;
        int prev[] = new int[2];
        prev[0] = 0;
        prev[1] = (int)-1e9;
        for(int ind=n-1; ind>=0; ind--){
            int current[] = new int[2];
            for(int buySell=0; buySell<2; buySell++){
                int notBuyOrSell = prev[buySell];
                int buyOrSell = 0;
                if(buySell == 0)
                    buyOrSell = (prev[1] - prices[ind]) - fee;
                else
                    buyOrSell = prices[ind] + prev[0];
                current[buySell] = Math.max(notBuyOrSell, buyOrSell);
            }
            prev = current;
        }
        return prev[0];
    }
}
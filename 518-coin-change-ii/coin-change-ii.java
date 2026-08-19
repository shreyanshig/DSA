class Solution {
    public int change(int amount, int[] coins)
    {
        int n = coins.length;
        int prev[] = new int[amount+1];
        for(int t=0; t<amount+1; t++){
            if(t % coins[0] == 0)
                prev[t] = 1;
        }
        for(int i=1; i<n; i++){
            int current[] = new int[amount+1];
            for(int t=0; t<amount+1; t++){
                int notTake = prev[t];
                int take = 0;
                if(t - coins[i] >= 0)
                    take = current[t-coins[i]];
                current[t] = notTake + take;
            }
            prev = current;
        }
        return prev[amount];
    }
}
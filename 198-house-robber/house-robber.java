class Solution {
    public int rob(int[] nums)
    {
        int n = nums.length;
        int dp[] = new int[n+2];
        dp[n] = 0;
        for(int ind=n-1; ind>=0; ind--){
            int notTake = dp[ind+1];
            int take = nums[ind] + dp[ind+2];
            dp[ind] = Math.max(notTake, take);
        }
        return dp[0];
    }
}
class Solution {
    public int dfs(int nums[], int ind, int n, int dp[])
    {
        if(ind >= n)
            return 0;
        if(dp[ind] != -1)
            return dp[ind];
        int notTake = dfs(nums, ind+1, n, dp);
        int take = nums[ind] + dfs(nums, ind+2, n, dp);
        dp[ind] = Math.max(notTake, take);
        return Math.max(notTake, take);
    }
    public int rob(int[] nums)
    {
        int n = nums.length;
        int dp[] = new int[n];
        for(int i=0; i<n; i++){
            dp[i] = -1;
        }
        int a = dfs(nums, 0, n, dp);
        return a;
    }
}
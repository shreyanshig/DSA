class Solution {
    public boolean isPalin(String s, int i, int j)
    {
        while(i <= j){
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
    public int dfs(int ind, int n, String s, int dp[])
    {
        if(ind >= n)
            return 0;
        if(dp[ind] != -1)
            return dp[ind];
        int min = (int)1e9;
        for(int j=ind; j<n; j++){
            if(isPalin(s, ind, j))
                min = Math.min(min, 1 + dfs(j+1, n, s, dp));
        }
        dp[ind] = min;
        return min;
    }
    public int minCut(String s)
    {
        int n = s.length();
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        int a = dfs(0, s.length(), s, dp);
        return a-1;
    }
}
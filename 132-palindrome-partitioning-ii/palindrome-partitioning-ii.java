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
    public int minCut(String s)
    {
        int n = s.length();
        int dp[] = new int[n+1];
        dp[n] = 0;
        for(int i=n-1; i>=0; i--){
            int min = (int)1e9;
            for(int j=i; j<n; j++){
                if(isPalin(s, i, j))
                    min = Math.min(min, 1 + dp[j+1]);
            }
            dp[i] = min;
        }
        return dp[0] - 1;
    }
}
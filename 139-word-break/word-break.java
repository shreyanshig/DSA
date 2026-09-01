class Solution {
    public boolean dfs(String s, int ind, int n, HashSet<String> hs, int dp[])
    {
         if(ind == n)
            return true;
         if(dp[ind] != -1)
            return dp[ind] == 1;
         for(int j=ind; j<n; j++){
            String word = s.substring(ind, j+1);
            if(hs.contains(word)){
                boolean tf = dfs(s, j+1, n, hs, dp);
                if(tf){
                    dp[ind] = 1;
                    return true;
                }
            }
         }
        dp[ind] = 0;
        return false;
    }
    public boolean wordBreak(String s, List<String> wordDict)
    {
        HashSet<String> hs = new HashSet<String>();
        for(String temp: wordDict){
            hs.add(temp);
        }
        int dp[] = new int[s.length()];
        for(int i=0; i<s.length(); i++){
           dp[i] = -1;
        }
        boolean tf = dfs(s, 0, s.length(), hs, dp);
        return tf;
    }
}
class Solution {
    public boolean dfs(String s, int i, int j, int n, HashSet<String> hs, int dp[][])
    {
         if(j == n-1){
            if(hs.contains(s.substring(i , j+1)))
                return true;
            return false;
         }
         if(dp[i][j] != -1)
            return dp[i][j] == 1;
         boolean notPart = dfs(s, i, j+1, n, hs, dp);
         boolean part = false;
         if(hs.contains(s.substring(i, j+1)))
            part = dfs(s, j+1, j+1, n, hs, dp);
        dp[i][j] = ((notPart | part) ? 1 : 0);
        return notPart | part;
    }
    public boolean wordBreak(String s, List<String> wordDict)
    {
        HashSet<String> hs = new HashSet<String>();
        for(String temp: wordDict){
            hs.add(temp);
        }
        int dp[][] = new int[s.length()][s.length()];
        for(int i=0; i<s.length(); i++){
            for(int j=0; j<s.length(); j++){
                dp[i][j] = -1;
            }
        }
        boolean tf = dfs(s, 0, 0, s.length(), hs, dp);
        return tf;
    }
}
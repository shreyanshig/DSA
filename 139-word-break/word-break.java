class Solution {
    public boolean wordBreak(String s, List<String> wordDict)
    {
        int n = s.length();
        HashSet<String> hs = new HashSet<String>();
        for(String temp: wordDict){
            hs.add(temp);
        }
        boolean dp[] = new boolean[n+1];
        dp[n] = true;
        for(int ind=n-1; ind>=0; ind--){
            for(int j=ind; j<n; j++){
                if(hs.contains(s.substring(ind, j+1)) && dp[j+1] == true){
                    dp[ind] = true;
                    break;
                }
            }
        }
        return dp[0];
    }
}
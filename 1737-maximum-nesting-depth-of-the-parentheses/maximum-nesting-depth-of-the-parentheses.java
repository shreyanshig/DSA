class Solution {
    public int maxDepth(String s)
    {
        int openBracket = 0;
        int max = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '(')
                openBracket++;
            else if(s.charAt(i) == ')')
                openBracket--;
            max = Math.max(max, openBracket);
        }
        return max;
    }
}
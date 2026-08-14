class Solution {
    public int maximumLengthSubstring(String s)
    {
        int temp[] = new int[26];
        int i = 0;
        int j = 0;
        int max = 0;
        while(i < s.length()){
            char ch = s.charAt(i);
            int ind = ch - 97;
            while(j < i && temp[ind] >= 2){
                temp[s.charAt(j)-97]--;
                j++;
            }
            max = Math.max(max, i-j+1);
            temp[ind]++;
            i++;
        }
        return max;
    }
}
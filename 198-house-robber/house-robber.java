class Solution {
    public int rob(int[] nums)
    {
        int n = nums.length;
        int next = 0;
        int nextToNext = 0;
        for(int ind=n-1; ind>=0; ind--){
            int notTake = next;
            int take = nums[ind] + nextToNext;
            nextToNext = next;
            next = Math.max(notTake, take);
        }
        return next;
    }
}
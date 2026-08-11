class Solution {
    public int missingInteger(int[] nums)
    {
        HashSet<Integer> hs = new HashSet<Integer>();
        int sum = nums[0];
        int ind = -1;
        hs.add(nums[0]);
        for(int i=1; i<nums.length; i++){
            if(nums[i] != nums[i-1] + 1)
                ind = i;
            if(ind == -1)
                sum += nums[i];
            else
                hs.add(nums[i]);
        }
        while(true){
            if(hs.contains(sum) == false)
                return sum;
            sum++;
        }
    }
}
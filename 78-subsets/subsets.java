class Solution {
    public List<List<Integer>> subsets(int[] nums)
    {
        int n = nums.length;
        Arrays.sort(nums);
        HashSet<ArrayList<Integer>> hs = new HashSet<ArrayList<Integer>>();
        int subSets = 1 << n;
        for(int num=0; num<subSets; num++){
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for(int i=0; i<n; i++){
                if((num & (1 << i)) != 0)
                    temp.add(nums[i]);
            }
            hs.add(temp);
        }
        List<List<Integer>> al = new ArrayList<List<Integer>>();
        for(ArrayList<Integer> temp: hs){
            al.add(temp);
        }
        return al;
    }
}
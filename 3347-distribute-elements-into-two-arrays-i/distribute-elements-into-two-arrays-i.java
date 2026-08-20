class Solution {
    public int[] resultArray(int[] nums)
    {
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        s1.push(nums[0]);
        s2.push(nums[1]);
        for(int i=2; i<nums.length; i++){
            if(s1.peek() > s2.peek())
                s1.push(nums[i]);
            else
                s2.push(nums[i]);
        }
        int arr[] = new int[nums.length];
        for(int i=arr.length-1; i>=0; i--){
            if(s2.isEmpty() == false)
                arr[i] = s2.pop();
            else
                arr[i] = s1.pop();
        }
        return arr;
    }
}
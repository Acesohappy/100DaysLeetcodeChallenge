class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0)
        return 0;
        Arrays.sort(nums);
        int max=0;
        int ptr=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i+1]==nums[i])
            continue;
            else if(nums[i+1]==nums[i]+1){
            ptr++;
            max=Math.max(max,ptr);
            }
            else
            ptr=0;

        }
        return max+1;
        
    }
}

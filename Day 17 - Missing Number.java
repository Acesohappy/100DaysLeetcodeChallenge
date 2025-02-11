class Solution {
    public int missingNumber(int[] nums) {
        int ans=0;
        int len=nums.length;
        int i=0;
        for(i=0;i<len;i++){
            ans=ans^i^nums[i];
        }
        return ans^i;
        
    }
}

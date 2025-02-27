class Solution {
    public int removeDuplicates(int[] nums) {
        int n=nums.length;
        int k=0;
        int temp=nums[0];
        for(int i=1;i<n;i++){
            if(temp!=nums[i]){
                temp=nums[i];
                k++;
                nums[k]=nums[i];
            }
            else
            continue;
        }
        return k+1;
    }
}

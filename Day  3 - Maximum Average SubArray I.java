class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double avg=0;//comment
        double sum=0;
        double max=0;
        for(int j=0;j<k;j++)
        {
            sum+=nums[j];
        }
        avg=sum/k;
        max=avg;
        for(int i=k;i<nums.length;i++)
        {
            sum=sum-(nums[i-k])+nums[i];
            avg=sum/k;
            max=Math.max(max, avg);
        }
        return max;   //commgft 
    }
}

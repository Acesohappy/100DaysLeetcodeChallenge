class Solution {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> que=new PriorityQueue<>();
        for(int i=0;i<nums.length;i++)
        {
            que.add(nums[i]);//comment
        }
        for(int i=0;i<nums.length-k;i++)
        {
            que.remove();
        }
        return que.peek();
    }
}

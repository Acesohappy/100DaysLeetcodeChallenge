class Solution {
    public int maxArea(int[] height) {
        int len=height.length;
        int i=0;
        int j=len-1;
        int res=0;
        while(i<j)
        {
            int m=(j-i)*(Math.min(height[i],height[j]));
            res=Math.max(res,m);
            if(height[i]<=height[j])
            {
                i++;
            }
            else
            {
                j--;
            }
        }
        return res;
    }
}

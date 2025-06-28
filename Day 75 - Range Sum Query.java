class NumArray {
    private int[] prefixArr;

    public NumArray(int[] nums) {
        int n = nums.length;
        prefixArr = new int[n];
        prefixArr[0] = nums[0]; // First element would be the same as there are no previous elements.

        for (int i = 1; i < n; i++) {
            prefixArr[i] = prefixArr[i - 1] + nums[i]; // Build prefix array
        }
    }

    public int sumRange(int left, int right) {
        if(left == 0) return prefixArr[right];
        return prefixArr[right] - prefixArr[left - 1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */

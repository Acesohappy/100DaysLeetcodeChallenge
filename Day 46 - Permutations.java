class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        back(0, nums, new LinkedList<>(), res);
        return res;
    }
    private void back(int i, int[] nums, List<Integer> ans, List<List<Integer>> res) {
        if (i == nums.length) {
            res.add(new ArrayList<>(ans));
            return;
        }

        for (int j = 0; j<=i; j++) {
            ans.add(j, nums[i]);
            back(i+1, nums, ans, res);
            ans.remove(j);
        }
    }
}

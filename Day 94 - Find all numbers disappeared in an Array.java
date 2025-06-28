class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        boolean [] hash = new boolean[nums.length +1];
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < nums.length;i++) {
            if(hash[nums[i]] == false) {
                hash[nums[i]] = true;
            }
        }
        for(int i = 1;i <= nums.length;i++) {
            if(!hash[i]) {
                result.add(i);
            }
        }
        return result;
    }
}

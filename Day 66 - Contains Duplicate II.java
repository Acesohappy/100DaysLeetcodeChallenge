class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // Accepted : Beats 79.53%
        int index = 0;
        Map<Integer, Integer> map = new HashMap();
        for(int i : nums){
            if(map.containsKey(i) && index - map.get(i) <= k){
                return true;
            }
            map.put(i, index);
            index++;
        }
        return false;
    }
}

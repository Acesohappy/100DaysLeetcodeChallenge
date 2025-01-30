class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int l = 0;
        int max = 0; 
        HashMap<Character, Integer> map = new HashMap<>();

        for (int r = 0; r < n; r++) {
            char curr = s.charAt(r);
            map.put(curr, map.getOrDefault(curr, 0)+1);
            while (map.get(curr) > 1) {
                char lChar = s.charAt(l);
                map.put(lChar, map.get(lChar) - 1);
                l++;
            }
            max = Math.max(max, r - l + 1);
        }
        return max;    
    }
}

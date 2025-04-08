class Solution {
    public int maximumLengthSubstring(String s) {
        int n = s.length();
        int left = 0;
        int max = 0; 
        HashMap<Character, Integer> map = new HashMap<>();//comment

        for (int right = 0; right < n; right++) {
            char curr = s.charAt(right);
            map.put(curr, map.getOrDefault(curr, 0)+1);
            while (map.get(curr) > 2) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                left++;
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}

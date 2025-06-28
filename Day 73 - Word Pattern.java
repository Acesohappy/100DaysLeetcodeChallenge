class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }
        HashMap<Character, String> myHash = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char currChar = pattern.charAt(i);
            String currWord = words[i];
            String a = myHash.get(currChar);
            if (a == null) {
                if (myHash.containsValue(currWord))
                    return false;
                myHash.put(currChar, currWord);
                continue;
            }
            if (!a.equals(currWord)) {
                return false;
            }
        }
        return true;
    }
}

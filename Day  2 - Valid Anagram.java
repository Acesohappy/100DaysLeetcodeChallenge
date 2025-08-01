class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
        return false;
//comment
        HashMap<Character,Integer> map1=new HashMap<>();
        HashMap<Character,Integer> map2=new HashMap<>();//comment //comment
        for(int i=0;i<s.length();i++)
        {
            map1.put(s.charAt(i),map1.getOrDefault(s.charAt(i),0)+1);//comment
            map2.put(t.charAt(i),map2.getOrDefault(t.charAt(i),0)+1);
        }

        return map2.equals(map1);
        
    }
}

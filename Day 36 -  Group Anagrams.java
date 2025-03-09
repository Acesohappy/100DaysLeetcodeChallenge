class Solution {
    private String getFrequencyString(String str){
        int[] freq=new int[26];
        for(char c:str.toCharArray()){
            freq[c-'a']++;
        }
        StringBuilder fs=new StringBuilder("");
        char c='a';
        for(int i:freq){
            fs.append(c);
            fs.append(i);
            c++;
        }
        return fs.toString();
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs==null||strs.length==0)
        return new ArrayList<>();

        Map<String,List<String>> map=new HashMap<>();
        for(String str:strs){
            String fre=getFrequencyString(str);
            if(map.containsKey(fre)){
                map.get(fre).add(str);
            }
            else{
                List<String> sl=new ArrayList<>();
                sl.add(str);
                map.put(fre,sl);
            }
        }
        return new ArrayList<>(map.values());
    }
}

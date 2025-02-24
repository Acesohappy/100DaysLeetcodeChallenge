class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> seen=new HashSet();
        HashSet<String> duplicate=new HashSet();
        for(int i=0;i+9<s.length();i++)
        {
            String temp=s.substring(i,i+10);
            if(seen.contains(temp))
                duplicate.add(temp);
            else
                seen.add(temp);
        }
        return new ArrayList(duplicate);
    }
}

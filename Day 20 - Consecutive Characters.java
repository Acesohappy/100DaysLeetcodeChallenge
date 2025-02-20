class Solution {
    public int maxPower(String s) {
        int max=0;
        int curr=0;
        char ch=s.charAt(0);
        for(int i=0;i<s.length();i++){
            if(ch==s.charAt(i)){
                curr++;
            }else{
                ch=s.charAt(i);
                curr=1;
            }
            max=Math.max(max,curr);
        }
        return max;//comment
    }
}

class Solution {
    public char findTheDifference(String s, String t) {
        if(s.length()==0)
            return t.charAt(0);
        char arr[] = s.toCharArray();
        char arr1[]= t.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=arr1[i])
                  return arr1[i];
        }
        return arr1[arr1.length-1];
    }
}

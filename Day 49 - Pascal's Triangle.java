class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        result.add(1);
        ans.add(result);
        for(int i=1; i<numRows; i++){
            result = new ArrayList<>();
            result.add(1);
            for(int j=1; j<i; j++){
                result.add(ans.get(i-1).get(j-1) + ans.get(i-1).get(j));
            }
            result.add(1);
            ans.add(result);
        }
        return ans;
    }
}

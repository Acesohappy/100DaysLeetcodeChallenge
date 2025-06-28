class Solution {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) return false;
        for (int i = 0; i < 1291; i++) if (Math.pow(3, i) == n) return true;
        return false;
    }
}

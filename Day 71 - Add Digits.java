class Solution {
    public int addDigits(int num) {
        while(num>9)
        {
            int rem = num%10;
            int fnum = num/10;
            num = fnum + rem;
        }
        return num;
    }
}

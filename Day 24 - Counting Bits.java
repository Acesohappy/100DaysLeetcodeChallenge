class Solution {
    public int[] countBits(int n) {
        int[] arr=new int[n+1];
        for(int i=0;i<=n;i++){
            int setbits=findSetBits(i);
            arr[i]=setbits;
        }
        return arr;
    }
    private int findSetBits(int num){
        int setbits=0;
        while(num!=0){
            num=num&(num-1);
            setbits++;
        }
        return setbits;
    }
}

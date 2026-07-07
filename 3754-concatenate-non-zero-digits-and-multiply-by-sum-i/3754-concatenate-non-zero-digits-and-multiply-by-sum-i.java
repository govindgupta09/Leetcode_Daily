class Solution {
    public long sumAndMultiply(int n) {
        long sum=0, res=0, digit=1;
        while(n>0){
            int val = n%10;
            if(val>0){
                res = val*digit+res;
                sum+=val;
                digit*=10;
            }
            n/=10;
        }
        return res*sum;
    }
}
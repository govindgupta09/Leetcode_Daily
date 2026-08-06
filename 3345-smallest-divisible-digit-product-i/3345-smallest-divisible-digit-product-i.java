class Solution {
    public int smallestNumber(int n, int t) {
        boolean bool = true;
        int res = n;
        while(bool){
            int val = 1;
            int num = res;
            while(num>0){
            int digit = num%10;
            val*=digit;
            num/=10;
            }
            if(val%t == 0){
                bool = false;
            }else{
                res++;
            }
        }
        return res;
    }
}
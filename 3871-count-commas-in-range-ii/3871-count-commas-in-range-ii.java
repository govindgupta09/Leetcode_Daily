class Solution {
    public long countCommas(long n) {

        long count=0;
        long start=1000;
        long commas=1;
        if(n<1000){
            return 0;
        }else{
            while(start<=n){
                long end = start*1000-1;
                count += Math.max(0, Math.min(n, end)-start+1)*commas;
                start*=1000;
                commas++;
            }
        }
        return count;
    }
}
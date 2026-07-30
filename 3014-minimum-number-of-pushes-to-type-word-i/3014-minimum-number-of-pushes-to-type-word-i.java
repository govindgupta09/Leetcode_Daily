class Solution {
    public int minimumPushes(String word) {
        int len = word.length();
        int res = 0;
        if(len<=8){
            res = len;
        }else if(len>8 && len<17){
            res = 8+2*(len-8);
        }else if(len>16 && len<25){
            res = 24+3*(len-16);
        }else{
            res = 48+4*(len-24);
        }
        return res;
    }
}
class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int lhsCount = 0, lhsSum=0;
        int rhsCount = 0, rhsSum=0;
        for(int i=0;i<n;i++){
            if(num.charAt(i) == '?'){
                if(i<n/2){
                    lhsCount++;
                }else{
                    rhsCount++;
                }
            }else{
                if(i<n/2){
                    lhsSum+=num.charAt(i)-'0';
                }else{
                    rhsSum+=num.charAt(i)-'0';
                }
            }
        }
        int lhs = 2*lhsSum + 9*lhsCount;
        int rhs = 2*rhsSum + 9*rhsCount;
        if(lhs == rhs){
            return false;
        }
        return true;
    }
}
import java.util.*;

class Solution {
    public int maxProduct(int n) {
        int mul=1;
        int num = n;
        int max = Integer.MIN_VALUE;
        List<Integer> list = new ArrayList<>();
        while(num>0){
            int unit = num%10;
            list.add(unit);
            num /=10;
        }
        for(int i=0;i<list.size();i++){
            for(int j=0;j!=i && j<list.size();j++){
                mul = list.get(i)*list.get(j);
                if(mul>max){
                    max = mul;
                }
            }
        }
        return max;
    }
}
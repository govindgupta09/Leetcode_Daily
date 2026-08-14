class Solution {
    public int maximumLengthSubstring(String s) {
        int n = s.length();
        int i=0, res=0;
        Map<Character, Integer> map = new HashMap<>();
        for(int j=0;j<n;j++){
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0)+ 1);
            while(map.get(s.charAt(j)) > 2){
                map.put(s.charAt(i),map.get(s.charAt(i))-1);
                i++;
            }
            res = Math.max(res, j-i+1);
        }
        return res;      
    }
}
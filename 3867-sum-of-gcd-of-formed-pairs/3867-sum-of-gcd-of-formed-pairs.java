class Solution {
    private int gcd(int a, int b){
        while(b != 0){
            int t=a%b;
            a=b;
            b=t;
        }
        return a;
    }
    public long gcdSum(int[] nums) {
        int[] temp = Arrays.copyOf(nums, nums.length);
        int[] prefGcd = new int[nums.length];

        int max = temp[0];
        for(int i=0;i<nums.length;i++){
            max = Math.max(max, temp[i]);
            prefGcd[i]=gcd(temp[i], max);
        }

        Arrays.sort(prefGcd);

        int left=0;
        int right=nums.length-1;
        long sum=0;

        while(left<right){
            sum+=gcd(prefGcd[left],prefGcd[right]);
            left++;
            right--;
        }
        return sum;
    }
}
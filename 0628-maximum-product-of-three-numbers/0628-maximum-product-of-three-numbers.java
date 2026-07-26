class Solution {
    public int maximumProduct(int[] nums) {
        for(int r=1;r<nums.length;r++){
            int key = nums[r];
            int l=r-1;
            while(l>=0 && nums[l]>key){
                nums[l+1]=nums[l];
                l--;
            }
            nums[l+1]=key;
        }
        int mul = 1;
        for(int j=nums.length-1;j>=nums.length-3;j--){
            mul*=nums[j];
        }
        int mul2=nums[0]*nums[1]*nums[nums.length-1];
        
        if(mul2>mul){
            return mul2;
        }
        return mul;
    }
}
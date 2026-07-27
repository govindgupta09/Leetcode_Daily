class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length-1;
        //Arrays.sort(nums);
        for(int r=1;r<nums.length;r++){
            int key = nums[r];
            int l=r-1;
            while(l>=0 && nums[l]>key){
                nums[l+1]=nums[l];
                l--;
            }
            nums[l+1]=key;
        }
        return ((nums[n-1]-1)*(nums[n]-1));
    }
}
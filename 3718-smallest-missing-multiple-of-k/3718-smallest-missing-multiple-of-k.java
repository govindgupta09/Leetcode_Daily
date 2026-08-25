class Solution {
    boolean binarySearch(int[] nums, int val){
        int start = 0, end = nums.length-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(nums[mid] == val){
                return true;
            }else if(val>nums[mid]){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return false;
    }
    public int missingMultiple(int[] nums, int k) {
        Arrays.sort(nums);
        for(int i=1;i<nums.length+2;i++){
            System.out.println(binarySearch(nums, k*i));
            if(!binarySearch(nums, k*i)){
                return k*i;
            }
        }
        return -1;
    }
}
class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int count = 0;
        for(int i=0;i<n;i++){
            int tempCount = 0;
            for(int j=i;j<n;j++){
                if(nums[j]==target){
                    tempCount++;
                }
                if(tempCount>(j-i+1)/2){
                    count++;
                }
            }
        }
        return count;
    }
}
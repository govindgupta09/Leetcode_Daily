class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        int total = 0;
        for(int num:  nums){
            total+=num;
        }
        int p1_score = solve(0,n-1, nums);
        int p2_score = total-p1_score;
        return p1_score>=p2_score;
    }
    private int solve(int i, int j, int[] nums){
        if(i>j) return 0;
        if(i==j) return nums[i];

        int take_i = nums[i]+ Math.min(solve(i+2, j, nums), solve(i+1, j-1, nums));

        int take_j = nums[j] + Math.min(solve(i, j-2, nums), solve(i+1, j-1, nums));

        return Math.max(take_i, take_j);
    }
}
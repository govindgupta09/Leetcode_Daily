class Solution {
    public boolean stoneGame(int[] piles) {

        return true;

        // int n = piles.length;
        // int total = 0;
        // for(int pile: piles){
        //     total+=pile;
        // }

        // int alice_Score = solve(0, n-1, piles);
        // int bob_Score = total - alice_Score;

        // return alice_Score>bob_Score;
        
    }

    private int solve(int i, int j, int[] piles){

        if(i>j) return 0;
        if(i==j) return piles[i];

        int item_i = piles[i] + Math.min(solve(i+2, j, piles), solve(i+1, j-1, piles));
        int item_j = piles[j] + Math.min(solve(i+1, j-1, piles), solve(i, j-2, piles));

        return Math.max(item_i, item_j);
    }
}
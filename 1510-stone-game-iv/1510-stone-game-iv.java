// class Solution {
//     public boolean winnerSquareGame(int n) {
//         return solve(n);
//     }

//     boolean solve(int n){
//         if(n == 0) return false;
//         for(int k=1;k*k<=n;k++){
//             if(solve(n-(k*k)) == false){
//                 return true;
//             }
//         }
//         return false;
//     }
// }

class Solution {
    public boolean winnerSquareGame(int n) {

        boolean[] dp = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {

            for (int k = 1; k * k <= i; k++) {

                if (!dp[i - k * k]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}
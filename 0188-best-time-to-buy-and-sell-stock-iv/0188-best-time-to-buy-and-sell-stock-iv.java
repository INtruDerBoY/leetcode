class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;

        int[][][] dp = new int[n][2][k+1];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < 2; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }

        return solve(0, 1, k, prices, dp);
    }

    public int solve(int i, int buy, int cap,
                     int[] prices, int[][][] dp){

        int n = prices.length;

        if(i == n || cap == 0){
            return 0;
        }

        if(dp[i][buy][cap] != -1){
            return dp[i][buy][cap];
        }

        int profit;

        if(buy == 1){

            int take = -prices[i] +
                       solve(i+1, 0, cap, prices, dp);

            int notTake = solve(i+1, 1, cap, prices, dp);

            profit = Math.max(take, notTake);

        }
        else{

            int take = prices[i] +
                       solve(i+1, 1, cap-1, prices, dp);

            int notTake = solve(i+1, 0, cap, prices, dp);

            profit = Math.max(take, notTake);
        }

        return dp[i][buy][cap] = profit;
    }
}
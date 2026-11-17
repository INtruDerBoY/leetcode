
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[][] dp = new int[n][2];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(0, 1, prices, dp);
    }

    public int solve(int i, int buy, int[] prices, int[][] dp) {

        int n = prices.length;

        if (i >= n) {
            return 0;
        }
        if (dp[i][buy] != -1) {
            return dp[i][buy];
        }

        int profit;

        if (buy == 1) {
            int take = -prices[i] + solve(i + 1, 0, prices, dp);
            int notTake = solve(i + 1, 1, prices, dp);

            profit = Math.max(take, notTake);

        } else {
            int take = prices[i] + solve(i + 2, 1, prices, dp);
            int notTake = solve(i + 1, 0, prices, dp);

            profit = Math.max(take, notTake);
        }

        return dp[i][buy] = profit;
    }
}

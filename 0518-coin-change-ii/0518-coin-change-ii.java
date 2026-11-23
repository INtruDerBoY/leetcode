
import java.util.*;

class Solution {

    public int change(int amount, int[] coins) {

        int n = coins.length;

        int[][] dp = new int[n][amount + 1];

        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(n - 1, amount, coins, dp);
    }

    public int solve(int index, int amount, int[] coins, int[][] dp) {

        if(index == 0) {
            if(amount % coins[0] == 0) {
                return 1;
            }
            return 0;
        }

        if(dp[index][amount] != -1) {
            return dp[index][amount];
        }

        int notPick = solve(index - 1, amount, coins, dp);

        int pick = 0;

        if(coins[index] <= amount) {
            pick = solve(index, amount - coins[index], coins, dp);
        }

        return dp[index][amount] = pick + notPick;
    }
}

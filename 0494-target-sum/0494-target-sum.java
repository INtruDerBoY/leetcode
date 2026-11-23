
class Solution {

    public int findTargetSumWays(int[] nums, int target) {

        int n = nums.length;

        int total = 0;

        for(int x : nums) {
            total += x;
        }

        if(Math.abs(target) > total) {
            return 0;
        }

        if((total - target) % 2 != 0) {
            return 0;
        }

        int k = (total - target) / 2;

        int[][] dp = new int[n][k + 1];

        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(n - 1, k, nums, dp);
    }

    public int solve(int index, int target, int[] nums, int[][] dp) {

        if(index == 0) {

            if(target == 0 && nums[0] == 0) return 2;

            if(target == 0 || target == nums[0]) return 1;

            return 0;
        }

        if(dp[index][target] != -1) {
            return dp[index][target];
        }

        int notPick = solve(index - 1, target, nums, dp);

        int pick = 0;

        if(nums[index] <= target) {
            pick = solve(index - 1, target - nums[index], nums, dp);
        }

        return dp[index][target] = pick + notPick;
    }
}

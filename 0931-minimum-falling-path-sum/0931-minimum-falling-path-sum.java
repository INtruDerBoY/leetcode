class Solution {
    public int minFallingPathSum(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];

       
        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j];
        }

      
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int up = matrix[i][j] + dp[i - 1][j];

                int left = matrix[i][j];
                if (j > 0) {
                    left += dp[i - 1][j - 1];
                } else {
                    left += 100000;
                }

                int right = matrix[i][j];
                if (j < n - 1) {
                    right += dp[i - 1][j + 1];
                } else {
                    right += 100000;
                }

                dp[i][j] = Math.min(up, Math.min(left, right));
            }
        }

        // Find minimum in last row
        int ans = Integer.MAX_VALUE;

        for (int j = 0; j < n; j++) {
            ans = Math.min(ans, dp[m - 1][j]);
        }

        return ans;
    }
}
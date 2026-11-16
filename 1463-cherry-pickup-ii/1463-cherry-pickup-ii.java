
class Solution {
    public int cherryPickup(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int[][][] dp = new int[m][n][n];

   
        for(int j1 = 0; j1 < n; j1++){
            for(int j2 = 0; j2 < n; j2++){

                if(j1 == j2){
                    dp[m-1][j1][j2] = grid[m-1][j1];
                }else{
                    dp[m-1][j1][j2] =
                        grid[m-1][j1] + grid[m-1][j2];
                }
            }
        }

     
        for(int i = m-2; i >= 0; i--){
            for(int j1 = 0; j1 < n; j1++){
                for(int j2 = 0; j2 < n; j2++){

                    int maxi = Integer.MIN_VALUE;

                    for(int d1 = -1; d1 <= 1; d1++){
                        for(int d2 = -1; d2 <= 1; d2++){

                            int nj1 = j1 + d1;
                            int nj2 = j2 + d2;

                            if(nj1 >= 0 && nj1 < n &&
                               nj2 >= 0 && nj2 < n){

                                maxi = Math.max(maxi,
                                    dp[i+1][nj1][nj2]);
                            }
                        }
                    }

                    int cherries;

                    if(j1 == j2){
    
                        cherries = grid[i][j1];
                    }else{
                        cherries = grid[i][j1] + grid[i][j2];
                    }

                    dp[i][j1][j2] = cherries + maxi;
                }
            }
        }

        return dp[0][0][n-1];
    }
}

class Solution {
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        if(sum % 2 !=0){
            return false;
        }
        int target=sum/2;
        Boolean[][] dp = new Boolean[n][target + 1];
        return solve(n-1,nums,target,dp);
    }
    private static boolean solve(int ind,int[] nums,int target,Boolean[][]dp){
        if(target==0){
            return false;
        }
           if (ind == 0) {
            return nums[0] == target;
        }
        if (dp[ind][target] != null) {
            return dp[ind][target];
        }
        boolean nottake = solve(ind-1,nums,target,dp);
        boolean take=false;
        if(nums[ind]<=target){
        take = solve(ind-1,nums,target-nums[ind],dp);
        }
        return dp[ind][target] = take || nottake;
    }
}
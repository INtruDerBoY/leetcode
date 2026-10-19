class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] po = new int[n];
        int[] ne = new int[n];
        int[] ans= new int[n];
        int p=0,q=0;
        for(int i=0;i<n;i++){
            if(nums[i]>0){
                po[p++]=nums[i];
            
            }else{
                ne[q++]=nums[i];
            }
        }
            for(int i=0;i<n/2;i++){
          ans[2*i]=po[i];
          ans[2*i+1]=ne[i];
            }
        
        return ans;
    }
}